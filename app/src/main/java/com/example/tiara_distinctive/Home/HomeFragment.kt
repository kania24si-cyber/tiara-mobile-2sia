package com.example.tiara_distinctive.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tiara_distinctive.Home.pertemuan_2_laporan.HitungActivity
import com.example.tiara_distinctive.Home.pertemuan_3_laporan.LoginActivity
import com.example.tiara_distinctive.Home.pertemuan_4_laporan.SeventhActivity
import com.example.tiara_distinctive.Home.pertemuan_4_laporan.Custom2Activity
import com.example.tiara_distinctive.Home.pertemuan_6_laporan.WebViewActivity
import com.example.tiara_distinctive.Home.pertemuan_9_laporan.NinthActivity
import com.example.tiara_distinctive.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = requireContext().getSharedPreferences("session_user", MODE_PRIVATE)
        // AMBIL USERNAME DARI LOGIN
        val username = requireActivity().intent.getStringExtra("USERNAME")


        // TAMPILKAN USERNAME
        binding.textUsername.text = "Halo, $username 👋"

        binding.btnRumus.setOnClickListener {
            val intent = Intent(requireContext(), HitungActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
        binding.btnCustom1.setOnClickListener {
            val intent = Intent(requireContext(), SeventhActivity::class.java)
            startActivity(intent)

        }
        binding.btnToNinth.setOnClickListener {
            val intent = Intent(requireContext(), NinthActivity::class.java)
            startActivity(intent)

        }
        binding.btnBinaDesa.setOnClickListener {
            val intent = Intent(requireContext(), WebViewActivity::class.java)
            startActivity(intent)

        }
        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    val intent = Intent(requireContext(), LoginActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                    dialog.dismiss()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Tidak!")
                }
                .show()
        }

    }
}