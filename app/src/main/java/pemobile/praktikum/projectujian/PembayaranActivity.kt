package pemobile.praktikum.projectujian

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pemobile.praktikum.projectujian.adapter.CheckoutAdapter
import pemobile.praktikum.projectujian.data.Cart
import pemobile.praktikum.projectujian.data.Order
import pemobile.praktikum.projectujian.model.Pesanan

class PembayaranActivity : AppCompatActivity() {

    private lateinit var backButton: ImageView
    private lateinit var tvTitle: TextView
    private lateinit var rvCheckouts: RecyclerView
    private lateinit var addressIcon: ImageView
    private lateinit var tvAlamatTitle: TextView
    private lateinit var tvAlamatDetail: TextView
    private lateinit var checkIconAddress: ImageView
    private lateinit var paymentIcon: ImageView
    private lateinit var tvPaymentTitle: TextView
    private lateinit var tvPaymentDetail: TextView
    private lateinit var checkIconPayment: ImageView
    private lateinit var tvPesananInfoTitle: TextView
    private lateinit var tvSubtotal: TextView
    private lateinit var tvBiayaPengiriman: TextView
    private lateinit var tvTotal: TextView
    private lateinit var btnBuatPesanan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_pembayaran)

        backButton = findViewById(R.id.backButton)
        tvTitle = findViewById(R.id.tvTitle)
        rvCheckouts = findViewById(R.id.rvCheckouts)
        addressIcon = findViewById(R.id.addressIcon)
        tvAlamatTitle = findViewById(R.id.tvAlamatTitle)
        tvAlamatDetail = findViewById(R.id.tvAlamatDetail)
        checkIconAddress = findViewById(R.id.checkIconAddress)
        paymentIcon = findViewById(R.id.paymentIcon)
        tvPaymentTitle = findViewById(R.id.tvPaymentTitle)
        tvPaymentDetail = findViewById(R.id.tvPaymentDetail)
        checkIconPayment = findViewById(R.id.checkIconPayment)
        tvPesananInfoTitle = findViewById(R.id.tvPesananInfoTitle)
        tvSubtotal = findViewById(R.id.tvSubtotal)
        tvBiayaPengiriman = findViewById(R.id.tvBiayaPengiriman)
        tvTotal = findViewById(R.id.tvTotal)
        btnBuatPesanan = findViewById(R.id.btnBuatPesanan)

        backButton.setOnClickListener {
            onBackPressed()
        }

        val cartItems = ArrayList(Cart.cartItems)
        rvCheckouts.layoutManager = LinearLayoutManager(this)
        rvCheckouts.adapter = CheckoutAdapter(cartItems)

//        tvTitle.text = "Pembayaran"
//        tvAlamatTitle.text = "Alamat Pengiriman"
//        tvAlamatDetail.text = "JL. Syech Abdurrauf No.3, Kopelma Darussalam, Kec. Syiah Kuala, Kota Banda Aceh, Aceh 23111"
//        tvPaymentTitle.text = "Metode Pembayaran"
//        tvPaymentDetail.text = "Cash On Delivery"
//        tvPesananInfoTitle.text = "Pesanan Info"
        tvSubtotal.text = "Subtotal: Rp ${Cart.getTotalPrice()}"
        tvBiayaPengiriman.text = "Biaya Pengiriman: Rp 15,000"
        tvTotal.text = "Total: Rp ${Cart.getTotalPrice() + 15000}"

        btnBuatPesanan.setOnClickListener {
            Order.addItems(
                cartItems.map {
                    Pesanan(
                        title = it.title,
                        price = it.price,
                        image = it.image
                    )
                }
            )
            val intent = Intent(this, ThankyouPageActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
