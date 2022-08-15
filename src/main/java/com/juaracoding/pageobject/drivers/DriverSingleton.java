package com.juaracoding.pageobject.drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.juaracoding.pageobject.drivers.strategies.DriverStrategy;
import com.juaracoding.pageobject.drivers.strategies.DriverStrategyImplementer;

public class DriverSingleton {

	private static DriverSingleton instance = null;
	private static WebDriver driver;
	
	private DriverSingleton(String driver) {
		instantiate(driver);
	}
	public WebDriver instantiate(String strategy) {
		DriverStrategy driverstrategy = DriverStrategyImplementer.chooseStrategy(strategy);
		driver = driverstrategy.setStrategy();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	public static DriverSingleton getInstance(String driver) {
		if(instance == null) {
			instance = new DriverSingleton(driver);
		}
		return instance;
		
	}
	public static WebDriver getDriver() {
		return driver;
	}
}
