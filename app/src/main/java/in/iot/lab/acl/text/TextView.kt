package `in`.iot.lab.acl.text

import `in`.iot.lab.acl.R
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Layout
import android.text.Spanned
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.text.style.LeadingMarginSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.noties.markwon.Markwon
import io.noties.markwon.utils.LeadingMarginUtils

//@PrismBundle(
//    include = ["clike", "java", "c" ],
//    grammarLocatorClassName = ".MyGrammarLocator"
//)
class textView : Fragment() {
    lateinit var code: TextView

//    val prism4j = Prism4j(MyGrammerLocator())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_text_view, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
            #XML
            ```xml
            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:id="@+id/textView"
                android:text="Text View"
                android:textSize="40sp"
                android:textAlignment="center"
                android:layout_marginTop="10dp"
            />
            ```
            #Kotlin
            ```kotlin
            val textView=findViewById<TextView>(R.id.textView)
            //To Set Text
            textView.text="Text To Be Set"
            ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)

        return myFragmentView
    }




}