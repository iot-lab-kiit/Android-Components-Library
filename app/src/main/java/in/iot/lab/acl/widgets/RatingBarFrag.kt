package `in`.iot.lab.acl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.noties.markwon.Markwon


class RatingBarFrag : Fragment() {

    lateinit var code: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_rating_bar, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
    #XML
    ```xml
       <RatingBar
        android:id="@+id/simpleRatingBar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginTop="20dp"/>
    ```
    #Kotlin
    ```kotlin
    val ratingBar = findViewById<RatingBar>(R.id.simpleRatingBar)
    //To get the number of stars of a RatingBar
    val numberOfStars = simpleRatingBar.rating.toString()
    ```
    """.trimIndent()


        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)

        return myFragmentView
    }


}