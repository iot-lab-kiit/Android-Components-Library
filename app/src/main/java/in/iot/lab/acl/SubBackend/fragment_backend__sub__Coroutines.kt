package `in`.iot.lab.acl.SubBackend

import `in`.iot.lab.acl.databinding.FragmentBackendSubCoroutinesBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import io.noties.markwon.Markwon
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class fragment_backend__sub__Coroutines : Fragment() {
    private lateinit var binding: FragmentBackendSubCoroutinesBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBackendSubCoroutinesBinding.inflate(layoutInflater)

        setStatus("Main work starts: ${Thread.currentThread().name}")

        binding.startCoroutinesButton.setOnClickListener {
            GlobalScope.launch {
                requireActivity().runOnUiThread {
                    setStatus("Coroutine work starts: ${Thread.currentThread().name}")
                }
                delay(3000)
                requireActivity().runOnUiThread {
                    setStatus("Coroutine work ends: ${Thread.currentThread().name}")
                }
            }

        }

        val md = """
            #Basic Info
            ```text
            Coroutines are used for executing the code asynchronously on different threads to lighten up the burden from the main thread.
            If required, more than one coroutine can also run on the same thread. This way, all the services and network calls can be done in background avoiding the UI blocking.
            
            NOTE: Please refer the documentation for more information.
            ```
            #XML
            ```xml
            <TextView
                android:id="@+id/workStatus"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Work status..."
                android:textColor="@color/black"
                android:textSize="18sp"
                android:layout_marginTop="24dp"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="parent" />
        
            <Button
                android:id="@+id/startCoroutinesButton"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Click to start coroutines work"
                android:layout_marginTop="16dp"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/workStatus" />
            ```
            #Kotlin
            ```kotlin
            class fragment_backend__sub__Coroutines : Fragment() {
                private lateinit var binding: FragmentBackendSubCoroutinesBinding
            
                @SuppressLint("SetTextI18n")
                override fun onCreateView(
                    inflater: LayoutInflater, container: ViewGroup?,
                    savedInstanceState: Bundle?
                ): View? {
                    // Inflate the layout for this fragment
                    binding = FragmentBackendSubCoroutinesBinding.inflate(layoutInflater)
            
                    setStatus("Main work starts: ${'$'}{Thread.currentThread().name}")
            
                    binding.startCoroutinesButton.setOnClickListener {
                        GlobalScope.launch {
                            requireActivity().runOnUiThread {
                                setStatus("Coroutine work starts: ${'$'}{Thread.currentThread().name}")
                            }
                            delay(3000)
                            requireActivity().runOnUiThread {
                                setStatus("Coroutine work ends: ${"$"}{Thread.currentThread().name}")
                            }
                        }
                    } 
                    
                    return binding.root
                }

                private fun setStatus(s: String) {
                    binding.workStatus.text = s
                }
            }
            ```
             #Gradle
            ```
            implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0'
            ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(binding.codeCoroutines, md)


        return binding.root
    }

    private fun setStatus(s: String) {
         binding.workStatus.text = s
    }
}