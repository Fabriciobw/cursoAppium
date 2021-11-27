package br.ce.fabricio.appium.core;

import static br.ce.fabricio.appium.core.DriveFactory.getSeleniumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSLWeb {
		
		WebDriver driver;
		WebDriverWait wait;
		
	public DSLWeb()  {
			driver = getSeleniumDriver();
			wait = new WebDriverWait(driver, 10);
	}
	
	 public void rollDown()  {
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
		 jse.executeScript("window.scrollBy(0,200)");
	 }
	 
	 public void click(WebElement element){
		 wait.until(ExpectedConditions.visibilityOf(element)).click();
	 }
	 
	 public String getText(WebElement element) {
		 return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	 }

	public void acessar(String pagina)  {
		driver.get(pagina);
		
	}

	public String getTextFormatNumber(WebElement descricaoAnuncio) {
		return  wait.until(ExpectedConditions.visibilityOf(descricaoAnuncio)).getText().replaceAll("\\D+","");
	}
}
