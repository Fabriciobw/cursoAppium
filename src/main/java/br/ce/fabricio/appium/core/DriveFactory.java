package br.ce.fabricio.appium.core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class DriveFactory {
	
	private static AndroidDriver<MobileElement> driverAppium;
	
	private static WebDriver driverSelenium;
	
	public static AndroidDriver<MobileElement> getAppiumDriver() {
		if(driverAppium == null) {
			try {
				createAppiumDriver();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return driverAppium;
	}
	
	public static WebDriver getSeleniumDriver() {
		if(driverSelenium == null) {
			createDriverSelenium();
		}
		return driverSelenium;
	}
	
	
	public static void createAppiumDriver() throws MalformedURLException  {

	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "xiaomi");
	    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:"+File.separator+"contatos.apk");
	    desiredCapabilities.setCapability("noReset","true");
	    driverAppium = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driverAppium.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	public static void createDriverSelenium() {
		System.setProperty("webdriver.chrome.driver", "C:"+File.separator+"chromedriver"+File.separator+ "chromedriver.exe"); 
		
		  driverSelenium = new ChromeDriver();
		 
		  driverSelenium.manage().window().maximize();
		
	}
	
	public static void killSeleniumDriver() {
		if(driverSelenium != null) {
			driverSelenium.quit();
			driverSelenium = null;
		}
		
	}
	
	public static void killAppiumDriver() {
		if(driverAppium != null) {
			driverAppium.quit();
			driverAppium = null;
		}
		
	}
	
}


