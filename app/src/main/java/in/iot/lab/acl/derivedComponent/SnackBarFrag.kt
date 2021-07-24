package `in`.iot.lab.acl.derivedComponent

import `in`.iot.lab.acl.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import io.noties.markwon.Markwon


class SnackBarFrag : Fragment() {

    lateinit var pushButton: Button
    lateinit var codeView: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_snack_bar, container, false)
        pushButton = view.findViewById(R.id.SnackbarBtn)
        codeView = view.findViewById(R.id.code)
        pushButton.setOnClickListener {
            val snackbar = Snackbar.make(it, "you just clicked the snackbar", Snackbar.LENGTH_LONG)
            snackbar.duration = 1000000000
            snackbar.setAction("Okay") { }
            snackbar.show()
        }
        val md = """
            #XML
            ```xml
            <?xml version="1.0" encoding="utf-8"?>
            <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:app="http://schemas.android.com/apk/res-auto"
                xmlns:tools="http://schemas.android.com/tools"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                tools:context=".MainActivity">

            <Button
                android:id="@+id/SnackbarBtn"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Button"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintHorizontal_bias="0.498"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="parent"
                app:layout_constraintVertical_bias="0.724" />

            </androidx.constraintlayout.widget.ConstraintLayout>
            ```
            #Kotlin
            ```kotlin
            lateinit var pushButton: Button
            pushButton = view.findViewById(R.id.SnackbarBtn)
            pushButton.setOnClickListener {
                val snackbar = Snackbar.make(it, "you just clicked the snackbar", Snackbar.LENGTH_LONG)
                snackbar.duration = 1000000000
                snackbar.setAction("Okay") { }
                snackbar.show()
            }
            ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(codeView, md)

        return view
    }


}