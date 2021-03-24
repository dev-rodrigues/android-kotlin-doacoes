package br.com.assessmentfundamentoskotlin.ui.doacao.persist

import androidx.lifecycle.ViewModel
import br.com.assessmentfundamentoskotlin.MockDoacoes
import br.com.assessmentfundamentoskotlin.ui.model.Doacao

class PersistDoacaoViewModel : ViewModel() {
    fun cadastrarDoacao(doacao: Doacao) {
        MockDoacoes.doacoes.add(doacao)
    }
}