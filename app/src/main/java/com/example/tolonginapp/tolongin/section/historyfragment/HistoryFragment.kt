package com.example.tolonginapp.tolongin.section.historyfragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tolonginapp.tolongin.R
import com.example.tolonginapp.tolongin.common.GeneralRecyclerViewAdapter
import com.example.tolonginapp.tolongin.deps.SharedPreferenceHelper
import com.example.tolonginapp.tolongin.model.HistoryRequest
import com.example.tolonginapp.tolongin.model.HistoryResponse
import com.example.tolonginapp.tolongin.model.ListHistory
import com.example.tolonginapp.tolongin.section.detailTransaksi.DetailTransActivity
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.ID_PENGGUNA
import com.example.tolonginapp.tolongin.utils.changeDateFormat
import com.example.tolonginapp.tolongin.utils.setCurrency
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.viewholder_history.view.*
import javax.inject.Inject

class HistoryFragment : DaggerFragment() , HistoryContract.View {
    @Inject
    lateinit var presenter: HistoryPresenter

    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper

    private val listHistory = mutableListOf<ListHistory>()

    private val historyAdapter by lazy {
        GeneralRecyclerViewAdapter(R.layout.viewholder_history,listHistory,{
            _,_,_->
            startActivity(Intent(activity,DetailTransActivity::class.java))
        },{
            model,view ->
            when{
                model.status == 0-> {
                    view.tv_bencana.text = model.judulBencana
                    activity?.let { ContextCompat.getColor(it,R.color.Red) }?.let { view.tv_bencana.setTextColor(it) }
                    view.tv_donation.text = model.nominal?.toDouble()?.let { setCurrency(it) }
                    view.tv_date.text = model.tanggalTransaksi?.changeDateFormat("yyyy-MM-dd HH:mm:ss","dd MMMM yyyy")
                }
                else ->{
                    view.tv_bencana.text = model.judulBencana
                    view.tv_donation.text = model.nominal?.toDouble()?.let { setCurrency(it) }
                    view.tv_date.text = model.tanggalTransaksi?.changeDateFormat("yyyy-MM-dd HH:mm:ss","dd MMMM yyyy")
                }
            }
        })
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)=
        inflater.inflate(R.layout.fragment_history,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.takeView(this)
        lifecycle.addObserver(presenter)
        with(rv_bencana) {
            adapter = historyAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.getHistory(HistoryRequest(sharedPreferenceHelper.getString(ID_PENGGUNA).toInt()))
    }
    override fun getHistoryList(historyResponse: HistoryResponse) {
        listHistory.clear()
        historyResponse.listbencana?.let { listHistory.addAll(it) }
        historyAdapter.notifyDataSetChanged()
    }
}