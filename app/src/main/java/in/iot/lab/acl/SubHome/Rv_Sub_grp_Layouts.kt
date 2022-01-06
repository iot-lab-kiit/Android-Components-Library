package `in`.iot.lab.acl.SubHome

import `in`.iot.lab.acl.R
import `in`.iot.lab.acl.adapters.GroupRvAdapters
import `in`.iot.lab.acl.data.UiComponetsLayouts
import `in`.iot.lab.acl.utils.RvClickHandler
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class Rv_Sub_grp_Layouts : Fragment(), RvClickHandler {
    var recyclerView: RecyclerView? = null
    var groups = listOf<String>()
    var logo = listOf<String>()
    lateinit var groupRvAdapters: GroupRvAdapters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(
            R.layout.fragment_rv__sub_grp__layouts, container, false
        )

        val recyclerView = myFragmentView.findViewById<RecyclerView>(R.id.extended_rv_layouts)

        groups = resources.getStringArray(R.array.layout_data).toList()
        logo = resources.getStringArray(R.array.layout_logo_data).toList()


        //Set Adapter

        groupRvAdapters = GroupRvAdapters(groups, logo, context, this)
        recyclerView.adapter = groupRvAdapters
        val manager: RecyclerView.LayoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = manager

        return myFragmentView

    }

    override fun onItemClick(position: Int) {


        val str = groups[position];
        val navController = findNavController();
        when (str) {
            getString(R.string.group_layouts_constraint) -> navController.navigate(R.id.action_rv_Sub_grp_Layouts_to_constraintLayoutFrag)
            getString(R.string.group_layouts_linar_h) -> navController.navigate(R.id.action_rv_Sub_grp_Layouts_to_linearLayoutH)
            getString(R.string.group_layouts_linar_v) -> navController.navigate(R.id.action_rv_Sub_grp_Layouts_to_linearLayoutV)
            getString(R.string.group_layouts_frame) -> navController.navigate(R.id.action_rv_Sub_grp_Layouts_to_frameLayoutFrag)
            getString(R.string.group_layouts_table) -> navController.navigate(R.id.action_rv_Sub_grp_Layouts_to_tableLayoutFrag)

        }

    }


}