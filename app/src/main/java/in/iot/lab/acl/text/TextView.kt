package `in`.iot.lab.acl.text

import `in`.iot.lab.acl.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import thereisnospon.codeview.Code

class textView : Fragment() {
//    lateinit var codeView:

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView=inflater.inflate(R.layout.fragment_text_view, container, false)
//        codeView=myFragmentView.findViewById<CodeView>(R.id.code_view)

//        codeView.setCode(
//           getString(R.string.textView),"xml"
//        )


        return myFragmentView
    }
}