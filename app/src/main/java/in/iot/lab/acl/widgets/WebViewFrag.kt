package `in`.iot.lab.acl

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import io.noties.markwon.Markwon
import kotlinx.android.synthetic.main.fragment_web_view.*


class WebViewFrag : Fragment() {
    lateinit var code: TextView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        web_View.webViewClient= WebViewClient()
        web_View.apply {
            loadUrl("https://www.google.com/")
            settings.javaScriptEnabled=true
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_web_view, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)


        val md = """
    #XML
    ```xml
           <WebView  xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@+id/webview"
        android:layout_width="match_parent"
        android:layout_height="300dp"
        android:layout_marginTop="20dp"
        />
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