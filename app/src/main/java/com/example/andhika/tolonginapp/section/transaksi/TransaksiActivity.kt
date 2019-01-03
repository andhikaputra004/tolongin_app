package com.example.andhika.tolonginapp.section.transaksi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.andhika.tolonginapp.R
import com.example.andhika.tolonginapp.base.BaseActivity
import com.example.andhika.tolonginapp.section.detiltransaksi.DetilTransaksiActivity
import kotlinx.android.synthetic.main.activity_transaksi.*

class TransaksiActivity : BaseActivity() {

    override fun onSetupLayout() {
        setContentView(R.layout.activity_transaksi)
    }

    override fun onViewReady() {
        val bundle = Bundle()


        btn_donasi.setOnClickListener {
            bundle.apply {
                putString("nominal", et_nominal.text.toString())
            }
            startActivity(Intent(this, DetilTransaksiActivity::class.java).apply {
                putExtras(bundle)
            })

        }
    }

}