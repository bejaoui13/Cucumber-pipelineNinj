package com.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
import io.cucumber.datatable.internal.difflib.myers.MyersDiff;

public class RegistrationPage {
	
	public WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	 }
 
	private By linkmyaccount = By.xpath("//span[normalize-space()='My Account']");
	private By linkregister = By.xpath("//li//a[normalize-space()='Register']");

	private By name = By.name("firstname");
	private By namel = By.name("lastname");
	private By e_mail = By.name("email");
	private By teleph = By.name("telephone");
	private By passw = By.name("password");
	private By confpwd = By.name("confirm");
	private By agreepol = By.name("agree");
	private By btnregister = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
	private By msgregister = By.xpath("//*[@id=\"content\"]/h1");
	private By errorregister = By.xpath("//*[@id=\"account-register\"]/div[1]");
	
	public void goPageRegiter()
	{
		driver.findElement(linkmyaccount).click();
		driver.findElement(linkregister).click();

	}
	public void registerUser(String fname , String lname, String emailaddresse , String telep, String pwd, String confpass)
	{
		driver.findElement(name ).sendKeys(fname);
		driver.findElement(namel).sendKeys(lname);
		driver.findElement(e_mail).sendKeys(emailaddresse);
		driver.findElement(teleph).sendKeys(telep);
		driver.findElement(passw).sendKeys(pwd);
		driver.findElement(confpwd).sendKeys(confpass);
	}
	
	  
	public void clickBtnPolicy()
	{
		driver.findElement(agreepol).click();

	}
	public void clickBtnRegister()
	{
		driver.findElement(btnregister).click();

	}
	
	
	public String successRegister() {
		
	String alerteregister = driver.findElement(msgregister).getText();
	return alerteregister;
  	}
	
	public String errorRegister()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		
		System.out.println("....................." +  driver.findElement(errorregister).getText());
		return driver.findElement(errorregister).getText();
		
	}
}
