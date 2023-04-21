package kong.droid.test.api

import kong.droid.test.data.BookDetailItem
import kong.droid.test.data.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
interface APIService {
    @GET("search/{query}")
    suspend fun getSearch(
        @Path("query") query: String
    ): Response<SearchResponse>

    @GET("books/{isbn13}")
    suspend fun getBookDetail(
        @Path("isbn13") isbn13: String
    ): Response<BookDetailItem>
}