package com.juaracoding.pageobject.pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id='username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@name='login']")
	private WebElement btnLogin;
	
//	String txtInvalidLogin = driver.findElement(By.xpath("//ul[@role='alert']")).getText();
	
	//scenario
	public void login(String username, String password) {//agar adminnya bisa ganti ganti maka dibuat parameter
		this.username.sendKeys(username);//step
		this.password.sendKeys(password);
		btnLogin.click();
	}

}
