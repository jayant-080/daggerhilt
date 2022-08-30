package com.example.viewmodel

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerhilt.R




class ViewModelActivity:AppCompatActivity() {

   private val  viewModel by viewModels<AViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel)

        updateFields()


        findViewById<Button>(R.id.btn_submit).setOnClickListener {

            register()
        }


    }

    private fun register() {

      val result =  viewModel.validateData(findViewById<EditText>(R.id.et_email).text.toString(),findViewById<EditText>(R.id.et_password).text.toString())
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
    }

    private fun updateFields() {
        findViewById<EditText>(R.id.et_email).setText(viewModel.v_email)
        findViewById<EditText>(R.id.et_password).setText(viewModel.v_password)
    }


}