package com.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.Utility.TestUtil;

public class TestBase {
	TestUtil util;
	public static WebDriver driver;
	public static Properties prop;
	
	public String propFile ="C:\\Users\\Adele\\eclipse-workspace\\Home_Depot\\src\\main\\java\\com\\Configuration\\config.properties";
	
	//Constructor
	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(propFile);
			try {
				prop.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}		
	}
	//Initializations
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Adele\\eclipse-workspace\\Home_Depot\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Adele\\eclipse-workspace\\Home_Depot\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			driver = new SafariDriver();
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
//		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_Wait_Time, TimeUnit.MILLISECONDS);
//		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_Wait_Time, TimeUnit.MILLISECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}
	
	
	

}
