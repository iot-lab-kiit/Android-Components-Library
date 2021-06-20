package `in`.iot.lab.acl

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment


class DashboardFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView= inflater.inflate(R.layout.fragment_dashboard, container, false)
        val imgBtn=myFragmentView.findViewById<ImageView>(R.id.iotImg)

        imgBtn.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.data = Uri.parse("https://iotkiit.in/")
            startActivity(intent)
        }
        return myFragmentView
    }


}