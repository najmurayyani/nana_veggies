package pemobile.praktikum.projectujian.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import pemobile.praktikum.projectujian.InfoPribadiActivity
import pemobile.praktikum.projectujian.LoginActivity
import pemobile.praktikum.projectujian.MainActivity
import pemobile.praktikum.projectujian.R
import pemobile.praktikum.projectujian.pref.AppPreferences

class PengaturanFragment : Fragment() {

    private lateinit var userName: TextView
    private lateinit var userPhone: TextView
    private lateinit var llInfoPribadi: LinearLayout
    private lateinit var llKeluar: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userName = view.findViewById(R.id.userName)
        llInfoPribadi = view.findViewById(R.id.llInfoPribadi)
        llKeluar = view.findViewById(R.id.llKeluar)

        val pref = AppPreferences(requireContext())

        userName.text = pref.getName()

        llKeluar.setOnClickListener {
            pref.logout()
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            requireActivity().finish()
        }

        llInfoPribadi.setOnClickListener {
            val intent = Intent(requireContext(), InfoPribadiActivity::class.java)
            startActivity(intent)
        }
    }
}
