package com.example.andhika.tolonginapp.section.detiltransaksi

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.util.Log
import com.example.andhika.tolonginapp.BuildConfig
import com.example.andhika.tolonginapp.R
import com.example.andhika.tolonginapp.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detil_transaksi.*
import java.io.File


class DetilTransaksiActivity : BaseActivity() {


    override fun onSetupLayout() {
        setContentView(R.layout.activity_detil_transaksi)
    }

    override fun onViewReady() {
        val bundle = intent.extras
        tv_tranfer_content.text = bundle.getString("nominal")
        btn_getimage.setOnClickListener {
            getImage()
        }
    }

    private fun getImage() {
        val intent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK && null != data) {
            val file = File(getRealPathFromURI(data.data))
            val image = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".provider", file)
            tv_uri.text = image.toString()
        }
    }

    private fun getRealPathFromURI(contentURI: Uri): String? {
        val result: String?
        val cursor = contentResolver.query(contentURI, null, null, null, null)
        if (cursor == null) {
            result = contentURI.path
        } else {
            cursor.moveToFirst()
            val idx = cursor.getColumnIndex(MediaStore.Files.FileColumns.DATA)
            result = cursor.getString(idx)
            cursor.close()
        }
        return result
    }
}