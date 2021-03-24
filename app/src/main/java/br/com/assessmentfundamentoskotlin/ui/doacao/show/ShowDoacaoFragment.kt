package br.com.assessmentfundamentoskotlin.ui.doacao.show

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.assessmentfundamentoskotlin.R
import br.com.assessmentfundamentoskotlin.ui.model.DoacaoDTO
import kotlinx.android.synthetic.main.fragment_show_doacao.*

class ShowDoacaoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_show_doacao, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtShowDescricao.setText(DoacaoDTO.doacaoSelecionada?.nome)
        txtShowEndereco.setText(DoacaoDTO.doacaoSelecionada?.endereco)
    }
}