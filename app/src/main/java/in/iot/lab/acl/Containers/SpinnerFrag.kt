package `in`.iot.lab.acl

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import io.noties.markwon.Markwon


class SpinnerFrag : Fragment() {

    lateinit var code: TextView
    lateinit var spinner: Spinner
    lateinit var selectedPlanet: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_spinner, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)
        spinner = myFragmentView.findViewById(R.id.spinner)
        selectedPlanet = myFragmentView.findViewById(R.id.SelectedPlanet)
        activity?.let {
            ArrayAdapter.createFromResource(
                it.baseContext,
                R.array.planets_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }
        }

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                selectedPlanet.text ="You selected : "+ parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }


        }

            val md = """
            Spinners provide a quick way to select one value from a set. In the default state, a spinner shows its currently selected value. Touching the spinner displays a dropdown menu with all other available values, from which the user can select a new one.
    #XML
    ```xml
        <Spinner
        android:id="@+id/spinner"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:layout_gravity="center"/>
    ```
    #Kotlin
    ```kotlin
    val progressbar=findViewById<ProgressBar>(R.id.progressHorizontal)
    //With an array, you can use the following code in your Activity or Fragment to supply the spinner with the array using an instance of ArrayAdapter:
            val spinner: Spinner = findViewById(R.id.spinner)
    ArrayAdapter.createFromResource(
        this,
        R.array.planets_array,
        android.R.layout.simple_spinner_item
    ).also { adapter ->
   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
   spinner.adapter = adapter
    }
    
    
    //Responding to User Selections
    When the user selects an item from the drop-down, the Spinner object receives an on-item-selected event.To define the selection event handler for a spinner, implement the AdapterView.OnItemSelectedListener interface and the corresponding onItemSelected() callback method. For example, here's an implementation of the interface in an Activity:
    
    class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {

        override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
        }

        override fun onNothingSelected(parent: AdapterView<*>) {
            // Another interface callback
        }
    }
    
    The AdapterView.OnItemSelectedListener requires the onItemSelected() and onNothingSelected() callback methods.Then you need to specify the interface implementation by calling setOnItemSelectedListener():
    
    
    val spinner: Spinner = findViewById(R.id.spinner)
    spinner.onItemSelectedListener = this
    ```
    """.trimIndent()


            val markwon = Markwon.builder(requireContext()).build()

            markwon.setMarkdown(code, md)

            return myFragmentView
        }


    }