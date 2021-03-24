package br.com.assessmentfundamentoskotlin.ui.doacao.persist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.assessmentfundamentoskotlin.R
import br.com.assessmentfundamentoskotlin.ui.model.Doacao
import kotlinx.android.synthetic.main.persist_doacao_fragment.*

class PersistDoacaoFragment : Fragment() {


    private lateinit var viewModel: PersistDoacaoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(PersistDoacaoViewModel::class.java)
        return inflater.inflate(R.layout.persist_doacao_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSalvar.setOnClickListener {
            val descricao = txtPersistDescricao.text.toString()
            val endereco = txtPersistEndereco.text.toString()

            val doacao = Doacao(descricao, endereco)

            viewModel.cadastrarDoacao(doacao)

            findNavController().popBackStack()
        }
    }



}