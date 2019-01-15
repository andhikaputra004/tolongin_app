package com.example.tolonginapp.tolongin.section.detilhistory

import android.util.Log
import android.view.View
import com.example.tolonginapp.tolongin.R
import com.example.tolonginapp.tolongin.base.BaseActivity
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.BANK
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.NAMA_PENGGALANG
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.NOMINAL
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.NOMOR_REK
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.STATUS
import com.example.tolonginapp.tolongin.utils.setCurrency
import kotlinx.android.synthetic.main.activity_detil_history.*

class DetailHistoryActivity : BaseActivity() {
    override fun onSetupLayout() {
        setContentView(R.layout.activity_detil_history)
    }

    override fun onViewReady() {
        val bundle = intent.extras
        getBank(bundle.getString(BANK), bundle.getString(NOMOR_REK))
        tv_tranfer_content.text = setCurrency(bundle.getString(NOMINAL).toDouble())
        tv_nama_pengguna.text = bundle.getString(NAMA_PENGGALANG)

        when {
            bundle.getInt(STATUS) == 0 -> {
                btn_status.visibility = View.VISIBLE
                txt_transaksi.visibility = View.GONE
            }
            else -> {
                btn_status.visibility = View.GONE
                txt_transaksi.visibility = View.VISIBLE
            }
        }
        Log.d("DHIKA", "bank :${bundle.getString(BANK)} nomor: ${bundle.getString(NOMOR_REK)}," +
                "${bundle.getString(NOMINAL)}  nama : ${bundle.getString(NAMA_PENGGALANG)}," +
                "status : ${bundle.getString(STATUS)} ");
    }

    private fun getBank(bank: String, noRek: String) {
        when {
            bank == "MANDIRI" -> {
                iv_bank.setImageResource(R.drawable.ic_mandiri)
                tv_no_rek.text = "(008) $noRek"
            }
            bank == "BCA" -> {
                iv_bank.setImageResource(R.drawable.ic_bca)
                tv_no_rek.text = "(014) $noRek"
            }
            bank == "BNI" -> {
                iv_bank.setImageResource(R.drawable.ic_bni)
                tv_no_rek.text = "(009) $noRek"
            }
            bank == "BRI" -> {
                iv_bank.setImageResource(R.drawable.ic_bri)
                tv_no_rek.text = "(002) $noRek"

            }
            bank == "CIMB" -> {
                iv_bank.setImageResource(R.drawable.ic_cimb)
                tv_no_rek.text = "(022) $noRek"

            }

        }
    }

}