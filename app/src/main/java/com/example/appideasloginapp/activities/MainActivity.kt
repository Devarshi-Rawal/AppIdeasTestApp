package com.example.appideasloginapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.appideasloginapp.R
import com.example.appideasloginapp.databinding.ActivityMainBinding
import com.example.appideasloginapp.utils.Constants.Companion.isValidEmail
import com.example.appideasloginapp.viewmodels.RegisterViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var bindingMainActivity: ActivityMainBinding

    lateinit var registerViewModel:RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMainActivity.root)

        registerViewModel = ViewModelProvider(this,defaultViewModelProviderFactory).get(RegisterViewModel::class.java)

        bindingMainActivity.materialButtonRegister.setOnClickListener {
            if (bindingMainActivity.editTextEmail.text!!.isEmpty() && bindingMainActivity.editTextPwd.text!!.isEmpty() &&
                    bindingMainActivity.editTextConfPwd.text!!.isEmpty()){

                bindingMainActivity.textInputLayoutEmail.error = "This field cannot be empty"
                bindingMainActivity.textInputLayoutConfPwd.error = "This field cannot be empty"
                bindingMainActivity.textInputLayoutPwd.error = "This field cannot be empty"
            }
            else if (bindingMainActivity.editTextEmail.text!!.isNotEmpty() &&
                bindingMainActivity.editTextPwd.text!!.isEmpty() && bindingMainActivity.editTextConfPwd.text!!.isEmpty()){

                if (!bindingMainActivity.editTextEmail.text.toString().isValidEmail()){
                    bindingMainActivity.textInputLayoutEmail.error = "Invalid email"
                }
                else{
                    bindingMainActivity.textInputLayoutEmail.error = null
                }
                bindingMainActivity.textInputLayoutConfPwd.error = "This field cannot be empty"
                bindingMainActivity.textInputLayoutPwd.error = "This field cannot be empty"

            }
            else if (bindingMainActivity.editTextEmail.text!!.isNotEmpty() &&
                bindingMainActivity.editTextPwd.text!!.isNotEmpty() && bindingMainActivity.editTextConfPwd.text!!.isEmpty()){
                if (!bindingMainActivity.editTextEmail.text.toString().isValidEmail()){
                    bindingMainActivity.textInputLayoutEmail.setError("Invalid email")
                }
                else{
                    bindingMainActivity.textInputLayoutEmail.error = null
                }
                bindingMainActivity.textInputLayoutConfPwd.error = "This field cannot be empty"
                bindingMainActivity.textInputLayoutPwd.error = null

            }
            else if (bindingMainActivity.editTextEmail.text!!.isNotEmpty() &&
                bindingMainActivity.editTextPwd.text!!.isEmpty() && bindingMainActivity.editTextConfPwd.text!!.isNotEmpty()){
                if (!bindingMainActivity.editTextEmail.text.toString().isValidEmail()){
                    bindingMainActivity.textInputLayoutEmail.error = "Invalid email"
                }
                else{
                    bindingMainActivity.textInputLayoutEmail.error = null
                }
                bindingMainActivity.textInputLayoutPwd.error = "This field cannot be empty"
                bindingMainActivity.textInputLayoutConfPwd.error = null
            }
            else if (bindingMainActivity.editTextEmail.text!!.isEmpty() &&
                bindingMainActivity.editTextPwd.text!!.isNotEmpty() && bindingMainActivity.editTextConfPwd.text!!.isNotEmpty()){

                bindingMainActivity.textInputLayoutEmail.error = "This field cannot be empty"

                if (bindingMainActivity.editTextPwd.text == bindingMainActivity.editTextConfPwd.text){
                    bindingMainActivity.textInputLayoutPwd.error = null
                    bindingMainActivity.textInputLayoutConfPwd.error = null
                }
                else{
                    bindingMainActivity.textInputLayoutPwd.error = "Password does not match"
                    bindingMainActivity.textInputLayoutConfPwd.error = "Password does not match"
                }
            }
            else{
                if (!bindingMainActivity.editTextEmail.text.toString().isValidEmail()){
                    bindingMainActivity.textInputLayoutEmail.error = "Invalid email"
                }
                else{
                    bindingMainActivity.textInputLayoutEmail.error = null
                    if (bindingMainActivity.editTextPwd.text.toString() == bindingMainActivity.editTextConfPwd.text.toString()){
                        bindingMainActivity.textInputLayoutPwd.error = null
                        bindingMainActivity.textInputLayoutConfPwd.error = null

                        //Call register api
                        registerViewModel.registerUser(this,
                            bindingMainActivity.editTextEmail.text.toString(),bindingMainActivity.editTextPwd.text.toString())
                    }
                    else{
                        bindingMainActivity.textInputLayoutPwd.error = "Password does not match"
                        bindingMainActivity.textInputLayoutConfPwd.error = "Password does not match"
                    }
                }
            }
        }

        registerViewModel.isLoading.observe(this) {
            if (it == true){
                bindingMainActivity.progressBarRegister.visibility = View.VISIBLE
            }
            else{
                bindingMainActivity.progressBarRegister.visibility = View.GONE
            }
        }

        registerViewModel.status.observe(this){
            if (it == "success"){
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Registration unsuccessful",Toast.LENGTH_SHORT).show()
            }
        }

        bindingMainActivity.materialButtonLogin.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

    }

}