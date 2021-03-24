package br.com.assessmentfundamentoskotlin.ui.doacao.lista

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.assessmentfundamentoskotlin.MockDoacoes
import br.com.assessmentfundamentoskotlin.ui.model.Doacao

class ListaDoacaoViewModel : ViewModel() {

    private val _doacoes = MutableLiveData<List<Doacao>>();
    val doacoes: LiveData<List<Doacao>>
        get() =  _doacoes

    fun listarDoacoes() {
        _doacoes.value = MockDoacoes.doacoes;
    }
}