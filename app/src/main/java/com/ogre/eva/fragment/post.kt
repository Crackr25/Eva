package com.ogre.eva.fragment

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.ogre.eva.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [post.newInstance] factory method to
 * create an instance of this fragment.
 */
class post : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var homefragment = home()


    companion object {
        fun newInstance():
                post {
            return post()
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      /*  val btn: Button = rv.findViewById(R.id.joy)
      */

        val rv = inflater.inflate(R.layout.emotion, container, false)
        val btn: Button = rv.findViewById(R.id.joy)
        val btn2: Button = rv.findViewById(R.id.sad)
        val btn3: Button = rv.findViewById(R.id.disgust)
        val btn4: Button = rv.findViewById(R.id.anger)
        val btn5: Button = rv.findViewById(R.id.fear)
        btn.setOnClickListener{
            val intent = Intent(activity, Emotions::class.java)
            startActivity(intent)

        }

          btn2.setOnClickListener {
            val intent2 = Intent(activity, Emotions::class.java)
            startActivity(intent2)
        }
        btn3.setOnClickListener {
        val intent3 = Intent(activity,Emotions::class.java)
        startActivity(intent3)
    }
        btn4.setOnClickListener {
        val intent4 = Intent(activity, Emotions::class.java)
        startActivity(intent4)
    }
        btn5.setOnClickListener{
    val intent4 = Intent(activity, Emotions::class.java)
    startActivity(intent4)
}

        return rv

    }
}

