package br.com.assessmentfundamentoskotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.assessmentfundamentoskotlin.R
import br.com.assessmentfundamentoskotlin.ui.model.Doacao
import kotlinx.android.synthetic.main.lista_doacao_adapter.view.*

class DoacaoRecycleAdapter(private val doacoes: List<Doacao>, private val actionClick: (Doacao) -> Unit ) :
    RecyclerView.Adapter<DoacaoRecycleAdapter.DoacaoViewHolder>(){

    class DoacaoViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val txtDescricaoProduto = view.txtAdapterDescricao
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoacaoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lista_doacao_adapter, parent, false)
        return DoacaoViewHolder(view)
    }

    override fun getItemCount(): Int = doacoes.size

    override fun onBindViewHolder(holder: DoacaoViewHolder, position: Int) {
        val produto = doacoes.get(position)
        holder.txtDescricaoProduto.text = produto.nome

        holder.itemView.setOnClickListener{
            actionClick(produto)
        }
    }

}