package com.example.tiara_distinctive.Home.pertemuan_4_laporan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tiara_distinctive.R

class SatuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_satu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ===== PERTEMUAN 7: ListView dengan ArrayAdapter (simple_list_item_1) =====
        val listView = view.findViewById<ListView>(R.id.listViewProfil)

        val dataDesa = listOf(
            "🏡 Nama Desa       : Desa Maju Bersama",
            "🗺️ Kecamatan      : Kecamatan Sejahtera",
            "🏙️ Kabupaten      : Kabupaten Riau",
            "👥 Jumlah Penduduk : ± 3.200 jiwa",
            "🏠 Jumlah KK       : 850 KK",
            "📐 Luas Wilayah    : 12,5 km²",
            "🌾 Mata Pencaharian: Pertanian & Perkebunan",
            "📅 Tahun Berdiri  : 1945"
        )

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            dataDesa
        )

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                requireContext(),
                dataDesa[position],
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}