package com.tapan.retrofitrxkotlin.home.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tapan.retrofitrxkotlin.R
import com.tapan.retrofitrxkotlin.core.base.activity.BaseActivity
import com.tapan.retrofitrxkotlin.core.network.response.CellPhone
import com.tapan.retrofitrxkotlin.home.adapter.CellPhoneAdapter
import com.tapan.retrofitrxkotlin.home.presenter.HomePresenter
import com.tapan.retrofitrxkotlin.home.view.HomeView

class HomeActivity : BaseActivity(), HomeView {

    private lateinit var mListView: RecyclerView
    private lateinit var mCellPhoneAdapter: CellPhoneAdapter
    private lateinit var mContentData: List<CellPhone>
    private lateinit var noData: AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUp()
        initiateData()
    }

    private fun initiateData() {
        val mHomePresenter: HomePresenter<HomeView> = HomePresenter()
        mHomePresenter.onAttach(this)
        mHomePresenter.getCellPhoneContent()
    }

    private fun setRecyclerView() {
        val manager = LinearLayoutManager(this)
        mListView.layoutManager = manager
        mCellPhoneAdapter = CellPhoneAdapter(this, mContentData)
        val decoration =
            DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
        mListView.addItemDecoration(decoration)
        mListView.adapter = mCellPhoneAdapter
    }

    override fun layoutResource(): Int {
        return R.layout.activity_home
    }

    override fun setUp() {
        mListView = findViewById(R.id.list_data)
        noData = findViewById(R.id.no_data)
    }

    override fun updateCellPhoneContent(cellPhones: List<CellPhone>) {
        mContentData = cellPhones
        setRecyclerView()
    }

    override fun noDataAvailable() {
        noData.visibility = View.VISIBLE
    }
}
