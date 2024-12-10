package com.basepage;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	
	public static WebDriver driver;
	
	public static WebDriver setDriver()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");

		System.getProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipseworkspace\\ShopBDDweb\\driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		return driver;
	}
	
	
	public void closeDriver()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.quit();

	}

}
