package com.mario.desafiostone.feature.store

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.mario.desafiostone.R
import com.mario.desafiostone.data.remote.Product
import com.mario.desafiostone.feature.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class StoreActivity : BaseActivity<StoreContract.View,
        StorePresenter>(),
        StoreContract.View,
        BottomNavigationView.OnNavigationItemSelectedListener{

    private val mAdapter by lazy {
        ProductAdapter{product -> Toast.makeText(this,product.title,Toast.LENGTH_LONG).show() }
    }

    override var mPresenter: StorePresenter = StorePresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(this)

        setRecycleView()

        mPresenter.loadProducts()

        showProgress()

    }


    override fun showProducts(products: MutableList<Product>) {
        mAdapter?.products = products
        mAdapter?.notifyDataSetChanged()
        hideProgress()
    }

    private fun hideProgress() {
        progressBar.visibility = View.GONE
        rc_products.visibility = View.VISIBLE
    }

    private fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    private fun setRecycleView() {
        rc_products.setHasFixedSize(true)
        rc_products.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rc_products.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rc_products.adapter = mAdapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_store -> {
                 Toast.makeText(this,"Store Select",Toast.LENGTH_LONG).show()
                return true
            }
            R.id.navigation_cart -> {
                Toast.makeText(this,"Cart Select",Toast.LENGTH_LONG).show()
                return true
            }
        }
        return false
    }

    override fun showError(erro: String) {
        super.showError(erro)
        progressBar.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

}