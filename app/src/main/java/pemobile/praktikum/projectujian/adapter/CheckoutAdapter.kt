package pemobile.praktikum.projectujian.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pemobile.praktikum.projectujian.R
import pemobile.praktikum.projectujian.model.CartItem

class CheckoutAdapter(private val cartItems: List<CartItem>) :
    RecyclerView.Adapter<CheckoutAdapter.CheckoutViewHolder>() {

    inner class CheckoutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.tv_name)
        val quantity: TextView = itemView.findViewById(R.id.tvQuantity)
        val price: TextView = itemView.findViewById(R.id.tvProductPrice)
        val ivProduct: ImageView = itemView.findViewById(R.id.ivProduct)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckoutViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_pembayaran, parent, false)
        return CheckoutViewHolder(view)
    }

    override fun onBindViewHolder(holder: CheckoutViewHolder, position: Int) {
        val cartItem = cartItems[position]
        holder.productName.text = cartItem.title
        holder.quantity.text = "Qty: ${cartItem.quantity}"
        holder.price.text = "Rp ${cartItem.price}"
        holder.ivProduct.setImageResource(cartItem.image)
    }

    override fun getItemCount(): Int = cartItems.size
}
