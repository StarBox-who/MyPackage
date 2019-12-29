package com.starbox.mypackage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.firebase.FirebaseError
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var lastTimeBackPressed: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        waybillActivityButton.setOnClickListener {
            val waybillIntent = Intent(this, WaybillActivity::class.java)
            startActivity(waybillIntent)
        }

        settingsButton.setOnClickListener {
            val settingsIntent = Intent(this, SettingsActivity::class.java)
            startActivity(settingsIntent)
        }
    }

    // 뒤로가기 버튼 2번 누르면 종료
    override fun onBackPressed() {

        if (System.currentTimeMillis() - lastTimeBackPressed < 1500) {
            ActivityCompat.finishAffinity(this)
            return
        } else {
            lastTimeBackPressed = 0L
        }

        if(lastTimeBackPressed == 0L) {
            lastTimeBackPressed = System.currentTimeMillis()
            Toast.makeText(this, "버튼을 한번 더 누르면 종료합니다.", Toast.LENGTH_SHORT).show()
        }

    }
}
