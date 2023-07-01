package com.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.itis.summerpractice.databinding.FragmentHomeBinding
import com.itis.summerpractice.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment(R.layout.fragment_notifications) {
    private var binding: FragmentNotificationsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNotificationsBinding.bind(view)
        val btn = binding!!.btnFromNotifications
        val bundle = bundleOf("name" to "Hello from NotificationsFragment")


        btn.setOnClickListener { Navigation.findNavController(view).navigate(R.id.nav_from_notifications_to_fifth, bundle) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}