package com.example.eloisa_rm94604.model

import androidx.room.PrimaryKey

data class SugestaoModel(
    @PrimaryKey(autoGenerate = true)    // Anotação que indica que este campo é a chave primária da tabela.
    val id: Int = 0,    // O valor padrão é 0, mas será substituído pelo valor gerado automaticamente pelo Room.
    val titulo: String,
    val descricao: String
)
