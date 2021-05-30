package `in`.iot.lab.acl.button

import `in`.iot.lab.acl.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.noties.markwon.Markwon


class RadioButtonFrag : Fragment() {
    lateinit var code: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_radio_button, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
    #XML
    ```xml
    <RadioGroup
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/radioGroup">

        <RadioButton
            android:id="@+id/radioButton1"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            android:text="Radio Button 1"
            android:layout_marginTop="20dp"
            android:textSize="20sp" />

        <RadioButton
            android:id="@+id/radioButton2"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:text="Radio Button 2"
            android:layout_marginTop="10dp"
            android:textSize="20sp" />
    </RadioGroup>
    ```
    #Kotlin
    ```kotlin
    val radioGroup=findViewById<RadioGroup>(R.id.radioGroup)
    //To Set button and do other action
    val selectedId = radioGroup.getCheckedRadioButtonId();  
    val genderRadioButton =findViewById<RadioButton>(selectedId);  
    if(selectedId==-1){  
        Toast.makeText(MainActivity.this,"Nothing selected", Toast.LENGTH_SHORT).show();  
    }  
    else{  
         Toast.makeText(MainActivity.this,genderradioButton.getText(), Toast.LENGTH_SHORT).show();  
    }  
    ```
    """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)

        return myFragmentView
    }


}