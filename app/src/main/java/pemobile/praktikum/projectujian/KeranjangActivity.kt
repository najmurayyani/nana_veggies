package pemobile.praktikum.projectujian

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pemobile.praktikum.projectujian.adapter.CartAdapter
import pemobile.praktikum.projectujian.adapter.VerticalSpacingItemDecoration
import pemobile.praktikum.projectujian.data.Cart
import pemobile.praktikum.projectujian.model.CartItem

class KeranjangActivity : AppCompatActivity() {

    private lateinit var rvKeranjang: RecyclerView
    private lateinit var totalPriceText: TextView
    private lateinit var backButton: ImageView
    private lateinit var orderButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.keranjang)

        rvKeranjang = findViewById(R.id.rvKeranjang)
        totalPriceText = findViewById(R.id.totalPrice)
        backButton = findViewById(R.id.backButton)
        orderButton = findViewById(R.id.orderButton)

        backButton.setOnClickListener {
            onBackPressed()
        }

        val adapter = CartAdapter(Cart.cartItems, ::onAddItem, ::onMinItem)
        rvKeranjang.layoutManager = LinearLayoutManager(this)
        rvKeranjang.addItemDecoration(VerticalSpacingItemDecoration(32))
        rvKeranjang.adapter = adapter

        updateTotalPrice()

        orderButton.setOnClickListener {
            val intent = Intent(this, PembayaranActivity::class.java)
            startActivity(intent)
        }
    }

    private fun onAddItem(cartItem: CartItem) {
        val updatedQuantity = cartItem.quantity + 1
        Cart.updateItemQuantity(cartItem, updatedQuantity)
        rvKeranjang.adapter?.notifyDataSetChanged()
        updateTotalPrice()
    }

    private fun onMinItem(cartItem: CartItem) {
        if (cartItem.quantity > 1) {
            val updatedQuantity = cartItem.quantity - 1
            Cart.updateItemQuantity(cartItem, updatedQuantity)
        } else {
            Cart.removeItem(cartItem)
        }
        rvKeranjang.adapter?.notifyDataSetChanged()
        updateTotalPrice()
    }

    private fun updateTotalPrice() {
        val totalPrice = Cart.getTotalPrice()
        totalPriceText.text = "Rp $totalPrice"
    }
}
