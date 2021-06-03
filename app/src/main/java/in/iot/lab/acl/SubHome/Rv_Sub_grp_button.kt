package `in`.iot.lab.acl.SubHome

import `in`.iot.lab.acl.R
import `in`.iot.lab.acl.adapters.GroupRvAdapters
import `in`.iot.lab.acl.data.UiComponetsButton
import `in`.iot.lab.acl.utils.RvClickHandler
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList


class Rv_Sub_grp_button : Fragment(), RvClickHandler {
    var recyclerView: RecyclerView? = null
    var groups = listOf<String>()
    var logo = listOf<String>()
    lateinit var groupRvAdapters: GroupRvAdapters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView=inflater.inflate(R.layout.fragment_rv__sub_grp_button, container, false)
        val recyclerView=myFragmentView.findViewById<RecyclerView>(R.id.extended_rv_button)

        logo = resources.getStringArray(R.array.button_logo_data).toList()

        groups = resources.getStringArray(R.array.button_data).toList()


        //Set Adapter

        groupRvAdapters = GroupRvAdapters(groups, logo, context, this)
        recyclerView.adapter = groupRvAdapters
        val manager: RecyclerView.LayoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = manager
        return myFragmentView
    }

    override fun onItemClick(position: Int) {
        val str= groups[position];
        val navController=findNavController();
        when(str){
            getString(R.string.group_button_toggle)->navController.navigate(R.id.action_rv_Sub_grp_button_to_toggelButtonFrag)
            getString(R.string.group_button_image)->navController.navigate(R.id.action_rv_Sub_grp_button_to_imageButtonFrag)
            getString(R.string.group_button_radio)->navController.navigate(R.id.action_rv_Sub_grp_button_to_radioButtonFrag)
            getString(R.string.group_button_switch)->navController.navigate(R.id.action_rv_Sub_grp_button_to_switchFrag)
            getString(R.string.group_button_checkbox)->navController.navigate(R.id.action_rv_Sub_grp_button_to_checkboxFrag)
            getString(R.string.group_button_floating_action)->navController.navigate(R.id.action_rv_Sub_grp_button_to_floatingActionButtonFrag)
        }
    }


}