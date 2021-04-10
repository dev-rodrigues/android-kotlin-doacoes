package br.com.assessmentfundamentoskotlin.ui.doacao.persist

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.assessmentfundamentoskotlin.MockDoacoes
import br.com.assessmentfundamentoskotlin.ui.model.Doacao

class PersistDoacaoViewModel : ViewModel() {

    fun cadastrarDoacao(doacao: Doacao) {
        doacao.img = _image.value
        MockDoacoes.doacoes.add(doacao)
    }

    private val _image = MutableLiveData<Uri>()
    val image: LiveData<Uri> = _image

    fun setImage(foto: Uri) {

        _image.value = foto
    }
}