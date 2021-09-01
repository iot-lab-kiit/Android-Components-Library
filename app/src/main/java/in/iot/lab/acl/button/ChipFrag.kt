package `in`.iot.lab.acl.button

import `in`.iot.lab.acl.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.noties.markwon.Markwon


class ChipFrag : Fragment() {
    lateinit var code: TextView




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view= inflater.inflate(R.layout.fragment_chip, container, false)
        code = view.findViewById<TextView>(R.id.code)
        val md = """
    #XML
    ```xml
    <com.google.android.material.chip.ChipGroup
        android:id="@+id/Chip_Group_Gender"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_gravity="center_horizontal"
        android:fadingEdge="horizontal|vertical|none"
        app:chipSpacing="10dp"
        app:chipSpacingHorizontal="8dp"
        app:singleLine="true"
        app:singleSelection="false">

        <com.google.android.material.chip.Chip
            android:id="@+id/chip_male"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:checkable="true"
            android:text="MALE"
            android:textColor="@color/black"
            app:chipBackgroundColor="@color/teal_200"
            app:closeIconEnabled="true">
        </com.google.android.material.chip.Chip>

        <com.google.android.material.chip.Chip
            android:id="@+id/chip_female"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:checkable="true"
            android:text="Female"
            android:textColor="@color/black"
            app:chipBackgroundColor="@color/teal_200"
            app:closeIconEnabled="true">
        </com.google.android.material.chip.Chip>

    </com.google.android.material.chip.ChipGroup>
    ```
    """.trimIndent()



        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)
        return view
    }


}