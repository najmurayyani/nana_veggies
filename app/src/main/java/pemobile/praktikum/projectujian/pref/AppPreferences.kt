package pemobile.praktikum.projectujian.pref

import android.content.Context

class AppPreferences(private val context: Context) {

    private var pref = context.getSharedPreferences("AppPref", Context.MODE_PRIVATE)
    private var edit = pref.edit()

    fun save(name: String, phone: String) {
        edit.putString("name", name)
        edit.putString("phone", phone)
        edit.apply()
    }

    fun getName(): String {
        return pref.getString("name", "") ?: ""
    }

    fun getPhone(): String {
        return pref.getString("phone", "") ?: ""
    }

    fun logout() {
        edit.clear()
    }
}