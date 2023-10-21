package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.endity.Kisiler
import com.example.kisileruygulamasi.room.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kdao:KisilerDao) {
    suspend fun kaydet(kisi_ad: String, kisi_tel: String) {
        val yeniKisi = Kisiler( 0 , kisi_ad,kisi_tel)
        kdao.kaydet(yeniKisi)
    }
    suspend fun guncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
        val cevap = kdao.guncelle( kisi_id, kisi_ad,kisi_tel)

    }
    suspend fun sil(kisi_id:Int){
        val silinenkisi = Kisiler( kisi_id,"","")
        kdao.sil(silinenkisi)
    }

    suspend fun kisileriYukle() : List<Kisiler> = withContext(Dispatchers.IO){
//        val liste = ArrayList<Kisiler>()
//        val k1 = Kisiler(1,"Ahmet", "1111")
//        val k2 = Kisiler(2,"Nurten", "2222")
//        val k3 = Kisiler(3,"Yusuf", "3333")
//        liste.add(k1)
//        liste.add(k2)
//        liste.add(k3)
        return@withContext kdao.KisileriYukle()
    }
    suspend fun ara(aramaKelimesi : String) : List<Kisiler> = withContext(Dispatchers.IO){
        return@withContext kdao.ara(aramaKelimesi)
    }
}