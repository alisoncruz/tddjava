package br.com.tddjava.service;

import br.com.tddjava.models.Filme;
import br.com.tddjava.models.Locacao;
import br.com.tddjava.models.Usuario;
import br.com.tddjava.utils.DataUtils;

import javax.naming.AuthenticationNotSupportedException;
import java.util.Date;

import static br.com.tddjava.utils.DataUtils.adicionarDias;

public class LocacaoService {

    public Locacao alugarFilme(Usuario usuario, Filme filme) {

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

    public static void main(String[] args) {
        //cenário
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 2, 5.0);

        //ação
        Locacao locacao = service.alugarFilme(usuario, filme);

        //verificação
        System.out.println(locacao.getValor() == 5.0);
        System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(),new Date()));
        System.out.println(DataUtils.isMesmaData(locacao.getDataRetorno(),DataUtils.obterDataComDiferencaDias(1)));

    }
}
