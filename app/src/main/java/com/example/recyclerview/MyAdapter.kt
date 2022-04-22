package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private var context: Context,
    private var titles: Array<String>,
    private var descriptions: Array<String>,
    private var images: List<Int>
): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.my_row_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = titles[position]
        holder.description.text = descriptions[position]
        holder.image.setImageResource(images[position])
        var mToast = Toast.makeText(context, "You have selected ${holder.title.text}", Toast.LENGTH_SHORT)

        holder.cvLayout.setOnClickListener {
            mToast.cancel()
            mToast = Toast.makeText(context, "You have selected ${holder.title.text}", Toast.LENGTH_SHORT)
            mToast.show()
        }
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.title_TV)
        var description: TextView = itemView.findViewById(R.id.description_TV)
        var image: ImageView = itemView.findViewById(R.id.icon_IV)
        var cvLayout: CardView = itemView.findViewById((R.id.cardViewLayout))
    }
}