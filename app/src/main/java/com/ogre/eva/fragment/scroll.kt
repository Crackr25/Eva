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


class scroll : Fragment() {

    private var adapter: RecyclerView.Adapter<timelineAdapter.timelineViewHolder>? = null
    private val userlist = generateUser(100)


    companion object{
        fun newInstance():
                scroll{
            return scroll()
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootview = inflater.inflate(R.layout.fragment_scroll, container, false)
        val recycler = rootview.findViewById<RecyclerView>(R.id.scrollline)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = timelineAdapter(userlist)
        recycler.setHasFixedSize(true)
        return rootview

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val userlist = generateUser(100)



    }


    private fun generateUser(size: Int): List<timelineItem> {

        val list = ArrayList<timelineItem>()
        val list2 = ArrayList<Int>()
        for (i in 0 until size) {
            list2.add(i + 1)
            val name = when (i % 3) {

                0 -> "Izakahr"
                1 -> "Kakar"
                else -> "Gwapo"
            }
            val pic = when (i % 3) {

                0 -> R.drawable.one
                1 -> R.drawable.two
                else -> R.drawable.one
            }

            val item = timelineItem(
                pic,
                R.drawable.username,
                R.drawable.react,
                R.drawable.comment,
                name,
                "I love you",
                "You and " + list2.random() + " others love this post",
                "300 comment"
            )
            list += item
        }
        return list
    }


    data class timelineItem(
        val imageResource: Int,
        val imageResource2: Int,
        val imageResource3: Int,
        val imageResource4: Int,
        val text1: String,
        val text2: String,
        val text3: String,
        val text4: String
    )


    class timelineAdapter(private val peoplelist: List<timelineItem>) :
        RecyclerView.Adapter<timelineAdapter.timelineViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): timelineViewHolder {
            return timelineViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.scroll, parent, false)
            )
        }

        override fun getItemCount(): Int {
            return peoplelist.size
        }

        override fun onBindViewHolder(holder: timelineViewHolder, position: Int) {
            val cur = peoplelist[position]
            holder.imageview.setImageResource(cur.imageResource)
            holder.img1.setImageResource(cur.imageResource2)
            holder.img2.setImageResource(cur.imageResource3)
            holder.img3.setImageResource(cur.imageResource4)
            holder.textview1.text = cur.text1
            holder.textview2.text = cur.text2
            holder.textview3.text = cur.text3
            holder.textview4.text = cur.text4

        }

        class timelineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val imageview: ImageView = itemView.findViewById(R.id.pic)
            val img1: ImageButton = itemView.findViewById(R.id.follow)
            val img2: ImageButton = itemView.findViewById(R.id.react)
            val img3: ImageButton = itemView.findViewById(R.id.comment)
            val textview1: TextView = itemView.findViewById(R.id.username)
            val textview2: TextView = itemView.findViewById(R.id.tag)
            val textview3: TextView = itemView.findViewById(R.id.reactors)
            val textview4: TextView = itemView.findViewById(R.id.commentcount)

        }

    }

}


