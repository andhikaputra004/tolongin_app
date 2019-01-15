package com.example.tolonginapp.tolongin.section.transaksi

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.example.tolonginapp.tolongin.R
import com.example.tolonginapp.tolongin.base.BaseActivity
import com.example.tolonginapp.tolongin.deps.SharedPreferenceHelper
import com.example.tolonginapp.tolongin.section.detiltransaksi.DetilTransaksiActivity
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.BANK
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.NOMINAL
import com.example.tolonginapp.tolongin.utils.setEnable
import com.example.tolonginapp.tolongin.utils.showSnackBar
import com.jakewharton.rxbinding2.widget.RxRadioGroup
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_transaksi.*
import javax.inject.Inject

class TransaksiActivity : BaseActivity(), TransaksiContract.View {

    @Inject
    lateinit var presenter: TransaksiPresenter

    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper

    private val subject: BehaviorSubject<String> = BehaviorSubject.create()

    private var str = ""

    override fun onSetupLayout() {
        setContentView(R.layout.activity_transaksi)
        setupToolbarTitle(toolbar as Toolbar, R.string.txt_transaksi, R.drawable.ic_arrow_back_white_24dp)

    }

    override fun onViewReady() {
        val bundle = Bundle()

        rb_bank_mandiri.setOnCheckedChangeListener { buttonView, isChecked ->
            RxRadioGroup.checkedChanges(rbgroup).subscribe {
                rb_bank_bni.isChecked = false
                rb_bank_bri.isChecked = false
                rb_bank_cimb.isChecked = false
                rb_bank_bca.isChecked = false
                str = "Mandiri"
            }
        }

        rb_bank_bca.setOnCheckedChangeListener { buttonView, isChecked ->
            RxRadioGroup.checkedChanges(rbgroup).subscribe {
                rb_bank_bni.isChecked = false
                rb_bank_bri.isChecked = false
                rb_bank_cimb.isChecked = false
                rb_bank_mandiri.isChecked = false
                str = "BCA"

            }
        }
        rb_bank_cimb.setOnCheckedChangeListener { buttonView, isChecked ->
            RxRadioGroup.checkedChanges(rbgroup).subscribe {
                rb_bank_bni.isChecked = false
                rb_bank_bri.isChecked = false
                rb_bank_mandiri.isChecked = false
                rb_bank_bca.isChecked = false
                str = "CIMB"
            }
        }
        rb_bank_bri.setOnCheckedChangeListener { buttonView, isChecked ->
            RxRadioGroup.checkedChanges(rbgroup).subscribe {
                rb_bank_bni.isChecked = false
                rb_bank_cimb.isChecked = false
                rb_bank_mandiri.isChecked = false
                rb_bank_bca.isChecked = false
                str = "BRI"

            }
        }

        rb_bank_bni.setOnCheckedChangeListener { buttonView, isChecked ->
            RxRadioGroup.checkedChanges(rbgroup).subscribe {
                rb_bank_bri.isChecked = false
                rb_bank_cimb.isChecked = false
                rb_bank_mandiri.isChecked = false
                rb_bank_bca.isChecked = false
                str = "BNI"
            }
        }


        btn_donasi.setOnClickListener {
            when {
                str != "" && tv_nominal.text != "" -> {
                    bundle.apply {
                        putString(NOMINAL, et_nominal.text.toString())
                    }
                    sharedPreferenceHelper.setString(BANK, str)
                    startActivity(Intent(this, DetilTransaksiActivity::class.java).apply {
                        putExtras(bundle)
                    })
                }
                else -> {
                    showSnackBar(tv_nominal, "Please fill nominal and check radio button")
                }
            }

        }
        presenter.setValidation(Observable.combineLatest(RxTextView.textChanges(et_nominal).map {
            it.isNotEmpty() && it.length > 3
        }, subject.map {
            it.isNotEmpty() && it != ""
        }, BiFunction { text: Boolean, Str: Boolean ->
            text && Str
        }))
    }

    override fun onValid(valid: Boolean) {
        btn_donasi.setEnable(valid)
    }

}