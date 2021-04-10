package br.com.assessmentfundamentoskotlin

import br.com.assessmentfundamentoskotlin.ui.model.Doacao

object MockDoacoes {
    var doacoes : MutableList<Doacao> = mutableListOf(
        Doacao("Cadeira", "Estrada do Tindiba, 2030", null),
        Doacao("Mesa", "Estrada do Tindiba, 2030", null),
        Doacao("Geladeira", "Estrada do Tindiba, 2030", null)
    )
}