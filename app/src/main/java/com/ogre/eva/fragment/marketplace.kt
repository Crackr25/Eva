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


class marketplace : Fragment() {

    private var adapter: RecyclerView.Adapter<marketplaceAdapter.marketplaceViewHolder>? = null
    private val userlist = generateUser(100)


    companion object{
        fun newInstance():
                marketplace{
            return marketplace()
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootview = inflater.inflate(R.layout.fragment_marketplace, container, false)
        val recycler = rootview.findViewById<RecyclerView>(R.id.marketline)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = marketplaceAdapter(userlist)
        recycler.setHasFixedSize(true)
        return rootview

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val userlist = generateUser(100)



    }


    private fun generateUser(size: Int): List<marketplaceItem> {

        val list = ArrayList<marketplaceItem>()
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
                1 -> R.drawable.gwapo
                else -> R.drawable.two
            }

            val item = marketplaceItem(
                pic,
                name,
                ""+ list2.random() +" marketplaceers",
                "| Digital Sketch, Painting"
            )
            list += item
        }
        return list
    }


    data class marketplaceItem(
        val imageResource: Int,
        val text1: String,
        val text2: String,
        val text3: String
    )


    class marketplaceAdapter(private val peoplelist: List<marketplaceItem>) :
        RecyclerView.Adapter<marketplaceAdapter.marketplaceViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): marketplaceViewHolder {
            return marketplaceViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.marketitem, parent, false)
            )
        }

        override fun getItemCount(): Int {
            return peoplelist.size
        }

        override fun onBindViewHolder(holder: marketplaceViewHolder, position: Int) {

        }

        class marketplaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val imageview: ImageView = itemView.findViewById(R.id.pic2)
            val imageview2: ImageView = itemView.findViewById(R.id.pic3)
            val textview1: TextView = itemView.findViewById(R.id.tag1)
            val textview3: TextView = itemView.findViewById(R.id.tag2)

        }

    }

}
