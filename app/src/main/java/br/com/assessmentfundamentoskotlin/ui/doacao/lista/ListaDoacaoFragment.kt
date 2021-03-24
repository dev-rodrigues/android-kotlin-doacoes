package br.com.assessmentfundamentoskotlin.ui.doacao.lista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.assessmentfundamentoskotlin.R
import br.com.assessmentfundamentoskotlin.adapter.DoacaoRecycleAdapter
import br.com.assessmentfundamentoskotlin.ui.model.Doacao
import br.com.assessmentfundamentoskotlin.ui.model.DoacaoDTO
import kotlinx.android.synthetic.main.lista_doacao_fragment.*

class ListaDoacaoFragment : Fragment() {

    private lateinit var viewModel: ListaDoacaoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.lista_doacao_fragment, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(ListaDoacaoViewModel::class.java)

        viewModel.listarDoacoes();

        viewModel.doacoes.observe(viewLifecycleOwner, Observer {
            setupListaDoacoes(it)
        });

        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn_nova_doacao.setOnClickListener {
            findNavController().navigate(R.id.persistDoacaoFragment)
        }
    }

    private fun setupListaDoacoes(doacoes: List<Doacao>) {
        lista_doacoes.adapter = DoacaoRecycleAdapter(doacoes) {
            DoacaoDTO.doacaoSelecionada = it
            findNavController().navigate(R.id.showDoacaoFragment)
        }
        lista_doacoes.layoutManager = LinearLayoutManager(requireContext())
    }
}
