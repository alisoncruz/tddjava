package br.com.tddjava.service;

import br.com.tddjava.models.Filme;
import br.com.tddjava.models.Locacao;
import br.com.tddjava.models.Usuario;
import br.com.tddjava.utils.DataUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class LocalServiceTest {

    

    @Test
    public void teste() {
        //cenário
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 2, 5.0);

        //ação
        Locacao locacao = service.alugarFilme(usuario, filme);

        //verificação
        Assert.assertTrue(locacao.getValor() == 5.0);
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
    }
}
