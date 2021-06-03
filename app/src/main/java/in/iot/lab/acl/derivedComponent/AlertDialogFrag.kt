package `in`.iot.lab.acl.derivedComponent

import `in`.iot.lab.acl.R
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import io.noties.markwon.Markwon


class AlertDialogFrag : Fragment() {
    lateinit var codeView: TextView
    lateinit var btnalrt:Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView= inflater.inflate(R.layout.fragment_alert_dialog, container, false)
        codeView = myFragmentView.findViewById<TextView>(R.id.code)
        btnalrt=myFragmentView.findViewById(R.id.btnalrt)


        btnalrt.setOnClickListener {
            val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
            // Setting Alert Dialog Title
            alertDialogBuilder.setTitle("Confirm Exit..!!!")
            // Icon Of Alert Dialog
            alertDialogBuilder.setIcon(R.drawable.acl_logo)
            // Setting Alert Dialog Message
            alertDialogBuilder.setMessage("Are you sure,You want to exit")
            alertDialogBuilder.setCancelable(false)
            alertDialogBuilder.setPositiveButton("Yes",
                DialogInterface.OnClickListener { arg0, arg1 ->
                    Toast.makeText(
                        requireContext(),
                        "You clicked on Yes",
                        Toast.LENGTH_SHORT
                    ).show()
                })
            alertDialogBuilder.setNegativeButton("No",
                DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(
                        requireContext(),
                        "You clicked on No",
                        Toast.LENGTH_SHORT
                    ).show()
                })
            alertDialogBuilder.setNeutralButton("Cancel",
                DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(
                        requireContext(),
                        "You clicked on Cancel",
                        Toast.LENGTH_SHORT
                    ).show()
                })
            val alertDialog: AlertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }


        val md = """
            #XML
            ```xml
            <?xml version="1.0" encoding="utf-8"?>
            <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:tools="http://schemas.android.com/tools"
                android:orientation="vertical"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                tools:context=".derivedComponent.AlertDialogFrag">
                <Button
                    android:text="Click Here"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:padding="20dp"
                    android:id="@+id/btnalrt"
                    android:layout_gravity="center"
                    android:textStyle="normal|bold"
                    android:textColor="@color/white"
                    android:layout_margin="30dp"/>

                <TextView
                    android:text="Click Button to show dialogbox"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:textSize="18sp"
                    android:textStyle="normal|bold"
                    android:gravity="center" />
            </LinearLayout>
            ```
            #Kotlin
            ```kotlin
            lateinit var btnalrt:Button
            btnalrt=myFragmentView.findViewById(R.id.btnalrt)

            btnalrt.setOnClickListener {
                val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
                // Setting Alert Dialog Title
                alertDialogBuilder.setTitle("Confirm Exit..!!!")
                // Icon Of Alert Dialog
                alertDialogBuilder.setIcon(R.drawable.acl_logo)
                // Setting Alert Dialog Message
                alertDialogBuilder.setMessage("Are you sure,You want to exit")
                alertDialogBuilder.setCancelable(false)
                alertDialogBuilder.setPositiveButton("Yes",
                    DialogInterface.OnClickListener { arg0, arg1 ->
                        Toast.makeText(
                            requireContext(),
                            "You clicked on Yes",
                            Toast.LENGTH_SHORT
                        ).show()
                    })
                alertDialogBuilder.setNegativeButton("No",
                    DialogInterface.OnClickListener { dialog, which ->
                        Toast.makeText(
                            requireContext(),
                            "You clicked on No",
                            Toast.LENGTH_SHORT
                        ).show()
                    })
                alertDialogBuilder.setNeutralButton("Cancel",
                    DialogInterface.OnClickListener { dialog, which ->
                        Toast.makeText(
                            requireContext(),
                            "You clicked on Cancel",
                            Toast.LENGTH_SHORT
                        ).show()
                    })
                val alertDialog: AlertDialog = alertDialogBuilder.create()
                alertDialog.show()
            }
            ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(codeView, md)
        return myFragmentView
    }


}