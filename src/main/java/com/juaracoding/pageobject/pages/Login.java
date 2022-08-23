package com.juaracoding.pageobject.pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class Login {
	
	private WebDriver driver;

	public Login() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='username']")
	private WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement regPassword;

	@FindBy(xpath = "//button[@name='login']")
	private WebElement btnLogin;

	@FindBy(xpath = "//*[@id=\"rememberme\"]")
	private WebElement rememberMe;

	public void login(String regusername, String regpassword) {
		this.userName.sendKeys(regusername);
		this.regPassword.sendKeys(regpassword);
		btnLogin.click();
	}

	public void remember() {
		rememberMe.click();
	}

//	private WebDriver driver;
//	
//	public Login() {
//		this.driver = DriverSingleton.getDriver();
//		PageFactory.initElements(driver, this);
//	}
//	@FindBy(xpath = "//input[@id='username']")
//	private WebElement username;
//	
////	@FindBy(xpath = "//*[@id='txtUsername']")
////	private WebElement username;
//	
//	@FindBy(xpath = "//input[@id='password']")
//	private WebElement password;
//	
////	@FindBy(xpath = "//*[@id='txtPassword']")
////	private WebElement password;
//
//	@FindBy(xpath = "//button[@name='login']")
//	private WebElement btnLogin;
//	
////	@FindBy(xpath = "//*[@id='btnLogin']")
////	private WebElement btnLogin;
//	
//	@FindBy(xpath = "//span[@id='spanMessage']")
//	private WebElement msgError;
////	String txtInvalidLogin = driver.findElement(By.xpath("//ul[@role='alert']")).getText();
//	
//	@FindBy(xpath = "//h1[normalize-space()='Dashboard']")
//	private WebElement txtDashboard;
//	
//	//scenario
//	public void login(String username, String password) {//agar adminnya bisa ganti ganti maka dibuat parameter
//		this.username.sendKeys(username);//step
//		this.password.sendKeys(password);
//		btnLogin.click();
//	}
//	//Actual test object
//	public String msgInvalid() {
//		return msgError.getText();
//	}
//	public String getTxtDashboard() {
//		return txtDashboard.getText();
//	}
}
