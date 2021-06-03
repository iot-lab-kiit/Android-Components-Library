package `in`.iot.lab.acl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.noties.markwon.Markwon


class DiscreteSeekBarFrag : Fragment() {


    lateinit var code: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_discrete_seek_bar, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
    #XML
    ```xml
        <SeekBar
        android:id="@+id/DiscreteSeekbar"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        style="@style/Widget.AppCompat.SeekBar.Discrete"
        android:padding="10dp"/>
    ```
    #Kotlin
    ```kotlin
    val seek = findViewById(R.id.DiscreteSeekBar)
    //To perform some action on the seekBar
    seek?.setOnSeekBarChangeListener
    ```
    """.trimIndent()


        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)

        return myFragmentView
    }


}