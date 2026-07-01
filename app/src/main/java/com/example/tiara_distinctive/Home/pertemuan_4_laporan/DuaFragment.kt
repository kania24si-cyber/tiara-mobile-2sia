package com.example.tiara_distinctive.Home.pertemuan_4_laporan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tiara_distinctive.R


class DuaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dua, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ===== PERTEMUAN 7: ListView dengan SimpleAdapter (simple_list_item_2) =====
        val listView = view.findViewById<ListView>(R.id.listViewFasilitas)

        val dataFasilitas = listOf(
            mapOf("nama" to "🏟️ Aula Serbaguna",   "info" to "Kapasitas: 200 orang"),
            mapOf("nama" to "⚽ Lapangan Olahraga",  "info" to "Futsal & Badminton"),
            mapOf("nama" to "📚 Perpustakaan Desa",  "info" to "Koleksi: 1.500+ buku"),
            mapOf("nama" to "🌿 Taman Desa",         "info" to "Luas: 2.000 m²"),
            mapOf("nama" to "🏥 Posyandu",           "info" to "Buka Senin–Jumat"),
            mapOf("nama" to "🕌 Masjid Desa",        "info" to "Kapasitas: 500 jamaah"),
            mapOf("nama" to "🏫 Balai Desa",         "info" to "Pusat Administrasi"),
            mapOf("nama" to "🛒 Pasar Desa",         "info" to "Buka setiap hari")
        )

        val adapter = SimpleAdapter(
            requireContext(),
            dataFasilitas,
            android.R.layout.simple_list_item_2,
            arrayOf("nama", "info"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val item = dataFasilitas[position]
            Toast.makeText(
                requireContext(),
                "${item["nama"]} — ${item["info"]}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}