package dev.ogabek.kotlin.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.listener.FirstListener
import dev.ogabek.kotlin.listener.SecondListener
import java.lang.RuntimeException

class FirstFragment : Fragment() {

    private var firstListener: FirstListener? = null

    private lateinit var et_first: EditText
    private lateinit var btn_send: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_first, container, false)

        et_first = view.findViewById(R.id.et_first)
        btn_send = view.findViewById(R.id.btn_share)

        btn_send.setOnClickListener {
            firstListener?.onFirstSend(et_first.text.toString())
        }

        return view;
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
         if (context is FirstListener) {
             firstListener = context
         } else {
             throw RuntimeException("$context must be Listener")
         }
    }

    override fun onDetach() {
        super.onDetach()
        firstListener = null
    }

    fun updateData(str: String) {
        et_first.setText(str)
    }

}