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

class FirstFragment : Fragment(R.layout.fragment_first) {
    private var binding: FragmentFirstBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFirstBinding.bind(view)

        var msg = arguments?.getString("name")
        if (msg != null) {
            Snackbar.make(binding!!.root, msg, Snackbar.LENGTH_SHORT).show()
        }

        val btn = binding!!.returnToHomeBtn

        btn.setOnClickListener { Navigation.findNavController(view).navigateUp()}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun bundleArgs(name: String) = Bundle().apply {
        putString("ARG_NAME", name)
    }
}