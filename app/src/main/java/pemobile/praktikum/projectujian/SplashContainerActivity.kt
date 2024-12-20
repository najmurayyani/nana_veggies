package pemobile.praktikum.projectujian

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3
import pemobile.praktikum.projectujian.adapter.SplashAdapter

class SplashContainerActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var circleIndicator3: CircleIndicator3
    private lateinit var btnPrevious: Button
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_container)

        viewPager = findViewById(R.id.viewPager)
        circleIndicator3 = findViewById(R.id.circleIndicator)
        btnPrevious = findViewById(R.id.btnPrevious)
        btnNext = findViewById(R.id.btnNext)

        val adapter = SplashAdapter(this)
        viewPager.adapter = adapter

        circleIndicator3.setViewPager(viewPager)

        adapter.registerAdapterDataObserver(circleIndicator3.adapterDataObserver)

        updateButtonStates(0)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateButtonStates(position)
            }
        })

        btnPrevious.setOnClickListener {
            viewPager.currentItem -= 1
        }
        btnNext.setOnClickListener {
            if (viewPager.currentItem == (viewPager.adapter?.itemCount?.minus(1) ?: 0)) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                viewPager.currentItem += 1
            }
        }
    }

    private fun updateButtonStates(position: Int) {
        btnPrevious.isEnabled = position != 0
        btnNext.isEnabled = true
    }
}