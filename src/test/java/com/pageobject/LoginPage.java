package com.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
 
public class LoginPage {

	
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	 }

	
	private By fieldemail = By.name("email");
	private	By fieldpassword = By.name("password");
	private	By btnlogin = By.xpath("//input[@value=\"Login\"]");
	private By msgerreur = By.xpath("//*[@id='account-login']/div[1]");
	
 	


	public void entercredential(String emailinput, String password)
	{
		driver.findElement(fieldemail).sendKeys(emailinput);
		driver.findElement(fieldpassword).sendKeys(password);

 	}
	
	public void clickbuttonlogin()
	{
		driver.findElement(btnlogin).click();
	  //wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 		//wait.until(ExpectedConditions.visibilityOfElementLocated(btnlogin)).click();

	}
	 
	public String validatelogin() throws InterruptedException
	{	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
 	 	 String msgerror =driver.findElement(msgerreur).getText();
	 	 //System.out.println("*********************" + msgerror);

          return msgerror;
	}
	
	public String validatepagehome()
	{
 	 	 String titleh2 =driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]")).getText();

         return titleh2;
		
	}
}
