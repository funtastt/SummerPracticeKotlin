package com.itis.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.itis.summerpractice.databinding.FragmentHomeBinding
import com.itis.summerpractice.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private var binding: FragmentSettingsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)
        val btn = binding!!.btnFromSettings

        val bundle = bundleOf("name" to "Hello from SettingsFragment")

        btn.setOnClickListener { Navigation.findNavController(view).navigate(R.id.nav_from_settings_to_second, bundle) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}