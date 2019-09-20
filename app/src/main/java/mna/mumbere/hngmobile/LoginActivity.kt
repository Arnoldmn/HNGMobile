package mna.mumbere.hngmobile

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {

            val email = txtEmail.text.toString()
            val  password = txtPassword.text.toString()

            val sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

            val userDetails = sharedPreferences.getString(
                email + password + "data",
                "Email or password invalid. "
            )

            val editor = sharedPreferences.edit()
            editor.putString("display", userDetails)
            editor.apply()

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)


        }

        txtReg.setOnClickListener {
            val regInttent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(regInttent)
            finish()
        }
    }
}
