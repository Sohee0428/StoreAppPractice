package com.example.storeapppractice

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.storeapppractice.datas.Store
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
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

            val permission = object  : PermissionListener{
                override fun onPermissionGranted() {

                    val myUri = Uri.parse(" tel: ${storeData.phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "전화 연결 권한이 없습니다.", Toast.LENGTH_SHORT).show()
                }

            }

            TedPermission.with(mContext)
                    .setPermissionListener(permission)
                    .setDeniedMessage("설정에서 권한을 켜주세요.")
                    .setPermissions(Manifest.permission.CALL_PHONE)
                    .check()

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