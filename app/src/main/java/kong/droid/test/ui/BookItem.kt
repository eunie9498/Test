package kong.droid.test.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import kong.droid.test.databinding.BookItemBinding

class BookItem constructor(
    context: Context,
    attributeSet: AttributeSet? = null
): ConstraintLayout(context, attributeSet) {

    val binding = BookItemBinding.inflate(LayoutInflater.from(context), this, true)

    fun setData() {

    }

}