package com.eComm.PageFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TodoListPage {

	public static WebDriver driver;

	public void launchURL() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://todomvc.com/examples/vue");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.quit();
	}
}
