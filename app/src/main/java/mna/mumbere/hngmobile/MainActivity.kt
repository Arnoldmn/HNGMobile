package mna.mumbere.hngmobile

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

        val email = sharedPreferences.getString("Email", " ")
        val fname = sharedPreferences.getString("First name", " ")
        val lname = sharedPreferences.getString("Last name", " ")

        etEmail.text = email
        etFname.text = fname
        etLname.text = lname


    }
}
