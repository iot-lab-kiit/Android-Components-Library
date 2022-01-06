package `in`.iot.lab.acl.derivedComponent

import `in`.iot.lab.acl.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.noties.markwon.Markwon


class ImageSwitcherFrag : Fragment() {
    lateinit var imageSwitcher: ImageSwitcher
    lateinit var imgbtnnxt: Button
    lateinit var imgbtnpre:Button
    var imageswitchId = intArrayOf(
        R.drawable.add,
        R.drawable.advanced_tab_icon,
        R.drawable.basic_tab_icon,
        R.drawable.dashboard_tab_icons,
        R.drawable.ic_dashboard_black_24dp
    )
    val count=imageswitchId.size
    private var index = 0

    lateinit var codeView: TextView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView=inflater.inflate(R.layout.fragment_image_switcher, container, false)
        imageSwitcher=myFragmentView.findViewById(R.id.ImageSwitcherDemo)
        imgbtnnxt=myFragmentView.findViewById(R.id.imgbtnnxt)
        imgbtnpre=myFragmentView.findViewById(R.id.imgbtnpre)

        imageSwitcher.setFactory {
            val imgView = ImageView(requireContext())
            imgView.scaleType = ImageView.ScaleType.FIT_CENTER
            imgView.setPadding(8, 8, 8, 8)
            imgView
        }
        // set the method and pass array as a parameter
        imageSwitcher.setImageResource(imageswitchId[index])

        val imgIn = AnimationUtils.loadAnimation(
            requireContext(), android.R.anim.slide_in_left)
        imageSwitcher.inAnimation = imgIn

        val imgOut = AnimationUtils.loadAnimation(
            requireContext(), android.R.anim.slide_out_right)
        imageSwitcher.outAnimation = imgOut

        imgbtnpre.setOnClickListener {
            index = if (index - 1 >= 0) index - 1 else 2
            imageSwitcher.setImageResource(imageswitchId[index])
        }

        imgbtnnxt.setOnClickListener {
            index = if (index + 1 < imageswitchId.size) index +1 else 0
            imageSwitcher.setImageResource(imageswitchId[index])
        }


        codeView = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
            #XML
            ```xml
            <?xml version="1.0" encoding="utf-8"?>
            <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:tools="http://schemas.android.com/tools"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical"
                tools:context=".derivedComponent.ImageSwitcherFrag">


                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:orientation="vertical">

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_gravity="center"
                        android:layout_marginTop="20dp"
                        android:text="Click Next"
                        android:textColor="@color/black"
                        android:textSize="30dp" />

                    <ImageSwitcher
                        android:id="@+id/ImageSwitcherDemo"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_gravity="center"
                        android:layout_marginTop="50dp" />
                </LinearLayout>

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:gravity="center|bottom"
                    android:orientation="horizontal">

                    <Button
                        android:id="@+id/imgbtnpre"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_marginTop="150dp"
                        android:background="@drawable/round_bg"
                        android:text="Previous"
                        android:textColor="#fff"
                        android:textStyle="bold" />

                    <Button
                        android:id="@+id/imgbtnnxt"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_marginLeft="20dp"
                        android:layout_marginTop="150dp"
                        android:background="@drawable/round_bg"
                        android:text="NEXT"
                        android:textColor="#fff"
                        android:textStyle="bold" />
                </LinearLayout>


            </LinearLayout>
            ```
            #Kotlin
            ```kotlin
            lateinit var imageSwitcher: ImageSwitcher
            lateinit var imgbtnnxt: Button
            lateinit var imgbtnpre:Button
            var imageswitchId = intArrayOf(
                R.drawable.add,
                R.drawable.advanced_tab_icon,
                R.drawable.basic_tab_icon,
                R.drawable.dashboard_tab_icons,
                R.drawable.ic_dashboard_black_24dp
            )
            val count=imageswitchId.size
            private var index = 0
            
            imageSwitcher=myFragmentView.findViewById(R.id.ImageSwitcherDemo)
            imgbtnnxt=myFragmentView.findViewById(R.id.imgbtnnxt)
            imgbtnpre=myFragmentView.findViewById(R.id.imgbtnpre)

            imageSwitcher.setFactory {
                val imgView = ImageView(requireContext())
                imgView.scaleType = ImageView.ScaleType.FIT_CENTER
                imgView.setPadding(8, 8, 8, 8)
                imgView
            }
            // set the method and pass array as a parameter
            imageSwitcher.setImageResource(imageswitchId[index])

            val imgIn = AnimationUtils.loadAnimation(
                requireContext(), android.R.anim.slide_in_left)
                imageSwitcher.inAnimation = imgIn

            val imgOut = AnimationUtils.loadAnimation(
                requireContext(), android.R.anim.slide_out_right)
                imageSwitcher.outAnimation = imgOut

            imgbtnpre.setOnClickListener {
                index = if (index - 1 >= 0) index - 1 else 2
                imageSwitcher.setImageResource(imageswitchId[index])
            }

            imgbtnnxt.setOnClickListener {
                index = if (index + 1 < imageswitchId.size) index +1 else 0
                imageSwitcher?.setImageResource(imageswitchId[index])
            }
            ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(codeView, md)


        return myFragmentView
    }


}