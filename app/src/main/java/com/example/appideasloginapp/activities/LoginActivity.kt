package com.example.appideasloginapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.appideasloginapp.R
import com.example.appideasloginapp.databinding.ActivityLoginBinding
import com.example.appideasloginapp.utils.Constants.Companion.isValidEmail
import com.example.appideasloginapp.viewmodels.LoginViewModel
import com.example.appideasloginapp.viewmodels.RegisterViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var bindingLoginActivity: ActivityLoginBinding

    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingLoginActivity = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(bindingLoginActivity.root)

        loginViewModel = ViewModelProvider(this,defaultViewModelProviderFactory).get(LoginViewModel::class.java)

        bindingLoginActivity.materialButtonLogin.setOnClickListener {

            if (bindingLoginActivity.editTextLoginEmail.text!!.isEmpty() && bindingLoginActivity.editTextLoginPwd.text!!.isEmpty()){

                bindingLoginActivity.textInputLayoutLogEmail.error = "This field cannot be empty"
                bindingLoginActivity.textInputLayoutLogPwd.error = "This field cannot be empty"

                bindingLoginActivity.textInputLayoutLogEmail.errorIconDrawable = null
                bindingLoginActivity.textInputLayoutLogPwd.errorIconDrawable = null
            }
            else if (bindingLoginActivity.editTextLoginEmail.text!!.isNotEmpty() &&
                bindingLoginActivity.editTextLoginPwd.text!!.isEmpty()){

                if (!bindingLoginActivity.editTextLoginEmail.text!!.isValidEmail()){
                    bindingLoginActivity.textInputLayoutLogEmail.error = "Invalid email"
                }
                else{
                    bindingLoginActivity.textInputLayoutLogEmail.error = null
                }

                bindingLoginActivity.textInputLayoutLogPwd.error = "This field cannot be empty"

            }
            else if (bindingLoginActivity.editTextLoginEmail.text!!.isEmpty() &&
                bindingLoginActivity.editTextLoginPwd.text!!.isNotEmpty()){

                bindingLoginActivity.textInputLayoutLogEmail.error = "This field cannot be empty"
                bindingLoginActivity.textInputLayoutLogPwd.error = null
            }
            else{
                loginViewModel.loginUser(this,bindingLoginActivity.editTextLoginEmail.text.toString(),
                    bindingLoginActivity.editTextLoginPwd.text.toString())
            }
        }

        loginViewModel.isLoading.observe(this){
            if (it == true){
                bindingLoginActivity.progessBarLogin.visibility = View.VISIBLE
            }
            else{
                bindingLoginActivity.progessBarLogin.visibility = View.GONE
            }
        }

        loginViewModel.loginModelData.observe(this){
            if (it == null){
                loginViewModel.message.observe(this){ msg ->
                    if (msg == "Invalid Password"){
                        bindingLoginActivity.textInputLayoutLogPwd.error = msg
                        bindingLoginActivity.textInputLayoutLogEmail.error = null
                    }
                    else{
                        bindingLoginActivity.textInputLayoutLogEmail.error = msg
                    }
                }
            }
            else{
                val intent = Intent(this,HomeScreenActivity::class.java)
                startActivity(intent)
            }
        }
    }
}