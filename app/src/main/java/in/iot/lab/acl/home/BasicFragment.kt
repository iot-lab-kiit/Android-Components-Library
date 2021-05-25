package `in`.iot.lab.acl.home

import `in`.iot.lab.acl.R
import `in`.iot.lab.acl.adapters.GroupRvAdapters
import `in`.iot.lab.acl.data.UiComponetsGroups
import `in`.iot.lab.acl.utils.RvClickHandler
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class Basic : Fragment(),RvClickHandler  {
    var groups = ArrayList<String>()
    var logo = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView=inflater.inflate(R.layout.fragment_basic, container, false)
        val recyclerView=myFragmentView.findViewById<RecyclerView>(R.id.basic_rv)
        var groupRvAdapters: GroupRvAdapters

        //Set Adapter
        groups = UiComponetsGroups.groups
        logo = UiComponetsGroups.logo

        groupRvAdapters = GroupRvAdapters(groups, logo, context,this)
        recyclerView.adapter = groupRvAdapters
        val manager: RecyclerView.LayoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = manager

        return myFragmentView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onItemClick(position: Int) {
        val str= groups[position];
        val navController=findNavController();
        when(str){
            "Text"->navController.navigate(R.id.action_basicFragment_to_rv_Sub_grp_text)
            "Button"->navController.navigate(R.id.action_basicFragment_to_rv_Sub_grp_button)
            "Widgets/Views"->navController.navigate(R.id.action_basicFragment_to_rv_Sub_grp_widgets)
            "Layouts"->navController.navigate(R.id.action_basicFragment_to_rv_Sub_grp_Layouts)
            "Derived Components"->navController.navigate(R.id.action_basicFragment_to_rv_Sub_grp_DerivedComponents)
            "Containers"->navController.navigate(R.id.action_basicFragment_to_rv_Sub_grp_Containers)
        }

    }


}