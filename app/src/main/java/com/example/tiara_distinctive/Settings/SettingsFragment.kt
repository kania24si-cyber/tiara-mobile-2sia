package com.example.tiara_distinctive.Settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tiara_distinctive.R
import com.example.tiara_distinctive.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private val settingsList = listOf(
        SettingsModel("Privacy Policy"),
        SettingsModel("About Application"),
        SettingsModel("Help Center"),
        SettingsModel("Terms and Conditions"),
        SettingsModel("Contact Us"),
        SettingsModel("Logout")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)

        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            "Settings"

        val adapter = SettingsAdapter(requireContext(), settingsList)

        binding.listSettings.adapter = adapter

        binding.listSettings.setOnItemClickListener { _, _, position, _ ->

            Toast.makeText(
                requireContext(),
                "Menu: ${settingsList[position].title}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    }