package com.juaracoding.pageobject.main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.LoginPage;
import com.juaracoding.pageobject.pages.RegistPage;

public class MainApp {

	public static void main(String[] args) throws InterruptedException {

		DriverSingleton.getInstance("Chrome");
		WebDriver driver = DriverSingleton.getDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String url = "https://shop.demoqa.com";
		driver.get(url);
		
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//a[normalize-space()='My Account']")).click();
		Thread.sleep(500);
		
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(500);
		
		RegistPage registPage = new RegistPage();
		registPage.regist("nisaasd","nisaaja@gmail.com","Nisaaaja1234");
		
		driver.findElement(By.xpath("//a[@class='showlogin']")).click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//input[@id='rememberme']")).click();
		Thread.sleep(500);
		
		LoginPage loginPage = new LoginPage();
		loginPage.login("","nisa1234");//login adalah method yang ada pada loginpage
		js.executeScript("window, scrollBy(0,400)");
		
		delay(3);
		driver.quit();
	}
	static void delay(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
