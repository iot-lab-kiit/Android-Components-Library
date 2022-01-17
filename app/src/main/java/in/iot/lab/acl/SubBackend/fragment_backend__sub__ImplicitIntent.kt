package `in`.iot.lab.acl.SubBackend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.iot.lab.acl.databinding.FragmentBackendSubImplicitIntentBinding
import `in`.iot.lab.acl.splash.Splash_1
import android.content.Intent
import io.noties.markwon.Markwon

class fragment_backend__sub__ImplicitIntent : Fragment() {
    private lateinit var binding: FragmentBackendSubImplicitIntentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBackendSubImplicitIntentBinding.inflate(layoutInflater)

        binding.implicitIntentButton.setOnClickListener {
            val intent = Intent(context, Splash_1::class.java)
            startActivity(intent)
        }

        val md = """
            #Basic Info
            ```text
            In this demo, an implicit intent is executed on a button click which opens Splash activity of this app.
            An implicit intent requires the context of the current activity/fragment and the Destination activity. 
            
            NOTE: Implicit intents are bound in the boundaries of the current app only. 
                  Please refer the documentation for more information.
            ```
            #XML
            ```xml
            <Button
                android:id="@+id/implicitIntentButton"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Execute Implicit Intent"
                android:layout_marginTop="8dp"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textView5" />
            ```
            #Kotlin: AlarmManager Fragment
            ```kotlin
            class fragment_backend__sub__ImplicitIntent : Fragment() {
                private lateinit var binding: FragmentBackendSubImplicitIntentBinding
              
                override fun onCreateView(
                    inflater: LayoutInflater, container: ViewGroup?,
                    savedInstanceState: Bundle?
                ): View? {
                    // Inflate the layout for this fragment
                    binding = FragmentBackendSubImplicitIntentBinding.inflate(layoutInflater)
            
                    binding.implicitIntentButton.setOnClickListener {
                        val intent = Intent(context, Splash_1::class.java)
                        startActivity(intent)
                    }
                    
                    return binding.root
                }
            }
            ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(binding.codeImplicitIntent, md)


        return binding.root
    }
}