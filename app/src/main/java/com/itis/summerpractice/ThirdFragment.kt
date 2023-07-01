package com.itis.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.itis.summerpractice.databinding.FragmentFirstBinding
import com.itis.summerpractice.databinding.FragmentHomeBinding
import com.itis.summerpractice.databinding.FragmentThirdBinding

class ThirdFragment : Fragment(R.layout.fragment_third) {
    private var binding: FragmentThirdBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentThirdBinding.bind(view)

        var msg = arguments?.getString("name")
        if (msg != null) {
            Snackbar.make(binding!!.root, msg, Snackbar.LENGTH_SHORT).show()
        }

        val btn = binding!!.returnToCartBtn

        btn.setOnClickListener { Navigation.findNavController(view).navigate(R.id.nav_from_third_to_cart) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}