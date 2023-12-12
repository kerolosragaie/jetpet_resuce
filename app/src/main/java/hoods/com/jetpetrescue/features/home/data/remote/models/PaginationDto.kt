package hoods.com.jetpetrescue.features.home.data.remote.models


import com.google.gson.annotations.SerializedName

data class PaginationDto(
    @SerializedName("count_per_page")
    val countPerPage: Int = 0,
    @SerializedName("total_count")
    val totalCount: Int = 0,
    @SerializedName("current_page")
    val currentPage: Int = 0,
    @SerializedName("total_pages")
    val totalPages: Int = 0,
    @SerializedName("_links")
    val links: LinksXDto ? = null,
)