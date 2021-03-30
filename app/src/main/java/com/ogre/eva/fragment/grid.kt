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


class grid : Fragment() {

    private var adapter: RecyclerView.Adapter<gridAdapter.gridViewHolder>? = null


    companion object{
        fun newInstance():
                grid{
            return grid()
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootview = inflater.inflate(R.layout.fragment_grid, container, false)
        val recycler = rootview.findViewById<RecyclerView>(R.id.gridline)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = gridAdapter()
        recycler.setHasFixedSize(true)
        return rootview

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)




    }




    class gridAdapter() :
        RecyclerView.Adapter<gridAdapter.gridViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): gridViewHolder {
            return gridViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.gridlayout, parent, false)
            )
        }

        override fun getItemCount(): Int {
            return 100
        }

        override fun onBindViewHolder(holder: gridViewHolder, position: Int) {

        }

        class gridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val imageview: ImageView = itemView.findViewById(R.id.pic1)
            val imageview2: ImageView = itemView.findViewById(R.id.pic2)
            val imageview3: ImageView = itemView.findViewById(R.id.pic3)

        }

    }

}
