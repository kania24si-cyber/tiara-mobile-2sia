package com.example.tiara_distinctive.Tutorial

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.tiara_distinctive.Home.pertemuan_3_laporan.LoginActivity
import com.example.tiara_distinctive.R

class Tutorial3Fragment : Fragment(
    R.layout.fragment_tutorial3
) {

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        val btnMulai =
            view.findViewById<Button>(R.id.btnMulai)

        btnMulai.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    LoginActivity::class.java
                )
            )

            requireActivity().finish()
        }
    }
}