package pemobile.praktikum.projectujian.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pemobile.praktikum.projectujian.R
import pemobile.praktikum.projectujian.model.SpecialDeal

class SpecialDealsAdapter(
    private val deals: List<SpecialDeal>,
    private val onClick: (SpecialDeal) -> Unit
) :
    RecyclerView.Adapter<SpecialDealsAdapter.SpecialDealViewHolder>() {

    inner class SpecialDealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProductImage: ImageView = itemView.findViewById(R.id.ivProductImage)
        val tvProductTitle: TextView = itemView.findViewById(R.id.tvProductTitle)
        val tvProductPrice: TextView = itemView.findViewById(R.id.tvProductPrice)
        val tvSlashPrice: TextView = itemView.findViewById(R.id.tvSlashPrice)
        val btnAddToCart: ImageButton = itemView.findViewById(R.id.btnAddToCart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialDealViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_special_deal, parent, false)
        val screenWidth = Resources.getSystem().displayMetrics.widthPixels
        val itemWidth = screenWidth / 2 - 64
        view.layoutParams.width = itemWidth
        return SpecialDealViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpecialDealViewHolder, position: Int) {
        val deal = deals[position]
        holder.ivProductImage.setImageResource(deal.imageRes)
        holder.tvProductTitle.text = deal.title
        holder.tvProductPrice.text = "Rp. ${deal.price}"
        holder.tvSlashPrice.text = deal.slashPrice
        holder.itemView.setOnClickListener {
            onClick.invoke(deal)
        }
    }

    override fun getItemCount(): Int = deals.size
}