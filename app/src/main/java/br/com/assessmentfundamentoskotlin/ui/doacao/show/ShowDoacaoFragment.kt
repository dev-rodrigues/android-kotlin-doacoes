package br.com.assessmentfundamentoskotlin.ui.doacao.show

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import br.com.assessmentfundamentoskotlin.R
import br.com.assessmentfundamentoskotlin.ui.model.DoacaoDTO
import kotlinx.android.synthetic.main.fragment_show_doacao.*
import java.util.*

class ShowDoacaoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_show_doacao, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        if (Objects.nonNull(DoacaoDTO.doacaoSelecionada)) {
            txtShowDescricao.setText(DoacaoDTO.doacaoSelecionada?.nome)
            txtShowEndereco.setText(DoacaoDTO.doacaoSelecionada?.endereco)

            if (Objects.nonNull(DoacaoDTO.doacaoSelecionada?.img)) {
                showImage.setImageURI(DoacaoDTO.doacaoSelecionada?.img)
            }
        }
    }
}