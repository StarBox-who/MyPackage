package com.starbox.mypackage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        auth = FirebaseAuth.getInstance()

        val user = auth.currentUser
        updateUI(user)

        googleLogoutButton.setOnClickListener {
            Toast.makeText(this, user!!.displayName.toString() + "님 안녕히가세요.", Toast.LENGTH_SHORT).show()

            val logoutIntent = Intent(this, LoginActivity::class.java)
            logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(logoutIntent)
        }
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            userInfoText.text = user.email.toString()

        } else {
            userInfoText.text = "오류가 발생했습니다."
        }
    }
}
