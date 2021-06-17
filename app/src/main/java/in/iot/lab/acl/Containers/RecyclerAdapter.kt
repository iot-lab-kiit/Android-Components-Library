package `in`.iot.lab.acl.Containers

import `in`.iot.lab.acl.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

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