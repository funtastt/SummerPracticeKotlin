package com.itis.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.itis.summerpractice.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var binding: FragmentHomeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        val btn = binding!!.btnFromHome

        val bundle = bundleOf("name" to "Hello from HomeFragment")

        btn.setOnClickListener { Navigation.findNavController(view).navigate(R.id.nav_from_home_to_first, bundle) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}