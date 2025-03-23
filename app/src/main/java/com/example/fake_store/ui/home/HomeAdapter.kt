package com.example.fake_store.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.fake_store.data.product.ResponseProductItem
import com.example.fake_store.databinding.Itemlist1Binding

class HomeAdapter : ListAdapter<ResponseProductItem, HomeAdapter.HomeViewHolder>(comparator) {


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


           }

       }
    }

    companion object {

        var comparator = object : DiffUtil.ItemCallback<ResponseProductItem>() {
            override fun areItemsTheSame(
                oldItem: ResponseProductItem,
                newItem: ResponseProductItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ResponseProductItem,
                newItem: ResponseProductItem
            ): Boolean {
                return oldItem.id == newItem.id
            }


        }


    }

}