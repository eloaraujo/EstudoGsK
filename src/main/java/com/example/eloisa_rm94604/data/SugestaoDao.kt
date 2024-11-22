package com.example.eloisa_rm94604.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.eloisa_rm94604.model.SugestaoModel

@Dao
interface SugestaoDao{

        @Query("SELECT * FROM SugestaoModel")
        fun getAll(): LiveData<List<SugestaoModel>>

        @Insert
        fun insert(item: SugestaoModel)

        @Delete
        fun delete(item: SugestaoModel)

}