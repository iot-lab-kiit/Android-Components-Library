package `in`.iot.lab.acl

import `in`.iot.lab.acl.adapters.GroupRvAdapters
import `in`.iot.lab.acl.utils.RvClickHandler
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class AdvancedFragment : Fragment(),RvClickHandler {
    var groups = listOf<String>()
    var logo = listOf<String>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView= inflater.inflate(R.layout.fragment_advanced, container, false)
        val recyclerView=myFragmentView.findViewById<RecyclerView>(R.id.basic_rv)

        //Set Adapter
        groups = resources.getStringArray(R.array.advanced_data).toList()
        logo = resources.getStringArray(R.array.advanced_logo).toList()

//        Log.d("Img array",logo.toString())

        val groupRvAdapters= GroupRvAdapters(groups, logo, context,this)
        recyclerView.adapter = groupRvAdapters
        val manager: RecyclerView.LayoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = manager
        return myFragmentView
    }

    override fun onItemClick(position: Int) {
        val str= groups[position];
        val navController=findNavController();
        when(str){
            getString(R.string.Lotte_view)->navController.navigate(R.id.action_advancedFragment_to_fragment_adv__sub__lottie)
            getString(R.string.Confetti_view)->navController.navigate(R.id.action_advancedFragment_to_fragment_adv__sub__Confetti)
            getString(R.string.Country_Code_Picker)->navController.navigate(R.id.action_advancedFragment_to_fragment_adv__sub__CountryCodePicker)
            getString(R.string.Circle_Menu_View)->navController.navigate(R.id.action_advancedFragment_to_fragment_adv__sub__CircleMenuView)
            getString(R.string.Time_Range_Picker)->navController.navigate(R.id.action_advancedFragment_to_fragment_adv__sub__TimeRangePicker)
        }
    }


}