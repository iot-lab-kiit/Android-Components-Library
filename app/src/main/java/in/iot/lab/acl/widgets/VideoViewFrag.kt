package `in`.iot.lab.acl

import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.TextView
import io.noties.markwon.Markwon



class VideoViewFrag : Fragment() {
    lateinit var code: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_video_view, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)


        val md = """
    #XML
    ```xml
           <FrameLayout
    android:layout_width="wrap_content"
    android:layout_height="wrap_content">
    <VideoView
        android:layout_width="match_parent"
        android:layout_height="250dp"
        android:layout_marginTop="20dp"/>
</FrameLayout>
    ```
    #Kotlin
    ```kotlin
    val myWebView: WebView = findViewById(R.id.webview)
    //To load a web page in the WebView, use loadUrl(). 
    myWebView.loadUrl("http://www.example.com")

    ```
    """.trimIndent()


        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)

        return myFragmentView
    }


}