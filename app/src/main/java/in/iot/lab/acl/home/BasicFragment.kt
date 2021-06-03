package `in`.iot.lab.acl.home

import `in`.iot.lab.acl.R
import `in`.iot.lab.acl.adapters.GroupRvAdapters
import `in`.iot.lab.acl.data.UiComponetsGroups
import `in`.iot.lab.acl.utils.RvClickHandler
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class Basic : Fragment(),RvClickHandler  {
    var groups = listOf<String>()
    var logo = listOf<String>()

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
        groups = resources.getStringArray(R.array.basic_data).toList()
        logo = resources.getStringArray(R.array.basic_logo).toList()

//        Log.d("Img array",logo.toString())

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
            getString(R.string.basic_text)->navController.navigate(R.id.action_basicFragment_to_rv_Sub_grp_text)
            getString(R.string.basic_button)->navController.navigate(R.id.action_basicFragment_to_rv_Sub_grp_button)
            getString(R.string.basic_widgets)->navController.navigate(R.id.action_basicFragment_to_rv_Sub_grp_widgets)
            getString(R.string.basic_layouts)->navController.navigate(R.id.action_basicFragment_to_rv_Sub_grp_Layouts)
            getString(R.string.basic_dc)->navController.navigate(R.id.action_basicFragment_to_rv_Sub_grp_DerivedComponents)
            getString(R.string.basic_containers)->navController.navigate(R.id.action_basicFragment_to_rv_Sub_grp_Containers)
        }

    }


}