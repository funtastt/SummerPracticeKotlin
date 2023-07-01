package com.itis.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.itis.summerpractice.databinding.FragmentFifthBinding
import com.itis.summerpractice.databinding.FragmentFirstBinding
import com.itis.summerpractice.databinding.FragmentHomeBinding

class FifthFragment : Fragment(R.layout.fragment_fifth) {
    private var binding: FragmentFifthBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFifthBinding.bind(view)

        var msg = arguments?.getString("name")
        if (msg != null) {
            Snackbar.make(binding!!.root, msg, Snackbar.LENGTH_SHORT).show()
        }

        val btn = binding!!.returnToNotificationsBtn

        btn.setOnClickListener { Navigation.findNavController(view).navigate(R.id.nav_from_fifth_to_notifications) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}