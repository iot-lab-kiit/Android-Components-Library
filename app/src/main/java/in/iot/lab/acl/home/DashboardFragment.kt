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
        val myFragmentView = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val imgBtn = myFragmentView.findViewById<ImageView>(R.id.iotImg)
        val fbBtn = myFragmentView.findViewById<ImageView>(R.id.fbImg)
        val twBtn = myFragmentView.findViewById<ImageView>(R.id.twImg)
        val instBtn = myFragmentView.findViewById<ImageView>(R.id.instImg)
        val ldBtn = myFragmentView.findViewById<ImageView>(R.id.ldinImg)
        val githubBtn = myFragmentView.findViewById<ImageView>(R.id.githubImg)
        val tgBtn = myFragmentView.findViewById<ImageView>(R.id.tgImg)
        val mdBtn = myFragmentView.findViewById<ImageView>(R.id.mdImg)
        val emailBtn = myFragmentView.findViewById<ImageView>(R.id.emailImg)


        imgBtn.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.data = Uri.parse("https://iotkiit.in/")
            startActivity(intent)
        }
        fbBtn.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.data = Uri.parse("https://www.facebook.com/iot.lab.kiit")
            startActivity(intent)
        }
        twBtn.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.data = Uri.parse("https://twitter.com/iotlabkiit")
            startActivity(intent)
        }
        instBtn.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.data = Uri.parse("https://www.instagram.com/iot.lab.kiit/")
            startActivity(intent)
        }
        ldBtn.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.data = Uri.parse("https://www.linkedin.com/company/iotlabkiit")
            startActivity(intent)
        }
        githubBtn.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.data = Uri.parse("https://github.com/iot-lab-kiit")
            startActivity(intent)
        }
        tgBtn.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = Uri.parse("https://telegram.me/iotlabkiit")
            startActivity(intent)
        }
        mdBtn.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.data = Uri.parse("https://medium.com/iot-lab-kiit")
            startActivity(intent)
        }
        emailBtn.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW)
            val data = Uri.parse(
                "mailto:"
                        + "iot.lab@kiit.ac.in"
                        + "" + "" + "" + ""
            )
            intent.data = data
            startActivity(intent)
        }
        return myFragmentView
    }


}