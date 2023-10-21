package com.example.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi.data.endity.Kisiler
import com.example.kisileruygulamasi.databinding.CardTasarimBinding
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasi.utils.gecis
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext:Context, var kisilerListesi:List<Kisiler>, var viewModel :AnasayfaViewModel) :RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
       val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {//position : 0,1,2
        val kisi = kisilerListesi.get(position)
        val t = holder.tasarim
        t.textViewKisiAd.text = kisi.kisi_ad
        t.textViewKisiTel.text = kisi.kisi_tel

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it, "${kisi.kisi_id} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    sil(kisi.kisi_id)
                }.show()
        }

        t.cardViewSatir.setOnClickListener{
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi=kisi)
            Navigation.gecis(it,gecis)
        }
    }



    override fun getItemCount(): Int {
        return kisilerListesi.size
    }

    fun sil(kisi_id:Int){
        viewModel.sil(kisi_id)
    }

}