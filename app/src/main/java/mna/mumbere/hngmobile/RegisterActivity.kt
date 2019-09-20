package mna.mumbere.hngmobile

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnRegister.setOnClickListener{

            val sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

            val email = txtEmail.text.toString().trim()
            val fname = txtFname.text.toString().trim()
            val lname = txtLname.text.toString().trim()
            val mpassword = txtPassword.text.toString().trim()

            val editor = sharedPreferences.edit()

            editor.putString(email + fname + lname + mpassword + "data", email + "\n" + fname)

            editor.apply()

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)

        }
    }
}
