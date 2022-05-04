package com.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Base.TestBase;
import com.Page.HomePage;
import com.Page.LoginPage;
import com.Page.RegistrationPage;
import com.Utility.TestUtil;

public class RegistrationPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtill;
	RegistrationPage registrationPage;
	public static String sheetNames = "Sheet1";

	public RegistrationPageTest() throws IOException {
		super();
	}



	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		testUtill = new TestUtil();
		registrationPage = new RegistrationPage();

	}

	@Test(enabled = false)
	public void pageTitleTest() throws InterruptedException {
		String title = registrationPage.pageTitle();
		AssertJUnit.assertEquals(title, "Register Now", "Doesnt Match......");
		System.out.println("Page title is : " + title);

	}

	@DataProvider
	public Object[][] getDataTest() {
		Object[][] data = TestUtil.getTestData(sheetNames);
		return data;
	}

	@Test(dataProvider = "getDataTest",enabled = false)
  	public void registerNewUserTest(String email, String password,
			String zipCode, String phone) throws InterruptedException, IOException  {
		registrationPage.registerNewUser(email, password, zipCode, phone);
		Thread.sleep(5000);
		testUtill.takeScreenshoot();
		Thread.sleep(5000);
		registrationPage.validatCurrentUser();

	}
	@Test
	public void registerNew2 (String email, String password,
			String zipCode, String phone) throws InterruptedException, IOException {
		registrationPage.registerNewUser("email1@gmail.com", "abc1", "10001", "512 512 5123");
		Thread.sleep(5000);
		testUtill.takeScreenshoot();
		Thread.sleep(5000);
		registrationPage.validatCurrentUser();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
