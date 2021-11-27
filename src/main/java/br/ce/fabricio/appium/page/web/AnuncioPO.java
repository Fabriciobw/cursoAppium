package br.ce.fabricio.appium.page.web;
import static br.ce.fabricio.appium.core.DriveFactory.getSeleniumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import br.ce.fabricio.appium.core.DSLWeb;

public class AnuncioPO {
	
	DSLWeb dsl = new DSLWeb();
	final String URL = "https://ba.olx.com.br/grande-salvador/computadores-e-acessorios/gabinete-fonte-300w-drive-cd-dvd-956997347";

	public AnuncioPO(){
	    PageFactory.initElements(getSeleniumDriver(), this);
	}
	
	@FindBy(xpath = "//*[@id='content']//span/a[contains(text(), 'ver número')]")
	private WebElement linkVerNumero;
	
	@FindBy(xpath ="//*[@id='miniprofile']//div[1]/div[1]/span[1][contains(@color, 'dark')]")
	private WebElement nomeAnunciante;
	
	@FindBy(xpath = "//*[@id='content']//p/span")
	private WebElement descricaoAnuncio;
	
	 public void descerPagina()  {
		 dsl.rollDown();
	 }
	 
	 public void clicaExpandirDescricao() {
		 linkVerNumero.click();
	 }
	 
	 public String getNumeroDescricao() {
		 return dsl.getTextFormatNumber(descricaoAnuncio);
	 }
	 
	 public String getNomeDoAnunciante() {
		return dsl.getText(nomeAnunciante);
	 }
	 
	 public void acessarPaginaAnuncio()  {
		 dsl.acessar(URL);
	 }

}
