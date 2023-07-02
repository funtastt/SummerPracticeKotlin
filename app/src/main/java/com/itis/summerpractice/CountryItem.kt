package com.itis.summerpractice

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.itis.summerpractice.databinding.ItemCountryBinding

class CountryItem(
    private val binding: ItemCountryBinding,
    private val glide: RequestManager,
    private val onItemClick: (Country) -> Unit,
) : ViewHolder(binding.root) {
    private val options: RequestOptions = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)


    fun onBind(country: Country) {
        binding.run {
            tvName.text = country.name
            tvCapital.text = country.capital

            glide
                .load(country.url)
                .error(R.drawable.error)
                .apply(options)
                .into(ivFlag)

            root.setOnClickListener {
                onItemClick(country)
            }
        }
    }
}