package br.com.assessmentfundamentoskotlin.ui.autenticacao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import br.com.assessmentfundamentoskotlin.R
import kotlinx.android.synthetic.main.fragment_autenticacao.*
import kotlinx.android.synthetic.main.fragment_autenticacao.view.*


class AutenticacaoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_autenticacao, container, false)

        val btnAutenticar = view.findViewById<Button>(R.id.btnAutenticar)
        btnAutenticar.setOnClickListener {
            findNavController().navigate(R.id.listaDoacaoFragment)
        }

        return  view
    }

}