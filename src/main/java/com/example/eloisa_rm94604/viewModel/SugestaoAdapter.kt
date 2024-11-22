package com.example.eloisa_rm94604.viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eloisa_rm94604.R
import com.example.eloisa_rm94604.model.SugestaoModel

/** @property onItemRemoved Callback que é chamado quando um item é removido.
*/
class SugestaoAdapter (private val onItemRemoved: (SugestaoModel) -> Unit) :
        RecyclerView.Adapter<SugestaoAdapter.SugestaoViewHolder>() {

        private var sugestoes = listOf<SugestaoModel>()

        inner class SugestaoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            val titulo = view.findViewById<TextView>(R.id.textViewItemTituloSugestao)
            val descricao = view.findViewById<TextView>(R.id.textViewItemDescricao)

            fun bind(item: SugestaoModel) {
                titulo.text = item.titulo
                descricao.text = item.descricao
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SugestaoViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.sugestao_layout, parent, false)
            return SugestaoViewHolder(view)
        }

        override fun getItemCount(): Int = sugestoes.size

        override fun onBindViewHolder(holder: SugestaoViewHolder, position: Int) {
            val sugestao = sugestoes[position]
            holder.bind(sugestao)
        }

        fun updateSugestoes(newSugestoes: List<SugestaoModel>) {
            sugestoes = newSugestoes
        }
}
