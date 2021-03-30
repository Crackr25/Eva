package com.ogre.eva
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ogre.eva.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [mesages.newInstance] factory method to
 * create an instance of this fragment.
 */
class mesages : Fragment() {
    private var param1: String? = null
    private var param2: View? = null


    companion object{
        fun newInstance():
                mesages{
            return mesages()
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rv = inflater.inflate(R.layout.fragment_mesages, container, false)
        val btn: Button = rv.findViewById(R.id.messagestart)
        btn.setOnClickListener{
            val intent = Intent(activity, MessageAcitvity::class.java)
            startActivity(intent)

        }
        return rv
    }


  /*  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn.setOnClickListener{ view->
            btn.setOnClickListener{
                Toast.makeText(activity,"Settings", Toast.LENGTH_SHORT).show()
                val intent = Intent(activity, MessageAcitvity::class.java)
                startActivity(intent)
            }

        }
*/





    }
/*

    override fun onAttach(context: Context) {
        super.onAttach(context)
        btn?.setOnClickListener{
            Toast.makeText(activity,"Settings", Toast.LENGTH_SHORT).show()
            val intent = Intent(activity, MessageAcitvity::class.java)
            startActivity(intent)
        }

*/









