package com.juaracoding.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.CheckOutPage;
import com.juaracoding.pageobject.pages.Login;
import com.juaracoding.pageobject.pages.Logout;
import com.juaracoding.pageobject.pages.RegisPage;
import com.juaracoding.pageobject.pages.Search;

public class TestShop {

	public static WebDriver driver;
	private Search search;
	private RegisPage regisPage;
	private Login login;
	private CheckOutPage checkOutPage;
	private Logout logout;

	@BeforeClass
	public void setup() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObject() {

		regisPage = new RegisPage();
		login = new Login();
		search = new Search(driver);
		checkOutPage = new CheckOutPage();
		logout = new Logout();
	}

	@Test(priority = 1)
	public void myAcc(){
		scroll(400);
		regisPage.myAcc();
	}
	@Test(priority = 2)
	public void Regis(){
		regisPage.regis("nissaa", "nisa234@demo.com", "nisa233.khassad");
		System.out.println("Registrasi Berhasil");
		scroll(600);
		delay(3);
		regisPage.alert();
		delay(3);
	}

	@Test(priority = 3)
	public void Login(){
		login.remember();
		delay(3);
		login.login("", "nisa233.khassad");
		System.out.println("Input Login Success");
		scroll(400);
		delay(3);
	}

	@Test(priority = 4)
	public void cariWishList1() {
		scroll(-400);
		delay(3);
		search.SearchItem("Pink Floral");
		scroll(600);
		search.wishList();
		delay(2);
		search.Logo();
		scroll(400);
	}

	@Test(priority = 5)
	public void cariWishList2() {
		search.SearchItem("Blue Denim");
		scroll(700);
		search.wishList();
		delay(2);
		search.Logo();
		scroll(400);
		search.MyWishList();
		scroll(400);
	}

	@Test(priority = 6)
	public void MyWishList() {
		search.Options();
		search.AlertDismiss();
		scroll(400);
		search.SelectColorSizeCart(1,3);

	}

	@Test(priority = 7)
	public void MyWishList2() {
		search.Logo();
		scroll(400);
		search.MyWishList();
		delay(3);
		search.Options2();
		scroll(500);
		search.SelectSizeCart(3);
		scroll(400);
	}

	@Test(priority = 8)
	public void ShowCart() {
		search.ViewCart();
		scroll(500);
		delay(3);
		scroll(600);
		search.checkOut();
		delay(3);
	}

	@Test(priority = 9)
	public void CheckOut() {
		scroll(400);
//		checkOutPage.FirstName("Khairunisa");
//		checkOutPage.LastName("asd");
//		checkOutPage.Company("Iconic");
		checkOutPage.country("Indonesia");
		checkOutPage.Address("Jalan Rawamaya");
		checkOutPage.City("Depok");
		checkOutPage.Province("Jawa Barat");
		checkOutPage.postCode("16421");
		checkOutPage.Phone("089652342617");
		delay(3);
		checkOutPage.accept();
		checkOutPage.placeOrder();
		delay(3);
		scroll(500);
		search.Logo();
	}

	@Test(priority = 10)
	public void LogOut() {
		search.Logo();
		scroll(400);
		regisPage.myAcc();
		logout.logout();
		scroll(600);
	}

	@AfterClass
	public void closeBrowser() {
		delay(10);
		driver.quit();
	}

	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static void scroll(int vertikal) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+vertikal+")");
}
	}
