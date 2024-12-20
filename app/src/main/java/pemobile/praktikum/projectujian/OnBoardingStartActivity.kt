package pemobile.praktikum.projectujian

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class OnBoardingStartActivity : AppCompatActivity() {

    private lateinit var ivStart: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.on_boarding_start)

        ivStart = findViewById(R.id.iv_mulai)
        ivStart.setOnClickListener {
            val intent = Intent(this@OnBoardingStartActivity, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            finish()
        }
    }
}