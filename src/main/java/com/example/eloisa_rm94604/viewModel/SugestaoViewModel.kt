package com.example.eloisa_rm94604.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.example.eloisa_rm94604.data.SugestaoDao
import com.example.eloisa_rm94604.data.SugestaoDatabase
import com.example.eloisa_rm94604.model.SugestaoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

    class SugestaoViewModel (application: Application) : AndroidViewModel(application) {
        private val sugestaoDao: SugestaoDao

        val sugestaoesLiveData: LiveData<List<SugestaoModel>>

        init {
            val database = databaseBuilder(
                getApplication(),
                SugestaoDatabase::class.java,
                "sugestoes_database"
            ).build()

            sugestaoDao= database.sugestaoDao()

            sugestaoesLiveData = sugestaoDao.getAll()
        }

        fun addSugestao(titulo: String, descricao: String) {
            viewModelScope.launch(Dispatchers.IO) {
                val newDica = SugestaoModel(titulo = titulo, descricao = descricao)
                sugestaoDao.insert(newDica)
            }
        }

        fun removeSugestao(dica: SugestaoModel) {
            viewModelScope.launch(Dispatchers.IO) {
                sugestaoDao.delete(dica)
            }
        }
    }