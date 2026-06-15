package com.example.tiara_distinctive.Agenda

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tiara_distinctive.R
import com.example.tiara_distinctive.data.AppDatabase
import com.example.tiara_distinctive.data.entity.AgendaEntity
import com.example.tiara_distinctive.databinding.FragmentAgendaBinding
import kotlinx.coroutines.launch

class AgendaFragment : Fragment() {
    private var _binding: FragmentAgendaBinding? = null
    private val binding get() = _binding!!

    private lateinit var db: AppDatabase
    private lateinit var adapter: AgendaAdapter
    private val listAgenda = mutableListOf<AgendaEntity>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAgendaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = AppDatabase.getInstance(requireContext())

        adapter = AgendaAdapter(listAgenda, this)
        binding.rvAgenda.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAgenda.adapter = adapter
        binding.rvAgenda.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )

        binding.fabAddAgenda.setOnClickListener {
            startActivity(Intent(requireContext(), AgendaFormActivity::class.java))
        }
    }

    fun fetchAgenda() {
        lifecycleScope.launch {
            val data = db.agendaDao().getAll()
            listAgenda.clear()
            listAgenda.addAll(data)
            adapter.notifyDataSetChanged()
        }
    }

    fun deleteAgenda(agenda: AgendaEntity) {
        lifecycleScope.launch {
            db.agendaDao().delete(agenda)
            fetchAgenda()
        }
    }

    override fun onResume() {
        super.onResume()
        fetchAgenda()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}