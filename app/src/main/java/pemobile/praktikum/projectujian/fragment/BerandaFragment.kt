package pemobile.praktikum.projectujian.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3
import pemobile.praktikum.projectujian.KeranjangActivity
import pemobile.praktikum.projectujian.R
import pemobile.praktikum.projectujian.adapter.BannerAdapter
import pemobile.praktikum.projectujian.adapter.SpacingItemDecoration
import pemobile.praktikum.projectujian.adapter.SpecialDealsAdapter
import pemobile.praktikum.projectujian.data.Cart
import pemobile.praktikum.projectujian.model.CartItem
import pemobile.praktikum.projectujian.model.SpecialDeal

class BerandaFragment : Fragment() {

    private lateinit var ivHamburger: ImageView
    private lateinit var ivFilter: ImageView
    private lateinit var ivSearch: ImageView
    private lateinit var tvTitle: TextView
    private lateinit var tvSort: TextView
    private lateinit var tvFilter: TextView
    private lateinit var viewPagerBanner: ViewPager2
    private lateinit var indicator: CircleIndicator3
    private lateinit var tvSpecialDeal: TextView
    private lateinit var tvSeeMore: TextView
    private lateinit var rvSpecialDeals: RecyclerView

    private val bannerImages = listOf(
        R.drawable.banner,
        R.drawable.banner,
        R.drawable.banner
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }

    private val specialDeals = listOf(
        SpecialDeal(
            id = 1,
            title = "Paket Sop",
            price = 18000,
            slashPrice = "Rp 21,000",
            imageRes = R.drawable.paket_lima,
            category = "Paket"
        ),
        SpecialDeal(
            id = 2,
            title = "Paket Makan",
            price = 20000,
            slashPrice = "Rp 25,000",
            imageRes = R.drawable.paket_lima,
            category = "Paket"
        ),
        SpecialDeal(
            id = 3,
            title = "Apel Merah",
            price = 30000,
            slashPrice = "Rp 35,000",
            imageRes = R.drawable.paket_lima,
            category = "Buah"
        ),
        SpecialDeal(
            id = 4,
            title = "Pisang Ambon",
            price = 15000,
            slashPrice = "Rp 18,000",
            imageRes = R.drawable.paket_lima,
            category = "Buah"
        ),
        SpecialDeal(
            id = 5,
            title = "Wortel Segar",
            price = 12000,
            slashPrice = "Rp 15,000",
            imageRes = R.drawable.paket_lima,
            category = "Sayuran"
        ),
        SpecialDeal(
            id = 6,
            title = "Bayam Merah",
            price = 10000,
            slashPrice = "Rp 12,000",
            imageRes = R.drawable.paket_lima,
            category = "Sayuran"
        ),
        SpecialDeal(
            id = 7,
            title = "Jahe Merah",
            price = 22000,
            slashPrice = "Rp 25,000",
            imageRes = R.drawable.paket_lima,
            category = "Rempah"
        ),
        SpecialDeal(
            id = 8,
            title = "Kunyit",
            price = 18000,
            slashPrice = "Rp 20,000",
            imageRes = R.drawable.paket_lima,
            category = "Rempah"
        )
    )

    private lateinit var categoryPaket: LinearLayout
    private lateinit var categoryBuah: LinearLayout
    private lateinit var categorySayuran: LinearLayout
    private lateinit var categoryRempah: LinearLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryPaket = view.findViewById(R.id.category_paket)
        categoryBuah = view.findViewById(R.id.category_buah)
        categorySayuran = view.findViewById(R.id.category_sayuran)
        categoryRempah = view.findViewById(R.id.category_rempah)

        categoryPaket.setOnClickListener {
            val productFragment = ProductFragment.newInstance("Paket")
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, productFragment)
                .addToBackStack(null)
                .commit()
        }

        categoryBuah.setOnClickListener {
            val productFragment = ProductFragment.newInstance("Buah")
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, productFragment)
                .addToBackStack(null)
                .commit()
        }

        categorySayuran.setOnClickListener {
            val productFragment = ProductFragment.newInstance("Sayuran")
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, productFragment)
                .addToBackStack(null)
                .commit()
        }

        categoryRempah.setOnClickListener {
            val productFragment = ProductFragment.newInstance("Rempah")
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, productFragment)
                .addToBackStack(null)
                .commit()
        }

        ivHamburger = view.findViewById(R.id.ivHamburger)
        ivFilter = view.findViewById(R.id.ivFilter)
        ivSearch = view.findViewById(R.id.ivSearch)
        tvTitle = view.findViewById(R.id.tvTitle)
        tvSort = view.findViewById(R.id.tvSort)
        tvFilter = view.findViewById(R.id.tvFilter)
        viewPagerBanner = view.findViewById(R.id.viewpagerBanner)
        indicator = view.findViewById(R.id.circleIndicator)
        tvSpecialDeal = view.findViewById(R.id.tvSpecialDeal)
        tvSeeMore = view.findViewById(R.id.tvSeeMore)
        rvSpecialDeals = view.findViewById(R.id.rvSpecialDeals)

        setupViewPager()
        setupSpecialDeals()
    }

    private fun setupViewPager() {
        val adapter = BannerAdapter(bannerImages)
        viewPagerBanner.adapter = adapter

        indicator.setViewPager(viewPagerBanner)
        adapter.registerAdapterDataObserver(indicator.adapterDataObserver)
    }

    private fun setupSpecialDeals() {
        rvSpecialDeals.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvSpecialDeals.addItemDecoration(SpacingItemDecoration(32))
        rvSpecialDeals.adapter = SpecialDealsAdapter(specialDeals, onClick = { deal ->
            Cart.addItem(
                CartItem(
                    title = deal.title,
                    price = deal.price,
                    quantity = 1,
                    image = deal.imageRes
                )
            )
            Toast.makeText(requireContext(), "Add to Cart Success!", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), KeranjangActivity::class.java)
            startActivity(intent)
        })
    }
}