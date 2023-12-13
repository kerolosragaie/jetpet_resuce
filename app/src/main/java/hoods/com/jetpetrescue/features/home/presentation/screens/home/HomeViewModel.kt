package hoods.com.jetpetrescue.features.home.presentation.screens.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hoods.com.jetpetrescue.core.utils.ResourceHolder
import hoods.com.jetpetrescue.features.home.data.Graph
import hoods.com.jetpetrescue.features.home.domain.models.Animal
import hoods.com.jetpetrescue.features.home.domain.pagination.LoadingStateListener
import hoods.com.jetpetrescue.features.home.domain.pagination.PetPaginationImpl
import hoods.com.jetpetrescue.features.home.domain.repo.PetRepo
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repo: PetRepo = Graph.petRepo,
) : ViewModel(), LoadingStateListener<ResourceHolder<List<Animal>>> {

    companion object {
        const val TAG = "HomeViewModel"
    }

    var uiState by mutableStateOf(UiState())
    private val petPagination = PetPaginationImpl(
        initialKey = getPage(uiState.animals.data),
        loadingState = this,
        onRequest = { page ->
            if (uiState.isFetchingPet) return@PetPaginationImpl ResourceHolder.Loading()
            val animals = fetchAnimals(page)
            animals
        },
        getNextPage = { result ->
            getPage(result.data)
        }
    )

    init {
        loadNextAnimalsPage()
    }

    fun loadNextAnimalsPage() {
        viewModelScope.launch {
            petPagination.fetchNextPage()
        }
    }

    fun onInfiniteScrollChange(start: Boolean) {
        uiState = uiState.copy(startInfiniteScrolling = start)
    }

    private fun getPage(pageSource: List<Animal>?): Int {
        return if (pageSource?.isEmpty() == true) {
            pageSource[pageSource.lastIndex].currentPage + 1
        } else
            1
    }

    private suspend fun fetchAnimals(page: Int): ResourceHolder<List<Animal>> =
        repo.getAnimals(page)

    override fun onLoadingStateChanged(isLoading: Boolean) {
        uiState = uiState.copy(isFetchingPet = isLoading)
    }

    override fun onError(error: Throwable) {
        Log.e(TAG, "onError: Fetching pet error", error)
    }

    override fun onDataFetched(data: ResourceHolder<List<Animal>>) {
        uiState = uiState.updateAnimals(newData = data)
    }

    private fun UiState.updateAnimals(newData: ResourceHolder<List<Animal>>): UiState {
        return when (newData) {
            is ResourceHolder.Success -> {
                val updatedData = this.animals.data?.combineData(newData.data!!) ?: newData
                copy(animals = updatedData)
            }

            is ResourceHolder.Error -> {
                copy(animals = newData)
            }

            else -> this@updateAnimals
        }
    }

    private fun <Data> List<Data>.combineData(newList: List<Data>): ResourceHolder<List<Data>> =
        ResourceHolder.Success(data = this.union(newList).toList())

}

data class UiState(
    val animals: ResourceHolder<List<Animal>> = ResourceHolder.Loading(),
    val isFetchingPet: Boolean = false,
    val moreBttnVisible: Boolean = true,
    val startInfiniteScrolling: Boolean = false,
)