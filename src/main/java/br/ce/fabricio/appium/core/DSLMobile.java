package br.ce.fabricio.appium.core;

import static br.ce.fabricio.appium.core.DriveFactory.getAppiumDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DSLMobile {
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	public DSLMobile()  {
	
		driver = getAppiumDriver();
		wait = new WebDriverWait(driver, 10);
	}

	 public void click(WebElement element){
		 wait.until(ExpectedConditions.visibilityOf(element)).click();
	 }
 
	 public String getText(WebElement element) {
		 return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	 }
	 
	 public void sendText(WebElement element, String value) {
		 wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
	 }

	 public String getTextFormatNumber(WebElement descricaoAnuncio) {
		return  wait.until(ExpectedConditions.visibilityOf(descricaoAnuncio)).getText().replaceAll("\\D+","");
	}

	public boolean elementIsPresent(List<WebElement> listView, String nome, String sobrenome) {
	
		for(WebElement element: listView) {
			if(element.getText().equals(nome +" "+ sobrenome)) {
				return true;
			}
		}
			return false;
	}

	public void clearInputs(List<WebElement> inputs) {
		inputs.forEach(element -> element.sendKeys(""));
	}

	public void pressElement(WebElement element) {
		AndroidTouchAction touch = new AndroidTouchAction((PerformsTouchActions) driver);
		touch.longPress(LongPressOptions.longPressOptions()
                .withElement (ElementOption.element (element)))
              .perform();
	


		
	}

	}


