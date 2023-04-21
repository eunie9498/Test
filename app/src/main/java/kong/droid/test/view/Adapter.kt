package kong.droid.test.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kong.droid.test.data.BookDetailItem
import kong.droid.test.databinding.BookItemBinding

class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items = mutableListOf<BookDetailItem>()

    override fun getItemCount() = items.size

    fun addItem(arr: MutableList<BookDetailItem>) {
        items.addAll(arr)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ItemHolder
        holder.bind(items[position])
        holder.setIsRecyclable(false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemHolder(
            BookItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class ItemHolder(val binding: BookItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: BookDetailItem) {
            binding.item = data
            Glide.with(binding.root).load(data.image).into(binding.bookBg)
        }
    }
}