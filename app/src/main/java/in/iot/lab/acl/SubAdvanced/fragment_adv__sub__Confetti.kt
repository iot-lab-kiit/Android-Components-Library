package `in`.iot.lab.acl.SubAdvanced

import `in`.iot.lab.acl.R
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.jinatonic.confetti.CommonConfetti
import io.noties.markwon.Markwon
import nl.dionsegijn.konfetti.KonfettiView
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size


class fragment_adv__sub__Confetti : Fragment() {
    lateinit var code: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView= inflater.inflate(R.layout.fragment_adv__sub___confetti, container, false)
        val viewKonfetti=myFragmentView.findViewById<KonfettiView>(R.id.konfettiView)
        viewKonfetti.build()
            .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
            .setDirection(0.0, 359.0)
            .setSpeed(1f, 5f)
            .setFadeOutEnabled(true)
            .setTimeToLive(2000L)
            .addShapes(Shape.Square, Shape.Circle)
            .addSizes(Size(12))
            .setPosition(-50f, viewKonfetti.width + 50f, -50f, -50f)
            .streamFor(300, 5000L)



        code = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
            #XML
            ```xml
            <nl.dionsegijn.konfetti.KonfettiView
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:id="@+id/konfettiView"/>
            ```
            #Gradel
            ```
            implementation 'nl.dionsegijn:konfetti:1.3.2'
            ```
            #Kotlin
            ```kotlin
            val viewKonfetti=findViewById<KonfettiView>(R.id.konfettiView)
            viewKonfetti.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.Square, Shape.Circle)
                .addSizes(Size(12))
                .setPosition(-50f, viewKonfetti.width + 50f, -50f, -50f)
                .streamFor(300, 5000L)
            ```
            #Github Link
            ```text
            https://github.com/DanielMartinus/Konfetti
            ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)
        return myFragmentView
    }


}