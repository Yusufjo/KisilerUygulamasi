package com.example.kisileruygulamasi.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kisileruygulamasi.data.endity.Kisiler

@Dao//Database Access Object
interface KisilerDao {
    @Query("SELECT * FROM kisiler")
    suspend fun KisileriYukle(): List<Kisiler>

     @Insert
     suspend fun kaydet(kisi:Kisiler)

    @Update
    suspend fun guncelle(kisi:Kisiler)

    @Delete
    suspend fun sil(kisi:Kisiler)

    @Query("SELECT * FROM kisiler WHERE kisi_ad like '½'|| :aramaKelimesi || '½' ")
    suspend fun ara(aramaKelimesi:String): List<Kisiler>

    }
