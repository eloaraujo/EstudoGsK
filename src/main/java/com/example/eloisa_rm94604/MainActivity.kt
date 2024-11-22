package com.example.eloisa_rm94604

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.eloisa_rm94604.viewModel.SugestaoAdapter
import com.example.eloisa_rm94604.viewModel.SugestaoViewModel
import com.example.eloisa_rm94604.viewModel.SugestaoViewModelFactory


class MainActivity : AppCompatActivity() {

        private lateinit var viewModel: SugestaoViewModel

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val toolbar: Toolbar = findViewById(R.id.toolbar)
            setSupportActionBar(toolbar)

            supportActionBar?.title = "EcoDicas"
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

            val sugestaoAdapter = SugestaoAdapter { sugestoes ->
                viewModel.removeSugestao(sugestoes)
            }

            recyclerView.adapter = sugestaoAdapter

            val button = findViewById<Button>(R.id.button)
            val titulo = findViewById<EditText>(R.id.editTextTituloSugestao)
            val descricao = findViewById<EditText>(R.id.editTextDescricao)

            button.setOnClickListener {
                if (titulo.text.isEmpty() && descricao.text.isEmpty()) {
                    titulo.error = "Preencha um valor"
                    descricao.error = "Preencha um valor"
                    return@setOnClickListener
                }

                viewModel.addSugestao(titulo.text.toString(), descricao.text.toString())
                titulo.text.clear()
                descricao.text.clear()
            }

            val viewModelFactory = SugestaoViewModelFactory(application)

            viewModel = ViewModelProvider(this, viewModelFactory).get(SugestaoViewModel::class.java)
            viewModel.sugestaoesLiveData.observe(this) { sugestoes ->
                sugestaoAdapter.updateSugestoes(sugestoes)
            }
        }
    }
