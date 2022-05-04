package com.Page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.TestBase;
import com.Utility.TestUtil;

public class LoginPage extends TestBase {
	
	//Page Factory / Object Repository
	@FindBy(id = "headerMyAccount")
	WebElement My_Account_Button;
	
	@FindBy (xpath = "//*[@id=\"SPSOSignIn\"]/a/span")
	WebElement Sign_In_button;
	
	@FindBy(id = "username")
	WebElement Email_address;
	
	@FindBy(xpath = "//*[@id=\"single-signin__body\"]/div/div[2]/form/button/span")
	WebElement Continue_Button;
	
	@FindBy(id = "password-input-field")
	WebElement Password;
	
	@FindBy(xpath = "Sign In")
	WebElement login_button;
	
	@FindBy(xpath = "Welcome Back!")
	WebElement Welcom_Back;
	
	//Initialized Page-Factory	
	public LoginPage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	public String pageTitle() {
		String title = driver.getTitle();
		System.out.println("The Page title is : " + title);
		return title;
	}
	
	public HomePage validateLogin(String userName, String passWord) throws IOException, InterruptedException {
		
		My_Account_Button.click();
		Thread.sleep(3000);
		Sign_In_button.click();
		Thread.sleep(3000);
		Email_address.sendKeys(userName);
		Thread.sleep(3000);
		Continue_Button.click();
		Thread.sleep(3000);
		Password.sendKeys(passWord);
		Thread.sleep(3000);
		login_button.click();
		return new HomePage();	
	}
	
	public  void validateCurrentUserName() {
		My_Account_Button.click();
		boolean welcomPresent = Welcom_Back.isDisplayed();
		if (welcomPresent == true) {
			System.out.println("Suceesfully logged in");
		} else {
			System.out.println("Not logged in ");
		}
	}
	
	
	
	}
	


