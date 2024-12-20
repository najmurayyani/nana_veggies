package pemobile.praktikum.projectujian.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class AllSpacingItemDecoration(private val spacing: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.left = spacing / 2
        outRect.right = spacing / 2
        outRect.top = spacing / 2
        outRect.bottom = spacing / 2
    }
}
