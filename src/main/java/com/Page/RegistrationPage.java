package com.Page;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.TestBase;
import com.Utility.TestUtil;


public class RegistrationPage extends TestBase {
	// Page Factory / Object Repository
	
	@FindBy(id = "headerMyAccount")
	WebElement My_Account_Button;
	
	@FindBy(xpath = "//*[@id=\"SPSORegister\"]/a/span")
	WebElement Register_Button;
	
	@FindBy(linkText = "Select & Continue")
	WebElement Select_Continue_Button;
	
	@FindBy(id = "email")
	WebElement Email_Field;
	
	@FindBy(id = "password")
	WebElement Password_Field;
	
	@FindBy(id = "zipCode")
	WebElement Zipcode_Field;
	
	@FindBy(id = "phone")
	WebElement Phone_Field;
	
	@FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[1]")
	WebElement Captcha_Button;
	
	@FindBy(xpath = "//*[@id=\"single-signin__body\"]/div/div[2]/form/button/span")
	WebElement Create_Account_Button;
	
	@FindBy(xpath = "Welcome Back!")
	WebElement Welcom_Back;
	
	

	// Initialization Page Factory
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public  String  pageTitle() throws InterruptedException {
		loginSourc();
		String title = driver.getTitle();
		System.out.println("The Page Title is : "+title);
		return title;

	}
	public void loginSourc() throws InterruptedException {
		My_Account_Button.click();
		Register_Button.click();
		Thread.sleep(3000);
		
	}

	public void registerNewUser(String email, String password,
			String zipCode, String phone) throws InterruptedException {
		
		loginSourc();
		Email_Field.sendKeys(email);
		Password_Field.sendKeys(password);
		Zipcode_Field.sendKeys(zipCode);
		Phone_Field.sendKeys(phone);
		
		Create_Account_Button.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_Wait_Time, TimeUnit.MILLISECONDS);
		

	}

	public void validatCurrentUser() {

		My_Account_Button.click();
		boolean welcomPresent = Welcom_Back.isDisplayed();
		if (welcomPresent == true) {
			System.out.println("Suceesfully logged in");
		} else {
			System.out.println("Not logged in ");
		}
	}

}
