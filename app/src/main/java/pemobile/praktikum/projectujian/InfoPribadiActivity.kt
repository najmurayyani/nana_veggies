package pemobile.praktikum.projectujian

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pemobile.praktikum.projectujian.pref.AppPreferences

class InfoPribadiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_profil)

        val appPreferences = AppPreferences(this)

        val editTextFullName = findViewById<EditText>(R.id.editTextFullName)
        val editTextPhone = findViewById<EditText>(R.id.editTextPhone)
        val buttonSave = findViewById<Button>(R.id.buttonSave)

        editTextFullName.setText(appPreferences.getName())
        editTextPhone.setText(appPreferences.getPhone())

        buttonSave.setOnClickListener {
            val fullName = editTextFullName.text.toString()
            val phone = editTextPhone.text.toString()

            if (fullName.isBlank()) {
                Toast.makeText(this, "Nama Lengkap tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (phone.isBlank()) {
                Toast.makeText(this, "Nomor Telepon tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            appPreferences.save(fullName, phone)

            Toast.makeText(
                this,
                "Data disimpan:\nNama: $fullName\nNomor: $phone",
                Toast.LENGTH_LONG
            ).show()
            finish()
        }
    }
}