package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.endity.Kisiler
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.ui.adapter.KisilerAdapter
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasi.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
//        binding.rv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)

        viewModel.kisilerListesi.observe(viewLifecycleOwner){
            val kisilerAdapter = KisilerAdapter(requireContext(),it,viewModel)
            binding.rv.adapter = kisilerAdapter
        }



        binding.fab.setOnClickListener {
            Navigation.gecis(it,R.id.kisiKayitGecis)
        }
//        binding.buttoDetay.setOnClickListener {
//            val kisi = Kisiler(1,"Ahmet", "1111")
//            val gecis =AnasayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
//            Navigation.findNavController(it).navigate(gecis)
//        }

        binding.searchId.setOnQueryTextListener(object:android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                ara(query)
                return false
            }


        })
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun ara(aramaKelimesi:String){
        viewModel.ara(aramaKelimesi)
    }

    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
    }
}