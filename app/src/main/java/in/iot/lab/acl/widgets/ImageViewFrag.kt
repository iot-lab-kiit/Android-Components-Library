package `in`.iot.lab.acl.widgets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.iot.lab.acl.R
import android.widget.TextView
import io.noties.markwon.Markwon


class ImageViewFrag : Fragment() {

    lateinit var code: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_image_view, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
    #XML
    ```xml
        <ImageView
        android:id="@+id/imageView"
        android:layout_width="200dp"
        android:layout_height="213dp"
        android:layout_gravity="center"
        android:layout_marginTop="20dp"
        android:src="@drawable/main_gradient" />
    ```
    #Kotlin
    ```kotlin
    val img=findViewById<ImageView>(R.id.imageView)
    //To Set button and do other action
    img.setOnClickListener { 
            Toast.makeText(requiredContext(),"You clicked on image",Toast.LENGTH_LONG).show()
      }
    ```
    """.trimIndent()


        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)

        return myFragmentView
    }


}