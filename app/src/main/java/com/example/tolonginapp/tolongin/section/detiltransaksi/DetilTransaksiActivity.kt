package com.example.tolonginapp.tolongin.section.detiltransaksi

import android.content.Intent
import android.support.v7.widget.Toolbar
import com.example.tolonginapp.tolongin.R
import com.example.tolonginapp.tolongin.base.BaseActivity
import com.example.tolonginapp.tolongin.deps.SharedPreferenceHelper
import com.example.tolonginapp.tolongin.model.TransaksiRequest
import com.example.tolonginapp.tolongin.model.TransaksiResponse
import com.example.tolonginapp.tolongin.section.detailTransaksi.DetailTransActivity
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.BENCANA
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.ID_PENGGUNA
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.ID_TRANSAKSI
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.NOMINAL
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.REK
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.STATUS
import com.example.tolonginapp.tolongin.utils.setCurrency
import kotlinx.android.synthetic.main.activity_detil_transaksi.*
import javax.inject.Inject
import kotlin.random.Random


class DetilTransaksiActivity : BaseActivity(), DetilTransaksiContract.View {


    @Inject
    lateinit var presenter: DetilTransaksiPresenter

    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper

    override fun onSetupLayout() {
        setContentView(R.layout.activity_detil_transaksi)
        setupToolbarTitle(toolbar as Toolbar, R.string.txt_detail_transaksi, R.drawable.ic_arrow_back_white_24dp)
    }

    override fun onViewReady() {
        presenter.takeView(this)
        lifecycle.addObserver(presenter)
        val bundle = intent.extras
        val getNumberR = getNumber()
        tv_tranfer_content.text = setCurrency(bundle.getString("nominal").toDouble() + getNumberR)
        tv_no_rek.text = sharedPreferenceHelper.getString(REK)
        btn_transaksi.setOnClickListener {
            presenter.doTransaksi(
                TransaksiRequest(
                    sharedPreferenceHelper.getString(BENCANA).toInt(),
                    sharedPreferenceHelper.getString(ID_PENGGUNA).toInt()
                    ,
                    bundle.getString("nominal").toInt(),
                    getNumberR
                )
            )
            sharedPreferenceHelper.setInt(STATUS, 0)
            sharedPreferenceHelper.setString(NOMINAL,tv_tranfer_content.text.toString())
        }
    }


    override fun goToMain(response: TransaksiResponse) {
        response.getTrans?.get(0)?.idTransaksi?.let { sharedPreferenceHelper.setString(ID_TRANSAKSI, it) }
        startActivity(Intent(this@DetilTransaksiActivity, DetailTransActivity::class.java))
        finish()
    }


    private fun getNumber(): Int {
        val random = Random
        val number = random.nextInt(999)

        return number
    }

}