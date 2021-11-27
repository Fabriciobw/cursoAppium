package br.ce.fabricio.appium.page.mobile;

import static br.ce.fabricio.appium.core.DriveFactory.getAppiumDriver;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.ce.fabricio.appium.core.DSLMobile;

public class ContatoPO {
	
	DSLMobile dsl = new DSLMobile();

	public ContatoPO(){
	    PageFactory.initElements(getAppiumDriver(), this);
	}
	
	@FindBy(id = "com.google.android.contacts:id/floating_action_button")
	private WebElement botaoFloat;
	
	@FindBy(xpath = "//android.widget.EditText[@text = 'First name']")
	private WebElement inputprimeiroNome;
	
	@FindBy(xpath = "//android.widget.EditText[@text = 'Phone']")
	private WebElement inputNumero;
	
	@FindBy(xpath =  "//android.widget.EditText[@text = 'Last name']")
	private WebElement inputSobrenome;
	
	@FindBy(id = "com.google.android.contacts:id/toolbar_button")
	private WebElement btnSalvar;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc = 'Navigate up']")
    private WebElement btnVoltar; 
	
	@FindBy(id = "com.google.android.contacts:id/open_search_bar_text_view")
	private WebElement inputPesquisaBotao;
	
	@FindBy(id = "com.google.android.contacts:id/open_search_view_edit_text")
	private WebElement inputPesquisa;
	
	@FindBy(id = "com.google.android.contacts:id/cliv_name_textview")
	private List<WebElement> listView;
	
	@FindBy(id = "com.google.android.contacts:id/large_title")
	private WebElement lblNomeSobrenome;
	
	@FindBy(id = "com.google.android.contacts:id/header")
	private WebElement lblNumero;
    
	@FindBy(id = "com.google.android.contacts:id/floating_action_button")
	private WebElement btnEditar;
	
	@FindBy(className = "android.widget.EditText")
	private List<WebElement> inputs;
	
	@FindBy(id = "com.google.android.contacts:id/menu_delete")
	private WebElement btnExcluir;
	
	@FindBy(id = "android:id/button1")
	private WebElement btnConfirmDelete;
	
	 public void clicaNovoContato() {
		dsl.click(botaoFloat);
	 }
	 
	 public void esperar(int time) throws InterruptedException {
		 Thread.sleep(time);
	 }
	 
	 public void escreveNome(String nome) {
		 dsl.sendText(inputprimeiroNome, nome); 
	 }
	 public void escreveTelefone(String telefone) {
		 dsl.sendText(inputNumero, telefone); 
	 }
	 
	 public void escreveSobrenome(String sobrenome) {
		 dsl.sendText(inputSobrenome, sobrenome); 
	 }
	 
	 
	 public void clicaSalvar() {
		 dsl.click(btnSalvar);
	 }
	 
	 public void voltar() {
		 dsl.click(btnVoltar);
	 }
	 
	 public void pesquisar(String nome) {
		 dsl.sendText(inputPesquisa, nome);
	 }
	 
	 public boolean isContatoPresente(String nome, String sobrenome) {
		
		 return dsl.elementIsPresent(listView,nome, sobrenome);
		
	 }

	public void clicaBarraDePesquisa() {
		dsl.click(inputPesquisaBotao);
		
	}

	public void abrirContatoPesquisado() {
		dsl.click(listView.get(0));
	}
	
	public String getNomeSobrenomeContato() {
		return dsl.getText(lblNomeSobrenome);
	}
	public String getTelefone() {
		return dsl.getText(lblNumero);
	}
	
	public void clicaEditar() {
		dsl.click(btnEditar);
	}

	public void limparCampos() {
		dsl.clearInputs(inputs);
	}
	
	public void pressionarContato() {
		dsl.pressElement(listView.get(0));
	}
	
	public void clicaExcluirContato() {
		dsl.click(btnExcluir);
		dsl.click(btnConfirmDelete);
	}
	 
	 
}
