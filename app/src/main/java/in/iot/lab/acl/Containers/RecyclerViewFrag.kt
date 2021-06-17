package `in`.iot.lab.acl

import `in`.iot.lab.acl.Containers.RecyclerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.noties.markwon.Markwon
import kotlinx.android.synthetic.main.fragment_recycler_view.*
import kotlinx.android.synthetic.main.fragment_recycler_view.view.*


class RecyclerViewFrag : Fragment() {


    lateinit var code: TextView
    lateinit var recyclerview:RecyclerView
    private fun fetchData(): ArrayList<String>{
        val list= ArrayList<String>()
        for(i in 0 until 100){
            list.add("items $i")
        }
        return list
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myFragmentView = inflater.inflate(R.layout.fragment_recycler_view, container, false)
        code = myFragmentView.findViewById<TextView>(R.id.code)
        myFragmentView.recyclerView.layoutManager=LinearLayoutManager(activity)
        val items= fetchData()
        val adapter= RecyclerAdapter(items)
        myFragmentView.recyclerView.adapter= adapter
        val md = """
            RecyclerView is a ViewGroup added to the android studio as a successor of the GridView and ListView. It is an improvement on both of them and can be found in the latest v-7 support packages. It has been created to make possible construction of any lists with XML layouts as an item which can be customized vastly while improving on the efficiency of ListViews and GridViews. This improvement is achieved by recycling the views which are out of the visibility of the user. For example, if a user scrolled down to a position where items 4 and 5 are visible; items 1, 2, and 3 would be cleared from the memory to reduce memory consumption.
    #XML
    ```xml
        <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="500dp"
        android:layout_marginTop="20dp">
    </androidx.recyclerview.widget.RecyclerView>
     #Kotlin
    ```kotlin
        recyclerView.layoutManager=LinearLayoutManager(activity)
        //To populate the recycler view
        val items= fetchData()
        val adapter= RecyclerAdapter(items)
        recyclerView.adapter= adapter   
        
        //You will need a recyclerView adapter and a viewholder
        
        class RecyclerAdapter(private val items: ArrayList<String>): RecyclerView.Adapter<Viewholder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerviewitemexample,parent,false)
                return  Viewholder(view)
            }

            override fun onBindViewHolder(holder: Viewholder, position: Int) {
                val currentItem= items[position]
                holder.example.text= currentItem
            }

            override fun getItemCount(): Int {
                return items.size

            }
        }

        class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val example: TextView= itemView.findViewById(R.id.Example)
        }
    ```
    """.trimIndent()


        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code, md)

        return myFragmentView
    }


}