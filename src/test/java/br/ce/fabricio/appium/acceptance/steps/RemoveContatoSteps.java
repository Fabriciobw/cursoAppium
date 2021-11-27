package br.ce.fabricio.appium.acceptance.steps;
import org.junit.Assert;

import br.ce.fabricio.appium.page.mobile.ContatoPO;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class RemoveContatoSteps {
	
	ContatoPO contatoPo = new ContatoPO();
	
	@Dado("um contato da lista com {string} {string}")
	public void um_contato_da_lista_com(String nome, String sobrenome) {
		
		  contatoPo.clicaBarraDePesquisa();
		  contatoPo.pesquisar(nome + " " + sobrenome);
	}

	@Quando("o contato {string} é pressionado e deletado")
	public void o_contato_é_pressionado_e_deletado(String nome) throws InterruptedException {
		contatoPo.pressionarContato();
		contatoPo.clicaExcluirContato();
	}

	@Entao("{string} {string} não deve aparecer mais na lista de contatos")
	public void não_deve_aparecer_mais_na_lista_de_contatos(String nome, String sobrenome) throws InterruptedException {
		  contatoPo.esperar(2000);
		  contatoPo.clicaBarraDePesquisa();
		  contatoPo.pesquisar(nome + " " + sobrenome);
		  
		  Assert.assertThrows(IndexOutOfBoundsException.class,
		            ()->{
		            	contatoPo.abrirContatoPesquisado();
		            });
	}
}
