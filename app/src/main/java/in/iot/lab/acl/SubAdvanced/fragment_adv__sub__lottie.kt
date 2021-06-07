package `in`.iot.lab.acl.SubAdvanced

import `in`.iot.lab.acl.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.noties.markwon.Markwon


class fragment_adv__sub__lottie : Fragment() {
    lateinit var code: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_adv__sub__lottie, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
            #XML
            ```xml
            <com.airbnb.lottie.LottieAnimationView
                android:layout_width="wrap_content"
                android:layout_height="200dp"
                app:lottie_autoPlay="true"
                app:lottie_loop="true"
                android:layout_gravity="center"
                app:lottie_rawRes="@raw/study_animetion"
                />
            ```
            #Gradel
            ```
            implementation "com.airbnb.android:lottie:3.7.0"
            ```
            #Github People
            ```text
            https://github.com/airbnb/lottie-android
            ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)
        return myFragmentView
    }


}