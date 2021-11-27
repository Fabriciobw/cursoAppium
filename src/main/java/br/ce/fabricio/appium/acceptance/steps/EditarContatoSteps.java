package br.ce.fabricio.appium.acceptance.steps;

import org.junit.Assert;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;

public class EditarContatoSteps extends BaseSteps{
	
	
	@Dado("o contato {string} {string} para ser editado")
	  public void o_contato_para_ser_editado(String nome, String sobrenome) {
		  contatoPo.clicaBarraDePesquisa();
		  contatoPo.pesquisar(nome + " " + sobrenome);
	      contatoPo.abrirContatoPesquisado();
	      contatoPo.clicaEditar();
	  }

	@Quando("os dados {string} {string} e {string} são adicionados")
	  public void os_dados_e_são_substituidos_pelos_anteriores(String nomeEditado, String sobrenomeEditado, String numeroEditado) throws InterruptedException {
		  contatoPo.esperar(2000);
		  contatoPo.limparCampos();
		  contatoPo.escreveNome(nomeEditado);
		  contatoPo.escreveSobrenome(sobrenomeEditado);
		  contatoPo.escreveTelefone(numeroEditado);
		  contatoPo.clicaSalvar();
	  }

	@Entao("o registro deve ser editado contendo {string} {string} e {string}")
	  public void o_registro_deve_ser_editado_no_e(String nomeEditado, String sobrenomeEditado, String numeroEditado) {
		
		 Assert.assertEquals(nomeEditado +" "+ sobrenomeEditado, contatoPo.getNomeSobrenomeContato());
		 Assert.assertEquals(numeroEditado, contatoPo.getTelefone());
		  contatoPo.voltar();
	}
}
