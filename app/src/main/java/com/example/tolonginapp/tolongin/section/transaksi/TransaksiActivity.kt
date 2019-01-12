package com.example.tolonginapp.tolongin.section.transaksi

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.example.tolonginapp.tolongin.R
import com.example.tolonginapp.tolongin.base.BaseActivity
import com.example.tolonginapp.tolongin.section.detiltransaksi.DetilTransaksiActivity
import kotlinx.android.synthetic.main.activity_transaksi.*

class TransaksiActivity : BaseActivity() {


    override fun onSetupLayout() {
        setContentView(R.layout.activity_transaksi)
        setupToolbarTitle(toolbar as Toolbar, R.string.txt_transaksi, R.drawable.ic_arrow_back_white_24dp)

    }

    override fun onViewReady() {
        val bundle = Bundle()

        rb_bank_mandiri.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                buttonView.isChecked -> {
                    rb_bank_bni.isChecked = false
                    rb_bank_bri.isChecked = false
                    rb_bank_cimb.isChecked = false
                    rb_bank_bca.isChecked = false
                }
            }
        }
        rb_bank_bca.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                buttonView.isChecked -> {
                    rb_bank_bni.isChecked = false
                    rb_bank_bri.isChecked = false
                    rb_bank_cimb.isChecked = false
                    rb_bank_mandiri.isChecked = false
                }
            }
        }
        rb_bank_cimb.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                buttonView.isChecked -> {
                    rb_bank_bni.isChecked = false
                    rb_bank_bri.isChecked = false
                    rb_bank_mandiri.isChecked = false
                    rb_bank_bca.isChecked = false
                }
            }
        }
        rb_bank_bri.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                buttonView.isChecked -> {
                    rb_bank_bni.isChecked = false
                    rb_bank_cimb.isChecked = false
                    rb_bank_mandiri.isChecked = false
                    rb_bank_bca.isChecked = false
                }
            }
        }

        rb_bank_bni.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                buttonView.isChecked -> {
                    rb_bank_bri.isChecked = false
                    rb_bank_cimb.isChecked = false
                    rb_bank_mandiri.isChecked = false
                    rb_bank_bca.isChecked = false
                }
            }
        }

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