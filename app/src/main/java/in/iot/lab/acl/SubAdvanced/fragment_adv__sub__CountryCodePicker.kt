package `in`.iot.lab.acl.SubAdvanced

import `in`.iot.lab.acl.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.hbb20.CountryCodePicker
import io.noties.markwon.Markwon

class fragment_adv__sub__CountryCodePicker : Fragment() {
    lateinit var code_ccp: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_adv__sub___country_code_picker, container, false)


        return view
    }
}