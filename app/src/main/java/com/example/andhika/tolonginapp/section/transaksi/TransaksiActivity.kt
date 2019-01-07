package com.example.andhika.tolonginapp.section.transaksi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.andhika.tolonginapp.R
import com.example.andhika.tolonginapp.base.BaseActivity
import com.example.andhika.tolonginapp.section.detiltransaksi.DetilTransaksiActivity
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_transaksi.*

class TransaksiActivity : BaseActivity() {

    private val subject : BehaviorSubject<Boolean> = BehaviorSubject.create()
    override fun onSetupLayout() {
        setContentView(R.layout.activity_transaksi)
    }

    override fun onViewReady() {
        val bundle = Bundle()

        rb_bank_mandiri.setOnCheckedChangeListener { buttonView, isChecked ->
            when{
                buttonView.isChecked ->{
                    rb_bank_bni.isChecked = false
                    rb_bank_bri.isChecked = false
                    rb_bank_cimb.isChecked = false
                    rb_bank_bca.isChecked = false
                }
            }
        }
        rb_bank_bca.setOnCheckedChangeListener { buttonView, isChecked ->
            when{
                buttonView.isChecked ->{
                    rb_bank_bni.isChecked = false
                    rb_bank_bri.isChecked = false
                    rb_bank_cimb.isChecked = false
                    rb_bank_mandiri.isChecked = false
                }
            }
        }
        rb_bank_cimb.setOnCheckedChangeListener { buttonView, isChecked ->
            when{
                buttonView.isChecked ->{
                    rb_bank_bni.isChecked = false
                    rb_bank_bri.isChecked = false
                    rb_bank_mandiri.isChecked = false
                    rb_bank_bca.isChecked = false
                }
            }
        }
        rb_bank_bri.setOnCheckedChangeListener { buttonView, isChecked ->
            when{
                buttonView.isChecked ->{
                    rb_bank_bni.isChecked = false
                    rb_bank_cimb.isChecked = false
                    rb_bank_mandiri.isChecked = false
                    rb_bank_bca.isChecked = false
                }
            }
        }

        rb_bank_bni.setOnCheckedChangeListener { buttonView, isChecked ->
            when{
                buttonView.isChecked ->{
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