package com.example.tiara_distinctive.Agenda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tiara_distinctive.data.entity.AgendaEntity
import com.example.tiara_distinctive.databinding.ItemAgendaBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AgendaAdapter(
    private val list: List<AgendaEntity>,
    private val fragment: AgendaFragment
) : RecyclerView.Adapter<AgendaAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemAgendaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAgendaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvNamaKegiatan.text = item.namaKegiatan
        holder.binding.tvLokasi.text = item.lokasi

        holder.binding.btnDelete.setOnClickListener {
            MaterialAlertDialogBuilder(holder.itemView.context)
                .setTitle("Hapus Agenda")
                .setMessage("Hapus agenda kegiatan ini?")
                .setPositiveButton("Ya") { _, _ -> fragment.deleteAgenda(item) }
                .setNegativeButton("Batal", null)
                .show()
        }
    }

    override fun getItemCount(): Int = list.size
}