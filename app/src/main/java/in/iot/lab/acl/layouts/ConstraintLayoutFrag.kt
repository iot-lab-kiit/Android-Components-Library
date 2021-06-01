package `in`.iot.lab.acl.layouts

import `in`.iot.lab.acl.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.noties.markwon.Markwon


class ConstraintLayoutFrag : Fragment() {
    lateinit var code: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_constraint_layout, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)


        val md = """
            #XML
            ```xml
            <?xml version="1.0" encoding="utf-8"?>
            <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:app="http://schemas.android.com/apk/res-auto"
                xmlns:tools="http://schemas.android.com/tools"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                tools:context=".layouts.ConstraintLayoutFrag">

                <TextView
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginBottom="712dp"
                    android:id="@+id/heading"
                    app:layout_constraintBottom_toBottomOf="parent"
                    app:layout_constraintEnd_toEndOf="parent"
                    app:layout_constraintStart_toStartOf="parent"
                    app:layout_constraintTop_toTopOf="parent" />

                <TextView
                    android:id="@+id/code"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="44dp"
                    android:text="asgfdaac"
                    app:layout_constraintEnd_toEndOf="parent"
                    app:layout_constraintHorizontal_bias="0.0"
                    app:layout_constraintStart_toStartOf="parent"
                    app:layout_constraintTop_toBottomOf="@+id/heading" />
            </androidx.constraintlayout.widget.ConstraintLayout>
            ```
        """.trimIndent()
        val markwon = Markwon.builder(requireContext()).build()
        markwon.setMarkdown(code, md)
        return myFragmentView
    }


}