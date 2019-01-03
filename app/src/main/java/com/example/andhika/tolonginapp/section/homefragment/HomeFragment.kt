package com.example.andhika.tolonginapp.section.homefragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.andhika.tolonginapp.R
import com.example.andhika.tolonginapp.common.GeneralRecyclerViewAdapter
import com.example.andhika.tolonginapp.model.ListBencanaResponse
import com.example.andhika.tolonginapp.model.Listbencana
import com.example.andhika.tolonginapp.section.detailbencana.DetailBencanaActivity
import com.example.andhika.tolonginapp.utils.Constant.BaseUrl.Companion.BASE_URL
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.viewholder_bencana.view.*
import javax.inject.Inject

class HomeFragment : DaggerFragment(), HomeContract.View {

    @Inject
    lateinit var presenter: HomePresenter

    private val listBencana = mutableListOf<Listbencana>()
    private val bundle = Bundle()
    private val bencanaAdapter by lazy {
        GeneralRecyclerViewAdapter(R.layout.viewholder_bencana, listBencana, { model, _, _ ->
            bundle.apply {
                putString("IMAGE_HOLDER",model.tumnel)
                putString("BENCANA",model.judulBencana)
                putString("DONASI",model.totalDonasi)
                putString("DESCRIPTION",model.deskripsiBencana)
            }
            startActivity(Intent(activity, DetailBencanaActivity::class.java).apply {
                putExtras(bundle)
            })
        }, { model, view ->
            Glide.with(this).load("${BASE_URL}images/Bencana/${model.tumnel}")
                .into(
                    view.iv_tumbnail
                )
            view.judul_bencana.text = model.judulBencana
            view.tv_donation.text = model.totalDonasi

        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.takeView(this)
        lifecycle.addObserver(presenter)
        with(rv_bencana) {
            adapter = bencanaAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun getList(response: ListBencanaResponse) {
        listBencana.clear()
        response.listbencana?.let { listBencana.addAll(it) }
        bencanaAdapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        presenter.getBencana()
    }

}