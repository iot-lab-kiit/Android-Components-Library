package `in`.iot.lab.acl.SubHome

import `in`.iot.lab.acl.R
import `in`.iot.lab.acl.adapters.GroupRvAdapters
import `in`.iot.lab.acl.data.UiComponetsText
import `in`.iot.lab.acl.utils.RvClickHandler
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.kbiakov.codeview.CodeView
import java.util.*

class Rv_Sub_grp_text : Fragment(),RvClickHandler {

    var recyclerView: RecyclerView? = null
    var fragView: FrameLayout? = null
    var groups = ArrayList<String>()
    var logo = ArrayList<String>()
    var codeView: CodeView? = null
    lateinit var groupRvAdapters: GroupRvAdapters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView=inflater.inflate(R.layout.fragment_rv__sub_grp_text, container, false)
        val recyclerView=myFragmentView.findViewById<RecyclerView>(R.id.extended_rv_text)

        groups = UiComponetsText.text
        logo = UiComponetsText.logo

        //Set Adapter

        //Set Adapter
        groupRvAdapters = GroupRvAdapters(groups, logo, context, this)
        recyclerView.adapter = groupRvAdapters
        val manager: RecyclerView.LayoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = manager

        return myFragmentView
    }

    override fun onItemClick(position: Int) {

    }


}