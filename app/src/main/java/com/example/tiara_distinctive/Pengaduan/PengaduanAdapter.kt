package com.example.tiara_distinctive.Pengaduan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tiara_distinctive.data.entity.PengaduanEntity
import com.example.tiara_distinctive.databinding.ItemPengaduanBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class PengaduanAdapter(
    private val list: List<PengaduanEntity>,
    private val fragment: PengaduanFragment
) : RecyclerView.Adapter<PengaduanAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemPengaduanBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPengaduanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvTitle.text = item.title
        holder.binding.tvContent.text = item.content

        holder.binding.btnDelete.setOnClickListener {
            MaterialAlertDialogBuilder(holder.itemView.context)
                .setTitle("Hapus Pengaduan")
                .setMessage("Hapus pengaduan ini?")
                .setPositiveButton("Ya") { _, _ -> fragment.deletePengaduan(item) }
                .setNegativeButton("Batal", null)
                .show()
        }
    }

    override fun getItemCount(): Int = list.size
}