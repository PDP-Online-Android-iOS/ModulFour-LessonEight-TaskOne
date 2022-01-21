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

class SecondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var secondListener: SecondListener? = null

    private lateinit var et_second: EditText
    private lateinit var btn_return: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_second, container, false)

        et_second = view.findViewById(R.id.et_second)

        btn_return = view.findViewById(R.id.btn_return)

        btn_return.setOnClickListener {
            secondListener?.onSecondSend(et_second.text.toString())
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SecondListener) {
            secondListener = context
        } else {
            throw RuntimeException("$context must be Listener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        secondListener = null
    }

    fun updateData(str: String) {
        et_second.setText(str)
    }

}