package mna.mumbere.hngmobile

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
        val isLoggedIn: Boolean = sharedPreferences.getBoolean("isLoggedIn", false)

        val email = sharedPreferences.getString("Email", "DEFAULT_EMAIL")
        val password = sharedPreferences.getString("Password", "DEFAULT_PASSWORD")

        if (isLoggedIn){
            val loginIntent = Intent(applicationContext, MainActivity::class.java)
            startActivity(loginIntent)
        }

        btnLogin.setOnClickListener{


            val mEmail = txtEmail.text.toString().trim()
            val mPassword = txtPassword.toString().trim()

            if (email === mEmail && password == mPassword){
                sharedPreferences.edit().putBoolean("isLoggedIn", false).apply()
            }else{
                Toast.makeText(applicationContext,"Email address or password invalid!",Toast.LENGTH_LONG).show()
            }
        }

        txtReg.setOnClickListener{
            val regInttent = Intent(applicationContext, MainActivity::class.java)
            startActivity(regInttent)

        }
    }
}
