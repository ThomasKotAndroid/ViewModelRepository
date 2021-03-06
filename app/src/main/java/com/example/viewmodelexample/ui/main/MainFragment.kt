package com.example.viewmodelexample.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewmodelexample.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
       //was missing this line
        resultText.text = viewModel.getResult().toString()
        // TODO: Use the ViewModel
        convertButton.setOnClickListener {
            if (dollarText.text.isNotEmpty()) {

                viewModel.setAmount(dollarText.text.toString())

                resultText.text = viewModel.getResult().toString()

            } else {

                resultText.text = "No Value"

            }


        }
    }

}