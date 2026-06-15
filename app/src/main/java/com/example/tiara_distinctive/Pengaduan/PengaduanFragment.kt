package com.example.tiara_distinctive.Pengaduan

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tiara_distinctive.Pengaduan.PengaduanAdapter
import com.example.tiara_distinctive.Pengaduan.PengaduanFormActivity
import com.example.tiara_distinctive.R
import com.example.tiara_distinctive.data.AppDatabase
import com.example.tiara_distinctive.data.entity.PengaduanEntity
import com.example.tiara_distinctive.databinding.FragmentPengaduanBinding
import kotlinx.coroutines.launch


class PengaduanFragment : Fragment() {
    private var _binding: FragmentPengaduanBinding? = null
    private val binding get() = _binding!!

    private lateinit var db: AppDatabase
    private lateinit var adapter: PengaduanAdapter
    private val listPengaduan = mutableListOf<PengaduanEntity>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPengaduanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = AppDatabase.getInstance(requireContext())

        adapter = PengaduanAdapter(listPengaduan, this)
        binding.rvPengaduan.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPengaduan.adapter = adapter
        binding.rvPengaduan.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )

        binding.fabAddPengaduan.setOnClickListener {
            startActivity(Intent(requireContext(), PengaduanFormActivity::class.java))
        }
    }

    fun fetchPengaduan() {
        lifecycleScope.launch {
            val data = db.pengaduanDao().getAll()
            listPengaduan.clear()
            listPengaduan.addAll(data)
            adapter.notifyDataSetChanged()
        }
    }

    fun deletePengaduan(pengaduan: PengaduanEntity) {
        lifecycleScope.launch {
            db.pengaduanDao().delete(pengaduan)
            fetchPengaduan()
        }
    }

    override fun onResume() {
        super.onResume()
        fetchPengaduan()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}