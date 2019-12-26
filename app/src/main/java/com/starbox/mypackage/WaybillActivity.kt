package com.starbox.mypackage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_waybill.*

class WaybillActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waybill)

        closeWaybillButton.setOnClickListener {
            finish()
        }

        numberAddButton.setOnClickListener {
            val waybillNumber: String = numberAddEdit.text.toString()

            if(waybillNumber == "") {
                Toast.makeText(this, "운송장 번호를 정확히 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, waybillNumber, Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
