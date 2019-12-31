package com.starbox.mypackage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_waybill.*

class WaybillActivity : AppCompatActivity() {


    private val TAG = "WaybillActivity"

    val db = FirebaseFirestore.getInstance()

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waybill)

        auth = FirebaseAuth.getInstance()

        val user = auth.currentUser

        closeWaybillButton.setOnClickListener {
            finish()
        }

        numberAddButton.setOnClickListener {
            val waybillNumber: String = numberAddEdit.text.toString()

            if(waybillNumber == "") {

                Toast.makeText(this, "운송장 번호를 정확히 입력해주세요.", Toast.LENGTH_SHORT).show()

            } else {

                addWaybillInfo(user)
                finish()

            }
        }
    }


    private fun addWaybillInfo (user: FirebaseUser?) {

        val waybillNum = numberAddEdit.text.toString()

        val waybill = hashMapOf(
            "waybill_number" to waybillNum
        )

        db.collection("users").document(user?.uid.toString()).collection("waybill").document()  //만약 정렬이 안되는 현상이 발생할 시 document 이름을 날짜로 해놓기
            .set(waybill)
            .addOnSuccessListener { Toast.makeText(this, "추가되었습니다.", Toast.LENGTH_SHORT).show() }
            .addOnFailureListener { Toast.makeText(this, "오류가 발생했습니다.", Toast.LENGTH_SHORT).show() }

    }


}
