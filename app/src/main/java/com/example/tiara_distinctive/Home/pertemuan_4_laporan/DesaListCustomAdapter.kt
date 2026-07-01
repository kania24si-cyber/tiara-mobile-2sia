package com.example.tiara_distinctive.Home.pertemuan_4_laporan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.tiara_distinctive.R

// ===== PERTEMUAN 7: Custom Adapter untuk ListView (gambar + teks, menggunakan Glide) =====
class DesaListCustomAdapter(
    context: Context,
    private val dataList: List<DesaItemModel>
) : ArrayAdapter<DesaItemModel>(context, R.layout.item_desa_list, dataList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_desa_list, parent, false)

        val item = dataList[position]

        val imgAvatar   = view.findViewById<ImageView>(R.id.imgItemAvatar)
        val tvNama      = view.findViewById<TextView>(R.id.tvItemNama)
        val tvKontak    = view.findViewById<TextView>(R.id.tvItemKontak)

        tvNama.text   = item.nama
        tvKontak.text = item.kontak

        // Load gambar menggunakan Glide
        Glide.with(context)
            .load(item.imageUrl)
            .circleCrop()
            .placeholder(R.drawable.desasface)
            .into(imgAvatar)

        return view
    }
}
