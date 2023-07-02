package com.itis.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.itis.summerpractice.databinding.ActivityMainBinding
import com.itis.summerpractice.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {
    private var binding: FragmentListBinding? = null
    private var adapter: CountryAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)

        initAdapter()
    }


    private fun initAdapter() {
        adapter = CountryAdapter(
            list = CountryRepository.list,
            glide = Glide.with(this),
            onItemClick = {country ->
                showDetailedInfo(country)
            })
        binding?.rvCountries?.adapter = adapter
        binding?.rvCountries?.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun showDetailedInfo(country: Country) {
        val bundle : Bundle = bundleOf("id" to country.id)
        this.findNavController().navigate(R.id.nav_from_list_to_item, bundle)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}