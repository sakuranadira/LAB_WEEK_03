package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ListFragment : Fragment() {

    private val coffeeList = listOf(
        Coffee(R.id.affogato, R.string.affogato_title, R.string.affogato_desc),
        Coffee(R.id.americano, R.string.americano_title, R.string.americano_desc),
        Coffee(R.id.latte, R.string.latte_title, R.string.latte_desc),
        Coffee(R.id.cappuccino, R.string.cappuccino_title, R.string.cappuccino_desc),
        Coffee(R.id.mocha, R.string.mocha_title, R.string.mocha_desc)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val containerLayout: LinearLayout = view.findViewById(R.id.coffee_container)
        containerLayout.removeAllViews()

        coffeeList.forEach { coffee ->
            val textView = TextView(requireContext())
            textView.text = getString(coffee.titleRes)
            textView.textSize = 16f
            textView.setPadding(20, 20, 20, 20)
            textView.setOnClickListener {
                val bundle = Bundle().apply {
                    putInt(DetailFragment.COFFEE_ID, coffee.id)
                }
                findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
            }
            containerLayout.addView(textView)
        }
    }

    data class Coffee(val id: Int, val titleRes: Int, val descRes: Int)
}
