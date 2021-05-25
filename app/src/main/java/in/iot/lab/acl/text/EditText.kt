package `in`.iot.lab.acl.text

import `in`.iot.lab.acl.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class EditText : Fragment() {

//    lateinit var codeView: CodeView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView=inflater.inflate(R.layout.fragment_edit_text, container, false)
//        codeView=myFragmentView.findViewById<thereisnospon.codeview.CodeView>(R.id.code_view)

//        codeView.showCode(
//            "" +
//                    "<TextView/n" +
//                    "android:layout_width=" + "match_parent/n" +
//                    "android:layout_height=" + "wrap_content/n" +
//                    "android:text=" + "Text View/n" +
//                    "android:textSize=" + "40sp/n" +
//                    "android:textAlignment=" + "center/n" +
//                    "android:layout_marginTop=" + "10dp/n" +
//                    "/>"
//        )

        return myFragmentView
    }
}