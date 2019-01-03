package com.example.andhika.tolonginapp.section.detailbencana

import android.content.Intent
import com.bumptech.glide.Glide
import com.example.andhika.tolonginapp.R
import com.example.andhika.tolonginapp.base.BaseActivity
import com.example.andhika.tolonginapp.section.transaksi.TransaksiActivity
import com.example.andhika.tolonginapp.utils.Constant.BaseUrl.Companion.BASE_URL
import kotlinx.android.synthetic.main.activity_detail_bencana.*

class DetailBencanaActivity : BaseActivity() {

    override fun onSetupLayout() {
        setContentView(R.layout.activity_detail_bencana)
    }

    override fun onViewReady() {
        val bundle = intent.extras
        Glide.with(this).load("${BASE_URL}images/Bencana/${bundle.getString("IMAGE_HOLDER")}")
            .into(iv_thumbnail)
        tv_bencana.text = bundle.getString("BENCANA")
        tv_donation_money.text = bundle.getString("DONASI")
        tv_descripsion.text = bundle.getString("DESCRIPTION")

        btn_transaksi.setOnClickListener {
            startActivity(Intent(this@DetailBencanaActivity, TransaksiActivity::class.java))
        }
    }
}