package br.edu.iesb.android2.whatsup.view.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.edu.iesb.android2.whatsup.domain.ItemResult
import br.edu.iesb.android2.whatsup.R
import br.edu.iesb.android2.whatsup.domain.Response
import br.edu.iesb.android2.whatsup.domain.Retorno
import br.edu.iesb.android2.whatsup.viewmodel.MainViewModel

class MyItemRecyclerViewAdapter(private val values: List<Retorno>?) :
    RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values?.get(position)
        if(item != null) {
            holder.textView1.text = item.pergunta
            holder.textView2.text = item.resposta
        }
    }

    override fun getItemCount(): Int = values?.size ?: 0

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView1: TextView = view.findViewById(R.id.tvTitleChatCard)
        val textView2: TextView = view.findViewById(R.id.tvSubtitleChatCard)
    }
}