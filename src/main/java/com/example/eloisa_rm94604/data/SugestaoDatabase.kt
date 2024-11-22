package com.example.eloisa_rm94604.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.eloisa_rm94604.model.SugestaoModel

@Database(entities = [SugestaoModel::class], version = 1)
abstract class SugestaoDatabase : RoomDatabase() {

    abstract fun sugestaoDao() : SugestaoDao
}
