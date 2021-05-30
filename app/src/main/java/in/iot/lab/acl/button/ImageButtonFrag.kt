package `in`.iot.lab.acl.button

import `in`.iot.lab.acl.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.noties.markwon.Markwon


class ImageButtonFrag : Fragment() {
    lateinit var code: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_image_button, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
    #XML
    ```xml
        <ImageButton
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:id="@+id/imageButton"
        android:layout_gravity="center"
        android:src="@drawable/main_gradient"/>
    ```
    #Kotlin
    ```kotlin
    val bttn=findViewById<ImageButton>(R.id.imageButton)
    //To Set button and do other action
    bttn.setOnClickListener { 
            Toast.makeText(requiredContext(),"You download is resumed",Toast.LENGTH_LONG).show()
      }
    ```
    """.trimIndent()


        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)

        return myFragmentView
    }


}