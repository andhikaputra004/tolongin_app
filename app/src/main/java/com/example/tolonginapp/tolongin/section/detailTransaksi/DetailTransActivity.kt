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
import com.example.tolonginapp.tolongin.model.HistoryRequest
import com.example.tolonginapp.tolongin.model.HistoryResponse
import com.example.tolonginapp.tolongin.model.UpdateTransResponse
import com.example.tolonginapp.tolongin.utils.Constant
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.BANK
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.NAMA_PENGGALANG
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.NOMINAL
import com.example.tolonginapp.tolongin.utils.getTimeStamp
import kotlinx.android.synthetic.main.activity_detail_history.*
import javax.inject.Inject

class DetailTransActivity : BaseActivity(), DetailTransContract.View {



    @Inject
    lateinit var presenter: DetailTransPresenter

    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper

    private var photoName = ""


    override fun onSetupLayout() {
        setContentView(R.layout.activity_detail_history)
        setupToolbarTitle(toolbar as Toolbar, R.string.detil_history, R.drawable.ic_arrow_back_white_24dp)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onViewReady() {
        presenter.takeView(this)
        lifecycle.addObserver(presenter)

        getBank(sharedPreferenceHelper.getString(BANK))
//        tv_tranfer_content.text = setCurrency(sharedPreferenceHelper.getString(NOMINAL).toDouble())
//        Log.d("DHIKA", "res: ${setCurrency(sharedPreferenceHelper.getString(NOMINAL).toDouble())}");
        tv_tranfer_content.text = sharedPreferenceHelper.getString(NOMINAL)
        tv_nama_pengguna.text = sharedPreferenceHelper.getString(NAMA_PENGGALANG)
//        btn_getimage.setOnClickListener {
//            getImage()
//        }


//        btn_status.setOnClickListener {
//            when {
//                iv_image.drawable == null -> {
//                    showSnackBar(iv_image, "Image Cant be empty")
//                }
//                else -> {
//                    presenter.updateTransReq(
//                        UpdateTransRequest(
//                            sharedPreferenceHelper.getString(ID_TRANSAKSI).toInt(),
//                            photoName,
//                            iv_image.encodeBase64()
//                        )
//                    )
//                    Log.d("DHIKA", "res: ${encodeTobase64(iv_image)}");
//                    sharedPreferenceHelper.removeTransaksi()
//                }
//            }
//        }
    }


    override fun onResume() {
        super.onResume()
        presenter.getHistory(HistoryRequest(sharedPreferenceHelper.getString(Constant.CommonString.ID_PENGGUNA).toInt()))
    }
    private fun getImage() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK && null != data) {
//            iv_image.setImageURI(data.data)
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


    private fun getBank(bank: String) {
        when {
            bank.equals("MANDIRI") -> {
                iv_bank.setImageResource(R.drawable.ic_mandiri)
                tv_no_rek.text = "(008) ${sharedPreferenceHelper.getString(Constant.CommonString.REK)}"
            }
            bank.equals("BCA") -> {
                iv_bank.setImageResource(R.drawable.ic_bca)
                tv_no_rek.text = "(014) ${sharedPreferenceHelper.getString(Constant.CommonString.REK)}"
            }
            bank.equals("BNI") -> {
                iv_bank.setImageResource(R.drawable.ic_bni)
                tv_no_rek.text = "(009) ${sharedPreferenceHelper.getString(Constant.CommonString.REK)}"
            }
            bank.equals("BRI") -> {
                iv_bank.setImageResource(R.drawable.ic_bri)
                tv_no_rek.text = "(002) ${sharedPreferenceHelper.getString(Constant.CommonString.REK)}"

            }
            bank.equals("CIMB") -> {
                iv_bank.setImageResource(R.drawable.ic_cimb)
                tv_no_rek.text = "(022) ${sharedPreferenceHelper.getString(Constant.CommonString.REK)}"

            }

        }
    }

    override fun getHistoryList(historyResponse: HistoryResponse) {
        when {
            historyResponse.listbencana?.get(historyResponse.listbencana.lastIndex)?.status == 0 -> {
                btn_status.visibility = View.VISIBLE
                txt_transaksi.visibility = View.GONE
                Log.d("DHIKA", ": ");
            }
            else -> {
                btn_status.visibility = View.GONE
                txt_transaksi.visibility = View.VISIBLE
                sharedPreferenceHelper.removeTransaksi()

            }
        }
    }

}