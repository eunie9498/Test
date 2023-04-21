package kong.droid.test.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.engine.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kong.droid.test.data.BookDetailItem
import kong.droid.test.data.SearchResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: MainRepository): ViewModel() {
    var searchResponse = MutableLiveData<SearchResponse>()
    var detailResponse = MutableLiveData<BookDetailItem>()

    fun getSearch(query: String){
        viewModelScope.launch {
            try{
                searchResponse.postValue(repository.getSearch(query).body())
            } catch (e: Exception){
                searchResponse.postValue(SearchResponse(error = "1"))
            }
        }
    }

    fun getDetail(isbn13: String){
        viewModelScope.launch {
            try{
                detailResponse.postValue(repository.getDetail(isbn13).body())
            }
            catch (e: Exception){
                detailResponse.postValue(BookDetailItem(error = "1"))
            }
        }
    }
}