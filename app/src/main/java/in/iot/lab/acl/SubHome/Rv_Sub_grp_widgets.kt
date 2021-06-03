package `in`.iot.lab.acl.SubHome

import `in`.iot.lab.acl.R
import `in`.iot.lab.acl.adapters.GroupRvAdapters
import `in`.iot.lab.acl.data.UiComponetsText
import `in`.iot.lab.acl.data.UiComponetsWidgets
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

class Rv_Sub_grp_widgets : Fragment(), RvClickHandler {
    var recyclerView: RecyclerView? = null
    var fragView: FrameLayout? = null
    var groups = listOf<String>()
    var logo = ArrayList<String>()
    lateinit var groupRvAdapters: GroupRvAdapters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val myFragmentView =
            inflater.inflate(R.layout.fragment_rv__sub_grp_widgets, container, false)

        val recyclerView = myFragmentView.findViewById<RecyclerView>(R.id.extended_rv_widgets)

        groups = resources.getStringArray(R.array.widget_data).toList()
        logo = UiComponetsWidgets.logo

        //Set Adapter

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
            getString(R.string.group_widget_image_view)->navController.navigate(R.id.action_rv_Sub_grp_button_to_toggelButtonFrag)
            getString(R.string.group_widget_web_view)->navController.navigate(R.id.action_rv_Sub_grp_button_to_imageButtonFrag)
            getString(R.string.group_widget_vedio_view)->navController.navigate(R.id.action_rv_Sub_grp_button_to_radioButtonFrag)
            getString(R.string.group_widget_calender_view)->navController.navigate(R.id.action_rv_Sub_grp_button_to_switchFrag)
            getString(R.string.group_widget_progress_spiral)->navController.navigate(R.id.action_rv_Sub_grp_button_to_checkboxFrag)
            getString(R.string.group_widget_progress_horizontal)->navController.navigate(R.id.action_rv_Sub_grp_button_to_checkboxFrag)
            getString(R.string.group_widget_seek_bar)->navController.navigate(R.id.action_rv_Sub_grp_button_to_checkboxFrag)
            getString(R.string.group_widget_seek_bar_discrete)->navController.navigate(R.id.action_rv_Sub_grp_button_to_checkboxFrag)
            getString(R.string.group_widget_start_raiting)->navController.navigate(R.id.action_rv_Sub_grp_button_to_checkboxFrag)
            getString(R.string.group_widget_search_view)->navController.navigate(R.id.action_rv_Sub_grp_button_to_checkboxFrag)
            getString(R.string.group_widget_texture_view)->navController.navigate(R.id.action_rv_Sub_grp_button_to_checkboxFrag)
            getString(R.string.group_widget_surface_view)->navController.navigate(R.id.action_rv_Sub_grp_button_to_checkboxFrag)

        }
    }


}