package pemobile.praktikum.projectujian.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pemobile.praktikum.projectujian.KeranjangActivity
import pemobile.praktikum.projectujian.R
import pemobile.praktikum.projectujian.adapter.AllSpacingItemDecoration
import pemobile.praktikum.projectujian.adapter.ProductAdapter
import pemobile.praktikum.projectujian.adapter.SpacingItemDecoration
import pemobile.praktikum.projectujian.data.Cart
import pemobile.praktikum.projectujian.data.ProductProvider
import pemobile.praktikum.projectujian.model.CartItem

class ProductFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter

    companion object {
        private const val ARG_CATEGORY = "deal_category"

        fun newInstance(category: String): ProductFragment {
            val fragment = ProductFragment()
            val args = Bundle().apply {
                putString(ARG_CATEGORY, category)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dealCategory = arguments?.getString(ARG_CATEGORY, "") ?: ""
        val products = if (dealCategory.isBlank()) {
            ProductProvider.getProducts()
        } else {
            ProductProvider.getProducts().filter {
                it.category == dealCategory
            }
        }

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.addItemDecoration(AllSpacingItemDecoration(40))

        recyclerView.layoutManager = GridLayoutManager(context, 2)
        productAdapter = ProductAdapter(products) { deal ->
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
        }
        recyclerView.adapter = productAdapter
    }
}
