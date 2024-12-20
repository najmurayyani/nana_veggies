package pemobile.praktikum.projectujian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import pemobile.praktikum.projectujian.fragment.BerandaFragment
import pemobile.praktikum.projectujian.fragment.PengaturanFragment
import pemobile.praktikum.projectujian.fragment.PesananFragment
import pemobile.praktikum.projectujian.fragment.ProductFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Setup listener for bottom navigation items
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_beranda -> switchFragment(BerandaFragment())
                R.id.nav_suka -> switchFragment(ProductFragment())
                R.id.nav_cart -> {
                    val intent = Intent(this, KeranjangActivity::class.java)
                    startActivity(intent)
                    false // Return false since we do not want to select this item
                }
                R.id.nav_pesanan -> switchFragment(PesananFragment())
                R.id.nav_pengaturan -> switchFragment(PengaturanFragment())
                else -> false
            }
            true
        }

        // Set the default selected item
        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.nav_beranda
        }
    }

    // Function to switch fragments
    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
