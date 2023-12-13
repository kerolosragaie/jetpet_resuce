package hoods.com.jetpetrescue.features.home.domain.pagination

interface PetPagination<Page, Content> {
    suspend fun fetchNextPage()
    fun resetPage()
}