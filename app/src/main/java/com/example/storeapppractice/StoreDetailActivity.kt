package com.example.storeapppractice

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.storeapppractice.datas.Store
import kotlinx.android.synthetic.main.activity_store_detail.*

class StoreDetailActivity : BaseActivity() {

    lateinit var storeData : Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        callBtn.setOnClickListener {

            val myUri = Uri.parse(" tel: ${storeData.phoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)

        }
    }

    override fun setValues() {

        storeData = intent.getSerializableExtra("storeData") as Store

        Glide.with(mContext)
            .load(storeData.logoURL)
            .into(viewDetailImg)

        viewDetailNameTxt.text = storeData.name
        viewDetailNumTxt.text = storeData.phoneNum

    }

}