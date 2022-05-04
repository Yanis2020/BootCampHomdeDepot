package com.Test;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


import java.io.IOException;

import org.testng.Assert;


import com.Base.TestBase;
import com.Page.HomePage;
import com.Page.LoginPage;
import com.Utility.TestUtil;

public class LoginPageTest extends TestBase {
	
LoginPage loginPage;
HomePage homePage;
TestUtil testUtil;


	public LoginPageTest() throws IOException {
		super();
		
	}


	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		testUtil = new TestUtil();
	}
	@Test(enabled = false)
	public void pageTitleTest() {
		String title = loginPage.pageTitle();
		System.out.println("The Title of this page is : "+title);
		Assert.assertEquals(title, "The Home Depot", "Opssss!! did not found........");
		
	}p[]\
	
	-\-""] bvb
V
v
vV  v
ve\
	@Test
	public void loginTest() throws IOException, InterruptedException {
		loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		loginPage.pageTitle();
	}
	@Test(enabled = false)
	public void currentUserNameTest() throws IOException, InterruptedException {
		loginTest();
		Thread.sleep(3000);
		loginPage.validateCurrentUserName();
		testUtil.takeScreenshoot();		
		
	}


	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
