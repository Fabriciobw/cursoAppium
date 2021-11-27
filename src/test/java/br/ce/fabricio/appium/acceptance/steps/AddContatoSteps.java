package br.ce.fabricio.appium.acceptance.steps;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import br.ce.fabricio.appium.page.mobile.ContatoPO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;


public class AddContatoSteps  {
	
	  ContatoPO contatoPo = new ContatoPO();
	  String nome = null;
	  String sobrenome = null;
	  String numero = null;
      List<Map<String,String>> valores = null;
      
	  @Dado("nome, sobrenome e numero")
	  public void nome_sobrenome_e_numero(DataTable dataTable) {
		  valores = dataTable.asMaps();
	  }

	  @Quando("sao preenchidos e salvos")
	  public void sao_preenchidos_e_salvos() throws InterruptedException {
		  
		  for( Map<String, String> mapa: valores) {
	    	   nome = mapa.get("nome");
	    	   sobrenome = mapa.get("sobrenome");
	    	   numero = mapa.get("numero");
	    	   
	    	   contatoPo.clicaNovoContato();
	 		   contatoPo.escreveNome(nome);
	 		   contatoPo.escreveSobrenome(sobrenome);
	 		   contatoPo.escreveTelefone(numero);
	 		   contatoPo.clicaSalvar();
	 		   contatoPo.voltar();
	 		   contatoPo.esperar(2000);
	      }
		 
	  }
	  @Entao("devem aparecer na lista de contatos")
	  public void devem_aparecer_na_lista_de_contatos() throws InterruptedException {
		   
		  contatoPo.clicaBarraDePesquisa();
		  for( Map<String, String> mapa: valores) {
	    	   nome = mapa.get("nome"); 
	    	   sobrenome = mapa.get("sobrenome");
	    	  contatoPo.pesquisar(nome + " " + sobrenome);
	 		  Assert.assertTrue(contatoPo.isContatoPresente(nome,sobrenome));
	    	   
	      }
	  }
	  
	  
	  

}


