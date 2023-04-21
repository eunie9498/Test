package kong.droid.test.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchResponse(
    var error: String? = "",
    var total: String? = "",
    var page: String? = "",
    var books: List<BookItem>? = emptyList()
) : Parcelable

@Parcelize
data class BookItem(
    var title: String? = "",
    var subtitle: String? = "",
    var isbn13: String? = "",
    var price: String? = "",
    var image: String? = "",
    var url: String? = ""
) : Parcelable

@Parcelize
data class BookDetailItem(
    var error: String? = "",
    var title: String? = "",
    var subtitle: String? = "",
    var authors: String? = "",
    var publisher: String? = "",
    var language: String? = "",
    var isbn10: String? = "",
    var isbn13: String? = "",
    var pages: String? = "",
    var year: String? = "",
    var rating: String? = "",
    var desc: String? = "",
    var price: String? = "",
    var image: String? = "",
    var url: String? = "",
) : Parcelable

