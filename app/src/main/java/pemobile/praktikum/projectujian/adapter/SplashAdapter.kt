package pemobile.praktikum.projectujian.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pemobile.praktikum.projectujian.R

class SplashAdapter(private val context: Context) : RecyclerView.Adapter<SplashAdapter.SplashViewHolder>() {

    private val splashLayouts = listOf(
        R.layout.splash_one,
        R.layout.splash_two,
        R.layout.splash_third
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SplashViewHolder {
        val view = LayoutInflater.from(context).inflate(viewType, parent, false)
        return SplashViewHolder(view)
    }

    override fun onBindViewHolder(holder: SplashViewHolder, position: Int) {}

    override fun getItemCount(): Int = splashLayouts.size

    override fun getItemViewType(position: Int): Int = splashLayouts[position]

    inner class SplashViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
