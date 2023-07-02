package com.itis.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.itis.summerpractice.databinding.FragmentFirstBinding
import com.itis.summerpractice.databinding.FragmentFourthBinding
import com.itis.summerpractice.databinding.FragmentHomeBinding

class FourthFragment : Fragment(R.layout.fragment_fourth) {
    private var binding: FragmentFourthBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFourthBinding.bind(view)

        val btn = binding!!.returnToGalleryBtn

        var msg = arguments?.getString("name")
        if (msg != null) {
            Snackbar.make(binding!!.root, msg, Snackbar.LENGTH_SHORT).show()
        }

        btn.setOnClickListener { Navigation.findNavController(view).navigateUp() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}