package com.example.fake_store.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.fake_store.data.product.ResponseProductItem
import com.example.fake_store.databinding.Itemlist1Binding

class HomeAdapter(private val listener: Listener) :
    ListAdapter<ResponseProductItem, HomeAdapter.HomeViewHolder>(comparator) {


    interface Listener {
        fun itemClick(id: Int)
    }


    class HomeViewHolder(val binding: Itemlist1Binding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            Itemlist1Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        getItem(position).let {

            holder.binding.apply {
                productImage.load(it.image)
                productName.text = it.title
                productsOfferPrice.text = "$ ${it.price}"
                productDescription.text = it.description
                categoryTV.text = it.category
                ratingTV.text = "${it.rating.rate}"
                ratingTotalTV.text = "(${it.rating.count})"

                holder.itemView.setOnClickListener {

                    listener.itemClick(it.id)
                }


            }

        }
    }


}