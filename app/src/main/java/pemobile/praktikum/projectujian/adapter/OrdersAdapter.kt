package pemobile.praktikum.projectujian.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pemobile.praktikum.projectujian.R
import pemobile.praktikum.projectujian.model.Pesanan

class OrdersAdapter(private val orders: List<Pesanan>) :
    RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder>() {

    class OrdersViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val tvProductName: TextView = view.findViewById(R.id.tvProductName)
        val tvProductPrice: TextView = view.findViewById(R.id.tvProductPrice)
        val btnAction: Button = view.findViewById(R.id.btnAction)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pesanan_item, parent, false)
        return OrdersViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {
        val order = orders[position]
        holder.imageView.setImageResource(order.image)
        holder.tvProductName.text = order.title
        holder.tvProductPrice.text = "Rp ${order.price}"
        holder.btnAction.setOnClickListener { }
    }

    override fun getItemCount(): Int = orders.size
}
