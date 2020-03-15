package com.demo.unittest.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.unittest.util.NumberUtils

class WatchDetailViewModel(private val repo: WatchDetailActivityRepo?) : ViewModel() {
    companion object {
        private const val INVALID_MONEY = -1
    }

    /**
     * 手表价格，单位：分
     * */
    private val _privateData = MutableLiveData<String>()
    val priceLiveData: LiveData<String> = _privateData

    /**
     * 提示信息
     * */
    private val _toastData = MutableLiveData<String>()
    val toastData: LiveData<String> = _toastData

    private val _priceLoading = MutableLiveData<Boolean>()
    val priceLoading: LiveData<Boolean> = _priceLoading

    /**
     * 购买是否成功
     * */
    private val _buyResult = MutableLiveData<Boolean>()

    /**
     * 用户余额,单位分
     * */
    private val mUserMoney = 1000 * 100

    private var mPrice = INVALID_MONEY

    val buyResult: LiveData<Boolean> = _buyResult

    /**
     * 加载手表信息
     * */
    fun loadWatchInfo() {
        _priceLoading.value = true
        repo?.loadWatchInfo(object : ICallback<Int> {
            override fun onResult(result: Int) {
                _priceLoading.postValue(false)
                if (!checkPrice(result)) {
                    _toastData.postValue("Error Price")
                    return
                }
                mPrice = result
                val parsedPrice = generatePriceStr(result)
                _privateData.postValue(parsedPrice)
            }
        })
    }

    fun checkPrice(price: Int): Boolean {
        return price in WatchDetailActivityRepo.MIN_PRICE..WatchDetailActivityRepo.MAX_PRICE
    }

    fun generatePriceStr(price: Int): String {
        val parsedPrice = NumberUtils.parsePrice(price)
        return "price:￥$parsedPrice"
    }

    fun buyWatch() {
        if (!checkUserBalence(mPrice)) {
            _toastData.value = "余额不足！！"
            return
        }
        repo?.buyWatch(object : ICallback<Boolean> {
            override fun onResult(result: Boolean) {
                if (result) {
                    // 这里可以加入其他逻辑处理，比如去掉购物车该商品等
                    _buyResult.postValue(true)
                } else {
                    _toastData.postValue("购买失败!!")
                    _buyResult.postValue(false)
                }
            }
        })
    }

    /**
     * 校验用户账户是否有足够金钱
     * */
    fun checkUserBalence(needMoney: Int) = needMoney in (INVALID_MONEY + 1)..mUserMoney
}