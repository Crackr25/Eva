   package com.ogre.eva

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


   class follow : Fragment(), followAdapter.OnItemClickListener {

    private var adapter: RecyclerView.Adapter<followAdapter.followViewHolder>? = null
    private var button: Button? = null


    companion object {
        fun newInstance():
                follow {
            return follow()
        }
    }


    override fun onCreateView(
       inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val userlist = generateUser(20)

        val rootview = inflater.inflate(R.layout.fragment_follow, container, false)
        val recycler = rootview.findViewById<RecyclerView>(R.id.followline)
        button = rootview.findViewById(R.id.followbut)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = followAdapter(userlist, this)
        recycler.setHasFixedSize(true)
        return rootview

    }



    override fun onItemClick(position: Int) {
        Toast.makeText(activity,"yeah $position huuu" , Toast.LENGTH_SHORT).show()

    }

       override fun followClick(position: Int, name: String) {
           Toast.makeText(activity,"Your now  following $name button" , Toast.LENGTH_SHORT).show()

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
                pic,name,
                "" + list2.random() + " followers",
                "| Digital Sketch, Painting"
            )
            list += item
        }
        return list
    }


}


    data class followItem(
        val imageResource: Int,
        val text1: String,
        val text2: String,
        val text3: String
    )


    class followAdapter(private val peoplelist: List<followItem>, private val listener: OnItemClickListener) :
        RecyclerView.Adapter<followAdapter.followViewHolder>() {

        private var num = -1;
        var arr = mutableListOf(-22)
        private var name=  "oiuhdjsd";
        var arr2 = mutableListOf(name)




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

            holder.imageview.setOnClickListener { v ->
                Log.d("Error", cur.text1)
            }
            holder.button.setOnClickListener { v ->

                num = position
                name = cur.text1
                arr.add(num)
                listener.followClick(position, name)
             /*   if(arr2.size>1) {
                    if (name in arr2) {
                    }else {
                        arr2.add(name)
                        listener.followClick(position, name)
                    }
                }else{
                    arr2.add(name)
                    listener.followClick(position, name)
                }*/
                notifyDataSetChanged()
                }
            if(position in arr){
            holder.button.setText("following")
            holder.button.setTextColor(Color.WHITE)
            holder.button.setBackgroundColor(Color.rgb(241,156,121))
//            holder.button.setBackgroundColor(Color.CYAN)
//                if (name in arr2 && position !in arr) {
//                    listener.followClick(position, name)
//                }

        }else {
                if(position !in arr)
                holder.button.setText("follow")
                holder.button.setTextColor(Color.BLACK)
                holder.button.setBackgroundColor(Color.WHITE)
            }

        }

        inner class followViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

            val imageview: ImageView = itemView.findViewById(R.id.Ppic)
            val button: Button = itemView.findViewById(R.id.followbut)
            val textview1: TextView = itemView.findViewById(R.id.Username)
            val textview2: TextView = itemView.findViewById(R.id.numberfollow)
            val textview3: TextView = itemView.findViewById(R.id.Tags)



            init {
                itemView.setOnClickListener(this)
           /*     button.setOnClickListener {
                    val position: Int = adapterPosition
                    val cur = peoplelist[position]
                    var name = cur.text1
                    if (position != RecyclerView.NO_POSITION) {
                        listener.followClick(position, name)
                    }

                }*/
            }

            override fun onClick(v: View?) {
                val position: Int = adapterPosition
                if(position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position)
                }
            }
        }
        interface OnItemClickListener{
            fun onItemClick(position: Int)
            fun followClick(position: Int, name: String)


        }


    }



