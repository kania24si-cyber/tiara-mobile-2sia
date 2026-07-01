package com.example.tiara_distinctive.Home.pertemuan_4_laporan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tiara_distinctive.R

class TigaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tiga, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ===== PERTEMUAN 7: ListView dengan Custom Adapter (gambar + teks, Glide) =====
        val listView = view.findViewById<ListView>(R.id.listViewKontak)

        val dataKontak = listOf(
            DesaItemModel("Kepala Desa",     "Bapak Ahmad Santoso — (0761) 123-4567",  "https://picsum.photos/seed/kepala/100/100"),
            DesaItemModel("Sekretaris Desa", "Ibu Sari Dewi — (0761) 123-4568",        "https://picsum.photos/seed/sekdes/100/100"),
            DesaItemModel("Bendahara Desa",  "Bapak Rudi Hartono — (0761) 123-4569",   "https://picsum.photos/seed/bendahara/100/100"),
            DesaItemModel("Kaur Umum",       "Ibu Lina Wati — (0761) 123-4570",        "https://picsum.photos/seed/kaur/100/100"),
            DesaItemModel("Kadus RT 01",     "Bapak Joko Susilo — 0812-3456-7890",     "https://picsum.photos/seed/kadus1/100/100"),
            DesaItemModel("Kadus RT 02",     "Bapak Budi Santoso — 0813-4567-8901",    "https://picsum.photos/seed/kadus2/100/100"),
            DesaItemModel("Posyandu",        "Bidan Siti Nurhaliza — 0814-5678-9012",  "https://picsum.photos/seed/bidan/100/100"),
            DesaItemModel("Keamanan Desa",   "Bapak Hasan Basri — 0815-6789-0123",    "https://picsum.photos/seed/satpam/100/100")
        )

        val adapter = DesaListCustomAdapter(requireContext(), dataKontak)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val item = dataKontak[position]
            Toast.makeText(
                requireContext(),
                "${item.nama}: ${item.kontak}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}