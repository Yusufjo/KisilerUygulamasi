package com.example.kisileruygulamasi.retrofit

import com.example.kisileruygulamasi.data.endity.CRUDCevap

interface KisilerDao {
    fun kisileriyukle()

    suspend fun kaydet(kisi_ad:String,kisi_tel:Int):CRUDCevap

    suspend fun guncelle(Kisi_id:Int,kisi_ad: String,kisi_tel: String)

}