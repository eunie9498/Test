package kong.droid.test.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kong.droid.test.R
import kong.droid.test.data.BookDetailItem
import kong.droid.test.data.BookItem
import kong.droid.test.databinding.ActivityMainBinding
import kong.droid.test.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    var isbnArr = ArrayList<String>()
    var customList: MutableList<BookDetailItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        init()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.searchResponse.removeObservers(this@MainActivity)
        viewModel.detailResponse.removeObservers(this@MainActivity)
    }

    private fun init() = with(binding) {
        recyclerView.adapter = Adapter()

        viewModel.getSearch("android")

        viewModel.searchResponse.observe(this@MainActivity) { response ->
            response.books?.let { arr ->
                arr.forEach {
                    isbnArr.add(it.isbn13!!)
                }
            }
            showList()
        }

    }

    private fun showList() = with(binding) {

        isbnArr.forEach {
            viewModel.getDetail(it)
            viewModel.detailResponse.observe(this@MainActivity) { response ->
                if (customList.contains(response).not())
                    customList.add(response)

                if (customList.size == isbnArr.size) {
                    recyclerView.adapter = Adapter()
                    (recyclerView.adapter as Adapter).addItem(customList)
                }
            }
        }
    }
}