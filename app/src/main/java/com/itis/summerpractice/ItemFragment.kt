package com.itis.summerpractice

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.itis.summerpractice.databinding.FragmentItemBinding


class ItemFragment : Fragment(R.layout.fragment_item) {
    var binding: FragmentItemBinding? = null
    private val options: RequestOptions = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentItemBinding.bind(view)

        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        val id = arguments?.getLong("id")

        val glide : RequestManager = Glide.with(this)

        val country = CountryRepository.list.single{it.id == id}

        glide
            .load(country.url)
            .error(R.drawable.error)
            .apply(options)
            .into(binding!!.ivDetailedFlag)

        binding!!.tvDetailedName.text = country.name
        binding!!.tvDetailedCapital.text = country.capital
        binding!!.tvDetailedPopulation.text = "Population: " + country.population + " millions"
    }

    override fun onDestroy() {
        super.onDestroy()

        binding = null

    }
}