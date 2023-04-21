package kong.droid.test.viewmodel

import kong.droid.test.api.APIService
import javax.inject.Inject


class MainRepository @Inject constructor(val apiService: APIService) {
    suspend fun getSearch(query: String) = apiService.getSearch(query)
    suspend fun getDetail(isbn13: String) = apiService.getBookDetail(isbn13)
}