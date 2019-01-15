package com.example.tolonginapp.tolongin.section.detailTransaksi

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import com.example.tolonginapp.tolongin.MainActivity
import com.example.tolonginapp.tolongin.R
import com.example.tolonginapp.tolongin.base.BaseActivity
import com.example.tolonginapp.tolongin.deps.SharedPreferenceHelper
import com.example.tolonginapp.tolongin.model.UpdateTransRequest
import com.example.tolonginapp.tolongin.model.UpdateTransResponse
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.ID_TRANSAKSI
import com.example.tolonginapp.tolongin.utils.encodeBase64
import com.example.tolonginapp.tolongin.utils.getTimeStamp
import com.example.tolonginapp.tolongin.utils.showSnackBar
import kotlinx.android.synthetic.main.activity_detil_history.*
import javax.inject.Inject

class DetailTransActivity : BaseActivity(), DetailTransContract.View {


    @Inject
    lateinit var presenter: DetailTransPresenter

    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper

    private var photoName = ""

    override fun onSetupLayout() {
        setContentView(R.layout.activity_detil_history)
        setupToolbarTitle(toolbar as Toolbar, R.string.detil_history, R.drawable.ic_arrow_back_white_24dp)
    }

    override fun onViewReady() {
        presenter.takeView(this)
        lifecycle.addObserver(presenter)

        when {
            sharedPreferenceHelper.getString(ID_TRANSAKSI) != "" -> {
                btn_status.visibility = View.VISIBLE
                txt_transaksi.visibility = View.GONE
            }
        }
        btn_getimage.setOnClickListener {
            getImage()
        }

        btn_status.setOnClickListener {
            when {
                iv_image.drawable == null -> {
                    showSnackBar(iv_image, "Image Cant be empty")
                }
                else -> {
                    presenter.updateTransReq(
                        UpdateTransRequest(
                            sharedPreferenceHelper.getString(ID_TRANSAKSI).toInt(),
                            photoName,
                            iv_image.encodeBase64()
                        )
                    )
                    sharedPreferenceHelper.removeTransaksi()
                }
            }
        }
    }


    private fun getImage() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK && null != data) {
            iv_image.setImageURI(data.data)
            photoName = "IMG_${getTimeStamp()}.jpg"
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

    override fun updateTrans(response: UpdateTransResponse) {
        startActivity(Intent(this@DetailTransActivity,MainActivity::class.java))
    }


}