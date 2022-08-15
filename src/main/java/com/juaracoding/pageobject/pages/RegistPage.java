package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class RegistPage {

private WebDriver driver;
	
	public RegistPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@id=\"reg_username\"]")//*[@id="reg_username"]
	private WebElement uname;
	
	@FindBy(xpath = "//*[@id=\"reg_email\"]")
	private WebElement email;
	
	@FindBy(xpath = "//*[@id=\"reg_password\"]")
	private WebElement password;
	
	@FindBy(xpath = "//button[@name='register']")
	private WebElement btnLogin;
	
	//scenario
	public void regist(String uname, String email, String password) {//agar adminnya bisa ganti ganti maka dibuat parameter
		this.uname.sendKeys(uname);//step
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		btnLogin.click();
	}

}

