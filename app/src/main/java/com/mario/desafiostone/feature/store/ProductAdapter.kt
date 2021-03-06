package com.mario.desafiostone.feature.store

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.mario.desafiostone.R
import com.mario.desafiostone.data.remote.Product
import com.mario.desafiostone.util.inflate
import com.mario.desafiostone.util.intFormat
import com.mario.desafiostone.util.loadUrl
import kotlinx.android.synthetic.main.item_product.view.*

/**
 * Created by mario on 9/24/17.
 */
class ProductAdapter(private val listener: (Product) -> Unit)
    : RecyclerView.Adapter<ViewHolder>() {

    var products = mutableListOf<Product>()
        set(elements) {
            field = elements
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.item_product))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(products[position], listener)

    override fun getItemCount() = products.size
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(product: Product, listener: (Product) -> Unit) = with(itemView) {
        tv_item_product_title.text = product.title
        tv_item_product_seller.text = product.seller
        tv_item_product_price.text = product.price.intFormat()
        img_item_product_image.loadUrl(product.thumbnailHd)
        setOnClickListener { listener(product) }
    }
}