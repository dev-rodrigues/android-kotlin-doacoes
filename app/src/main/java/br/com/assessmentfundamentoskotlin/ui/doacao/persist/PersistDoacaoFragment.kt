package br.com.assessmentfundamentoskotlin.ui.doacao.persist

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
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
        viewModel = ViewModelProvider(this).get(PersistDoacaoViewModel::class.java)


        viewModel.image.observe(viewLifecycleOwner, Observer { uri ->

            if (uri != null)
                camera.setImageURI(uri)
        })

        return inflater.inflate(R.layout.persist_doacao_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSalvar.setOnClickListener {
            val descricao = txtPersistDescricao.text.toString()
            val endereco = txtPersistEndereco.text.toString()

            val doacao = Doacao(descricao, endereco, null)

            viewModel.cadastrarDoacao(doacao)

            findNavController().popBackStack()
        }
        camera.setOnClickListener{
            selecionarImagem()
        }
    }

    private fun selecionarImagem() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            val foto: Uri = data!!.data!!
            viewModel.setImage(foto)
        }
    }
}