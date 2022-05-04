package com.Page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Base.TestBase;
import com.Utility.TestUtil;

public class HomePage extends TestBase {

	// PAGE FACTORY OBJECT REPOSITORY

	@FindBy(xpath = "//*[@id=\"footer\"]/div[2]/nav[3]/h3")
	WebElement About_Us;

	
	
	@FindBy(partialLinkText = "Careers")
	WebElement Careers_Link;

	

	// PAGE FACTORY INITIALIZATION
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void pageTitle() {
		String title = driver.getTitle();
		System.out.println("The Page title is : " + title);
	}

	public void ifAbout_Us_Present() {
		System.out.println("Current page Title is : " + driver.getTitle());
		boolean aboutUSPresnet = About_Us.isDisplayed();
		if (aboutUSPresnet == true) {
			System.out.println("The element About Us is present in the website");
		} else {
			System.out.println("The element About Us is not present in the website ");
		}
		
		driver.navigate().back();
	}

	public void clicOnCarrers() {
		Careers_Link.click();
		System.out.println("Current page Title is : " + driver.getTitle());
		driver.navigate().back();
	}

	

	}


