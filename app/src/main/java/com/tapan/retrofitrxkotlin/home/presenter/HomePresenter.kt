package com.tapan.retrofitrxkotlin.home.presenter

import android.util.Log
import com.tapan.retrofitrxkotlin.R
import com.tapan.retrofitrxkotlin.core.base.presenter.BasePresenter
import com.tapan.retrofitrxkotlin.core.network.callback.CellPhoneAPIHandler
import com.tapan.retrofitrxkotlin.core.network.response.CellPhoneResponse
import com.tapan.retrofitrxkotlin.core.rx.BaseObserver
import com.tapan.retrofitrxkotlin.core.util.CoreConstants
import com.tapan.retrofitrxkotlin.home.callback.HomeListener
import com.tapan.retrofitrxkotlin.home.view.HomeView
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.disposables.DisposableHelper
import io.reactivex.schedulers.Schedulers

class HomePresenter<V : HomeView> : BasePresenter<V>(), HomeListener<V> {

    companion object {
        private const val TAG = "HomePresenter"
    }

    override fun getCellPhoneContent() {
        if (isViewAttached) {
            if (view?.isNetworkConnected() == true) {
                processCellPhoneContent()
            } else {
                view?.showError(R.string.msg_network_error)
                view?.noDataAvailable()
            }
        }
    }

    /**
     * Retrieve the cell phone data
     */
    private fun processCellPhoneContent() {
        view?.showLoading()
        val cellPhoneAPIHandler = CellPhoneAPIHandler(CoreConstants.DB_URL)
        cellPhoneContentRequest(cellPhoneAPIHandler)
    }

    /**
     * Subscribing the cellphone content
     *
     * @param cellPhoneAPIHandler API handler
     */
    private fun cellPhoneContentRequest(cellPhoneAPIHandler: CellPhoneAPIHandler) {
        cellPhoneAPIHandler.getCellPhoneContent()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(cellPhoneContentObserver())
    }

    /**
     * Handle the success/error response of cell phone content
     *
     * @return Single observer of result
     */
    private fun cellPhoneContentObserver(): SingleObserver<CellPhoneResponse> {
        return object : BaseObserver<CellPhoneResponse>() {
            override fun onSuccess(response: CellPhoneResponse) {
                view?.hideLoading()
                lazySet(DisposableHelper.DISPOSED)
                view?.updateCellPhoneContent(response.cellPhones)
            }

            override fun onError(ex: Throwable) {
                view?.hideLoading()
                Log.e(TAG, ex.message)
            }
        }
    }
}