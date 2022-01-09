package `in`.iot.lab.acl.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.iot.lab.acl.R
import `in`.iot.lab.acl.adapters.GroupRvAdapters
import `in`.iot.lab.acl.utils.RvClickHandler
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BackendFragment : Fragment(), RvClickHandler {
    var groups = listOf<String>()
    var logo = listOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView= inflater.inflate(R.layout.fragment_backend, container, false)
        val recyclerView=myFragmentView.findViewById<RecyclerView>(R.id.basic_rv)

        //Set Adapter
        groups = resources.getStringArray(R.array.backend_data).toList()
        logo = resources.getStringArray(R.array.backend_logo).toList()

        val groupRvAdapters= GroupRvAdapters(groups, logo, context,this)
        recyclerView.adapter = groupRvAdapters
        val manager: RecyclerView.LayoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = manager
        return myFragmentView
    }

    override fun onItemClick(position: Int) {
        val str= groups[position]
        val navController=findNavController()
        when(str) {
            getString(R.string.Alarm_Manager)->navController.navigate(R.id.action_backendFragment_to_fragment_backend__sub__AlarmManager)
            getString(R.string.Explicit_Intent)->navController.navigate(R.id.action_backendFragment_to_fragment_backend__sub__ExplicitIntent)
        }
    }
}