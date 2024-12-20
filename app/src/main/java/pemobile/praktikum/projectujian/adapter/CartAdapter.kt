package pemobile.praktikum.projectujian.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pemobile.praktikum.projectujian.R
import pemobile.praktikum.projectujian.model.CartItem

class CartAdapter(
    private val cartItems: List<CartItem>,
    private val onAdd: (CartItem) -> Unit,
    private val onMin: (CartItem) -> Unit
) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProduct: ImageView = itemView.findViewById(R.id.ivProduct)
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvProductPrice: TextView = itemView.findViewById(R.id.tvProductPrice)
        val tvQuantity: TextView = itemView.findViewById(R.id.tvQuantity)
        val imageButtonAdd: ImageButton = itemView.findViewById(R.id.imageButtonAdd)
        val imageButtonMin: ImageButton = itemView.findViewById(R.id.imageButtonMin)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_keranjang, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = cartItems[position]
        holder.tvName.text = cartItem.title
        holder.tvProductPrice.text = "Rp ${cartItem.price}"
        holder.tvQuantity.text = cartItem.quantity.toString()
        holder.ivProduct.setImageResource(cartItem.image)

        holder.imageButtonAdd.setOnClickListener {
            onAdd(cartItem)
        }

        holder.imageButtonMin.setOnClickListener {
            onMin(cartItem)
        }
    }

    override fun getItemCount(): Int = cartItems.size
}