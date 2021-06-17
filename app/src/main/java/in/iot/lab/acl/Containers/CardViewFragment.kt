package `in`.iot.lab.acl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.noties.markwon.Markwon


class CardViewFragment : Fragment() {
    lateinit var code: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_card_view, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)
        val md = """
            CardView is a widget in Android that can be used to display any sort of data by providing a rounded corner layout along with a specific elevation. CardView is the view that can display views on top of each other. The main usage of CardView is that it helps to give a rich feel and look to the UI design. This widget can be easily seen in many different Android Apps. CardView can be used for creating items in listview or inside Recycler View. The best part about CardView is that it extends Framelayout and it can be displayed on all platforms of Android.
    #XML
    ```xml
        <androidx.cardview.widget.CardView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:cardElevation="10dp"
        app:cardCornerRadius="20dp"
        android:layout_margin="10dp"
        app:cardBackgroundColor="@color/white"
        app:cardMaxElevation="12dp"
        app:cardPreventCornerOverlap="true"
        app:cardUseCompatPadding="true"
        >

        <ImageView
            android:layout_width="200dp"
            android:layout_height="200dp"
            android:layout_gravity="center"
            android:src="@drawable/acl_logo"
            android:layout_margin="10dp"
            android:id="@+id/img"
            android:contentDescription="@string/app_name" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/app_name"
            android:layout_gravity="bottom|center_horizontal"
            android:layout_marginTop="20dp"
            android:layout_marginBottom="20dp"
            android:textSize="20sp"
            android:textStyle="bold"
            />
        </androidx.cardview.widget.CardView>
    ```
    """.trimIndent()


        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)

        return myFragmentView
    }


}