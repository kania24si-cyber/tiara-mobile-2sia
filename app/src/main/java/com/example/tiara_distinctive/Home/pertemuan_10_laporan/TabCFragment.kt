package com.example.tiara_distinctive.Home.pertemuan_10_laporan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tiara_distinctive.R
import com.example.tiara_distinctive.databinding.FragmentTabCBinding

class TabCFragment : Fragment() {

    private var _binding: FragmentTabCBinding? = null
    private val binding get() = _binding!!

    private val productList = listOf(

        ProductModel(
            "Balai Desa",
            "Pusat pelayanan administrasi desa",
            "https://picsum.photos/seed/desa1/400/300"
        ),

        ProductModel(
            "Posyandu",
            "Layanan kesehatan masyarakat desa",
            "https://picsum.photos/seed/desa2/400/300"
        ),

        ProductModel(
            "UMKM Desa",
            "Produk usaha masyarakat desa",
            "https://picsum.photos/seed/desa3/400/300"
        ),

        ProductModel(
            "Wisata Desa",
            "Tempat wisata unggulan desa",
            "https://picsum.photos/seed/desa4/400/300"
        ),

        ProductModel(
            "Perpustakaan",
            "Fasilitas baca masyarakat desa",
            "https://picsum.photos/seed/desa5/400/300"
        ),

        ProductModel(
            "Lapangan Desa",
            "Tempat olahraga masyarakat",
            "https://picsum.photos/seed/desa6/400/300"
        ),

        ProductModel(
            "Pasar Desa",
            "Pusat jual beli masyarakat",
            "https://picsum.photos/seed/desa7/400/300"
        ),

        ProductModel(
            "Bank Sampah",
            "Pengelolaan sampah desa",
            "https://picsum.photos/seed/desa8/400/300"
        ),

        ProductModel(
            "Kantor RT",
            "Pelayanan administrasi warga",
            "https://picsum.photos/seed/desa9/400/300"
        ),

        ProductModel(
            "Aula Desa",
            "Tempat kegiatan masyarakat",
            "https://picsum.photos/seed/desa10/400/300"
        ),

        ProductModel(
            "Taman Bermain",
            "Fasilitas bermain anak desa",
            "https://picsum.photos/seed/desa11/400/300"
        ),

        ProductModel(
            "Masjid Desa",
            "Tempat ibadah masyarakat",
            "https://picsum.photos/seed/desa12/400/300"
        ),

        ProductModel(
            "Klinik Desa",
            "Pelayanan kesehatan desa",
            "https://picsum.photos/seed/desa13/400/300"
        ),

        ProductModel(
            "Kebun Desa",
            "Area pertanian masyarakat",
            "https://picsum.photos/seed/desa14/400/300"
        ),

        ProductModel(
            "Gedung Serbaguna",
            "Tempat acara dan rapat warga",
            "https://picsum.photos/seed/desa15/400/300"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTabCBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)

        val adapter = ProductAdapter(productList) { selectedItem ->

            Toast.makeText(
                requireContext(),
                "Anda memilih ${selectedItem.name}",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.rvProducts.apply {

            layoutManager = LinearLayoutManager(requireContext())

            setHasFixedSize(true)

            isNestedScrollingEnabled = true

            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
