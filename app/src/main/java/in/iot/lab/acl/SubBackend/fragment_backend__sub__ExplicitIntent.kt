package `in`.iot.lab.acl.SubBackend

import `in`.iot.lab.acl.databinding.FragmentBackendSubExplicitIntentBinding
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.noties.markwon.Markwon

class fragment_backend__sub__ExplicitIntent : Fragment() {
    private lateinit var binding: FragmentBackendSubExplicitIntentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBackendSubExplicitIntentBinding.inflate(layoutInflater)

        binding.explicitIntentButton.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.data = Uri.parse("https://iotkiit.in/")
            startActivity(intent)
        }

        val md = """
            #Basic Info
            ```text
            In this demo, an explicit intent is executed on a button click which opens IoT Lab's website.
            
            General Explanation:-
            a) An object is created of the Intent type and its action is set to ACTION_VIEW.
            b) The attribute addCategory is used to define the category of intent you are creating(In this case, CATEGORY_BROWSABLE).
            c) Website URL is provided as data which is parsed using URI.
            
            NOTE: Explicit intents can be used for many other purposes(like sending SMS, make a call, etc.). 
                  Please refer the documentation for more information.
            ```
            #XML
            ```xml
            <Button
                android:id="@+id/explicitIntentButton"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Execute Explicit Intent"
                android:layout_marginTop="8dp"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textView5" />
            ```
            #Kotlin: AlarmManager Fragment
            ```kotlin
            class fragment_backend__sub__ExplicitIntent : Fragment() {
                private lateinit var binding: FragmentBackendSubExplicitIntentBinding
            
                override fun onCreateView(
                    inflater: LayoutInflater, container: ViewGroup?,
                    savedInstanceState: Bundle?
                ): View? {
                    // Inflate the layout for this fragment
                    binding = FragmentBackendSubExplicitIntentBinding.inflate(layoutInflater)
            
                    binding.explicitIntentButton.setOnClickListener {
                        val intent = Intent()
                        intent.action = Intent.ACTION_VIEW
                        intent.addCategory(Intent.CATEGORY_BROWSABLE)
                        intent.data = Uri.parse("https://iotkiit.in/")
                        startActivity(intent)
                    }
                    
                    return binding.root
                }
            }
            ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(binding.codeExplicitIntent, md)


        return binding.root
    }
}