package hoods.com.jetpetrescue.features.home.data.repo

import hoods.com.jetpetrescue.core.utils.ResourceHolder
import hoods.com.jetpetrescue.features.home.data.mappers.fromDtoToModel
import hoods.com.jetpetrescue.features.home.data.remote.api.ApiService
import hoods.com.jetpetrescue.features.home.domain.models.Animal
import hoods.com.jetpetrescue.features.home.domain.repo.PetRepo

class PetRepoImpl(
    private val apiService: ApiService,
) : PetRepo {
    override suspend fun getAnimals(page: Int): ResourceHolder<List<Animal>> {
        return try {
            val data = apiService.getAnimals(page)
            val animalsList: List<Animal> =
                data.animalsDto!!.map { it.fromDtoToModel(data.pagination?.currentPage) }
            ResourceHolder.Success(animalsList)
        } catch (e: Exception) {
            e.printStackTrace()
            ResourceHolder.Error(e.cause!!)
        }
    }
}