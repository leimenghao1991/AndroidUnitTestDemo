package com.demo.unittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.demo.unittest.mvvm.ViewModelFactory
import com.demo.unittest.mvvm.WatchDetailViewModel

class WatchDetailActivity : AppCompatActivity() {
    private lateinit var mPriceTv: TextView
    private lateinit var mBuyBtn: Button
    private lateinit var mViewModel: WatchDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initViewModel()
        observeViewModel()
    }

    private fun showLoading(show: Boolean) {
        if (show) {
            mPriceTv.text = "loading.."
        }
    }

    private fun observeViewModel() {
        mBuyBtn.setOnClickListener {
            mViewModel.buyWatch()
        }

        mViewModel.priceLiveData.observe(this, Observer<String> { price ->
            price ?: return@Observer
            mPriceTv.text = price
        })

        mViewModel.priceLoading.observe(this, Observer { show ->
            showLoading(show);
        })

        mViewModel.toastData.observe(this, Observer { msg ->
            Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
        })

        mViewModel.buyResult.observe(this, Observer { result ->
            // 这里可以做一些购买成功或者失败View相关逻辑
            if (result) {
                Toast.makeText(applicationContext, "购买成功", Toast.LENGTH_SHORT).show()
            } else {

            }
        })
    }

    private fun initViewModel() {
        mViewModel =
            ViewModelProviders.of(this, ViewModelFactory()).get(WatchDetailViewModel::class.java)
        mViewModel.loadWatchInfo()
    }

    private fun initView() {
        mPriceTv = findViewById(R.id.tv_price)
        mBuyBtn = findViewById(R.id.btn_buy)
    }
}
