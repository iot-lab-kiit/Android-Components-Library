package `in`.iot.lab.acl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.noties.markwon.Markwon


class SurfaceViewFrag : Fragment() {

    lateinit var code: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_surface_view, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
    #XML
    ```xml
           <SurfaceView
        android:id="@+id/surfaceView"
        android:layout_width="match_parent"
        android:layout_height="250dp"
        android:layout_marginTop="10dp"/>
    ```
    #Kotlin
    ```kotlin
    
    ```
    """.trimIndent()


        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)

        return myFragmentView
    }


}