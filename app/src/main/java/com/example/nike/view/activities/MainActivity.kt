package com.example.nike.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.nike.R
import com.example.nike.databinding.ActivityMainBinding
import com.example.nike.model.results.Definition
import com.example.nike.model.results.DefinitionList
import com.example.nike.viewmodel.ViewModel

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       val mainActivityBinding : ActivityMainBinding =
           DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel = ViewModel()
        mainActivityBinding.viewmodel = viewModel


        viewModel.definitionListMutableLiveData.observe(
            this,
            Observer<List<Definition>>(viewModel::setAdapter)
        )

    }

    fun initRecyclerView(){

    }
}
