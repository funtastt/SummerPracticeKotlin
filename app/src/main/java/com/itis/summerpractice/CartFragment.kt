package com.itis.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.itis.summerpractice.databinding.FragmentCartBinding
import com.itis.summerpractice.databinding.FragmentHomeBinding

class CartFragment : Fragment(R.layout.fragment_cart) {
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCartBinding.bind(view)
        val btn = binding.btnFromCart
        val bundle = bundleOf("name" to "Hello from CartFragment")

        btn.setOnClickListener { Navigation.findNavController(view).navigate(R.id.nav_from_cart_to_third, bundle) }
    }
}