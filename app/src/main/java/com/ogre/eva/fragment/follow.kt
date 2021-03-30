package com.ogre.eva

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class follow : Fragment() {

    private var adapter: RecyclerView.Adapter<followAdapter.followViewHolder>? = null
    private val userlist = generateUser(100)


    companion object{
        fun newInstance():
                follow{
            return follow()
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootview = inflater.inflate(R.layout.fragment_follow, container, false)
        val recycler = rootview.findViewById<RecyclerView>(R.id.followline)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = followAdapter(userlist)
        recycler.setHasFixedSize(true)
        return rootview

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val userlist = generateUser(100)



    }


    private fun generateUser(size: Int): List<followItem> {

        val list = ArrayList<followItem>()
        val list2 = ArrayList<Int>()
        for (i in 0 until size) {
            list2.add(i + 1)
            val name = when (i % 3) {

                0 -> "Izakahr"
                else -> "Samuel L. Jackson"
            }
            val pic = when (i % 3) {

                0 -> R.drawable.one
                1 -> R.drawable.gwapo
                else -> R.drawable.two
            }

            val item = followItem(
                pic,
                name,
                 ""+ list2.random() +" followers",
                "| Digital Sketch, Painting"
            )
            list += item
        }
        return list
    }


    data class followItem(
        val imageResource: Int,
        val text1: String,
        val text2: String,
        val text3: String
    )


    class followAdapter(private val peoplelist: List<followItem>) :
        RecyclerView.Adapter<followAdapter.followViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): followViewHolder {
            return followViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.followitem, parent, false)
            )
        }

        override fun getItemCount(): Int {
            return peoplelist.size
        }

        override fun onBindViewHolder(holder: followViewHolder, position: Int) {
            val cur = peoplelist[position]
            holder.imageview.setImageResource(cur.imageResource)
            holder.textview1.text = cur.text1
            holder.textview2.text = cur.text2
            holder.textview3.text = cur.text3

        }

        class followViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val imageview: ImageView = itemView.findViewById(R.id.Ppic)
            val textview1: TextView = itemView.findViewById(R.id.Username)
            val textview2: TextView = itemView.findViewById(R.id.numberfollow)
            val textview3: TextView = itemView.findViewById(R.id.Tags)
        }

    }

}
