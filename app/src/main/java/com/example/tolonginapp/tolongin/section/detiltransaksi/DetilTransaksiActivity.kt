package com.example.tolonginapp.tolongin.section.detiltransaksi

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.support.v7.widget.Toolbar
import com.example.tolonginapp.tolongin.BuildConfig
import com.example.tolonginapp.tolongin.MainActivity
import com.example.tolonginapp.tolongin.R
import com.example.tolonginapp.tolongin.base.BaseActivity
import com.example.tolonginapp.tolongin.deps.SharedPreferenceHelper
import com.example.tolonginapp.tolongin.model.TransaksiRequest
import com.example.tolonginapp.tolongin.model.TransaksiResponse
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.BENCANA
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.ID_PENGGUNA
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.REK
import kotlinx.android.synthetic.main.activity_detil_transaksi.*
import java.io.File
import javax.inject.Inject
import kotlin.random.Random


class DetilTransaksiActivity : BaseActivity(), DetilTransaksiContract.View {


    @Inject
    lateinit var presenter: DetilTransaksiPresenter

    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper
    override fun onSetupLayout() {
        setContentView(R.layout.activity_detil_transaksi)
        setupToolbarTitle(toolbar as Toolbar , R.string.txt_detail_transaksi,R.drawable.ic_arrow_back_white_24dp)
    }

    override fun onViewReady() {
        presenter.takeView(this)
        lifecycle.addObserver(presenter)
        val bundle = intent.extras
        val getNumberR = getNumber()
        tv_tranfer_content.text = "${bundle.getString("nominal").toInt() + getNumberR}"
        tv_no_rek.text = sharedPreferenceHelper.getString(REK)
        btn_getimage.setOnClickListener {
            getImage()
        }
        btn_transaksi.setOnClickListener {
            presenter.doTransaksi(TransaksiRequest(sharedPreferenceHelper.getString(BENCANA).toInt(),sharedPreferenceHelper.getString(ID_PENGGUNA).toInt()
            ,bundle.getString("nominal").toInt(),getNumberR))
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

    override fun goToMain(response: TransaksiResponse) {
        startActivity(Intent(this@DetilTransaksiActivity,MainActivity::class.java))
    }
    private fun getNumber() : Int{
        val random = Random
        val number = random.nextInt(100)

        return number
    }
}