package com.example.tolonginapp.tolongin.section.detailbencana

import android.content.Intent
import android.support.v7.widget.Toolbar
import com.bumptech.glide.Glide
import com.example.tolonginapp.tolongin.R
import com.example.tolonginapp.tolongin.base.BaseActivity
import com.example.tolonginapp.tolongin.deps.SharedPreferenceHelper
import com.example.tolonginapp.tolongin.section.detailTransaksi.DetailTransActivity
import com.example.tolonginapp.tolongin.section.transaksi.TransaksiActivity
import com.example.tolonginapp.tolongin.utils.Constant
import com.example.tolonginapp.tolongin.utils.Constant.BaseUrl.Companion.BASE_URL
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.BENCANA
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.ID_BENCANA
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.ID_TRANSAKSI
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.NAMA
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.NAMA_PENGGALANG
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.NOMOR_REK
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.REK
import com.example.tolonginapp.tolongin.utils.setCurrency
import com.jakewharton.rxbinding2.widget.RxRadioGroup
import kotlinx.android.synthetic.main.activity_detail_bencana.*
import java.text.NumberFormat
import java.util.*
import javax.inject.Inject

class DetailBencanaActivity : BaseActivity() {


    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper


    override fun onSetupLayout() {
        setContentView(R.layout.activity_detail_bencana)
        setupToolbarTitle(toolbar as Toolbar , R.string.txt_donasi,R.drawable.ic_arrow_back_white_24dp)
    }

    override fun onViewReady() {
        when{
            sharedPreferenceHelper.getString(ID_TRANSAKSI) != "" ->{
                startActivity(Intent(this@DetailBencanaActivity,DetailTransActivity::class.java))
                finish()
            }
        }
        val bundle = intent.extras
        Glide.with(this).load("${BASE_URL}images/Bencana/${bundle.getString("IMAGE_HOLDER")}")
            .into(iv_thumbnail)
        tv_bencana.text = bundle.getString("BENCANA")
        tv_donation_money.text = setCurrency(bundle.getDouble("DONASI"))
        tv_descripsion.text = bundle.getString("DESCRIPTION")
        btn_transaksi.setOnClickListener {
            sharedPreferenceHelper.setString(BENCANA,bundle.getString(ID_BENCANA))
            sharedPreferenceHelper.setString(REK,bundle.getString(NOMOR_REK))
            sharedPreferenceHelper.setString(NAMA_PENGGALANG,bundle.getString(NAMA))
            startActivity(Intent(this@DetailBencanaActivity, TransaksiActivity::class.java))
        }

    }
}