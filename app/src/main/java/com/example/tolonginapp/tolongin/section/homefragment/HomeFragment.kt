package com.example.tolonginapp.tolongin.section.homefragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.tolonginapp.tolongin.R
import com.example.tolonginapp.tolongin.common.GeneralRecyclerViewAdapter
import com.example.tolonginapp.tolongin.model.ListBencanaResponse
import com.example.tolonginapp.tolongin.model.Listbencana
import com.example.tolonginapp.tolongin.section.detailbencana.DetailBencanaActivity
import com.example.tolonginapp.tolongin.utils.Constant
import com.example.tolonginapp.tolongin.utils.Constant.BaseUrl.Companion.BASE_URL
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.COUNTRY
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.ID_BENCANA
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.LANGUANGE
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.NAMA
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.NOMOR_REK
import com.example.tolonginapp.tolongin.utils.setCurrency
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.viewholder_bencana.view.*
import java.text.NumberFormat
import java.util.*
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
                model.totalDonasi?.let { putDouble("DONASI", it) }
                putString(ID_BENCANA,model.idBencana)
                putString("DESCRIPTION",model.deskripsiBencana)
                putString(NOMOR_REK,model.nomerRekening)
                putString(NAMA,model.namaPenggalangdana)
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
            view.tv_donation.text = model.totalDonasi?.let { setCurrency(it) }

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