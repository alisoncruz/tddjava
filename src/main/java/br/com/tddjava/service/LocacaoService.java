package br.com.tddjava.service;

import br.com.tddjava.models.Filme;
import br.com.tddjava.models.Locacao;
import br.com.tddjava.models.Usuario;

import java.util.Date;

import static br.com.tddjava.utils.DataUtils.adicionarDias;

public class LocacaoService {

    public Locacao alugarFilme(Usuario usuario, Filme filme) throws Exception {

        if (filme.getEstoque() == 0) {
            throw new Exception("Estoque do filme está vazio");
        }

        Locacao locacao = new Locacao();
        locacao.setFilme(filme);
        locacao.setUsuario(usuario);
        locacao.setDataLocacao(new Date());
        locacao.setValor(filme.getPrecoLocacao());

        // Entrega no dia seguinte
        Date dataEntrega = new Date();
        dataEntrega = adicionarDias(dataEntrega, 1);
        locacao.setDataRetorno(dataEntrega);

        // Salvando a locacao...
        // TODO adicionar mÃ©todo para salvar

        return locacao;
    }
}
