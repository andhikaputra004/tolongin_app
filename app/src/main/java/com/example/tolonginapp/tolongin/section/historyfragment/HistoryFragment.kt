package com.example.tolonginapp.tolongin.section.historyfragment

import android.os.Bundle
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
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.ID_PENGGUNA
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
        },{
            model,view ->
            view.tv_bencana.text = model.judulBencana
            view.tv_rp.text = model.nominal
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