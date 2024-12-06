package com.pageobject;

import java.time.Duration;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCardPage {

	public WebDriver driver;
	boolean displayed = false;
	boolean productdelet = true;

	public AddCardPage(WebDriver driver) {
		this.driver = driver;
	}

	private By logo = By.id("logo");
	private By search = By.name("search");
	private By btnsearch = By.cssSelector("button[class='btn btn-default btn-lg']");
	private By noproductmsg = By.xpath("//p[contains(text(),'There is no product that matches the search criter')]");
	private By existproduct = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a");
	private By updateQte = By.name("quantity");
	private By btnaddcard = By.id("button-cart");
	private By priceproduct = By.xpath("//ul[@class=\"list-unstyled\"]//li//h2");
	private By linkcardshop = By.cssSelector("a[title='Shopping Cart']");
	private By qtepagecard = By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input");
	private By pricepagecard = By.xpath("//*[@id=\"content\"]/div[2]/div/table/tbody/tr[4]/td[2]");
	private By btnupdateqteCard = By.xpath("//button[@data-original-title=\"Update\"]");
	private By alertupdateqte = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	private By btndeleteqte = By.xpath("//button[@class=\"btn btn-danger\"]");

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	public void goHomepage() {
		driver.findElement(logo).click();
	}

	public void searchProduct(String productsearch) {
		driver.findElement(search).sendKeys(productsearch);
	}

	public void clichBtnsearch() {
		driver.findElement(btnsearch).click();
	}

	public String invalideProduct() {
		return driver.findElement(noproductmsg).getText();
	}

	public String existeproduct() {
		return driver.findElement(existproduct).getText();
	}

	public void goPageProduct() {

		driver.findElement(existproduct).click();
	}

	public void updateQuantity(String qnte) {
		driver.findElement(updateQte).clear();
		driver.findElement(updateQte).sendKeys(qnte);
	}

	public String priceOneProduct() {
		String pricepro = driver.findElement(priceproduct).getText();
		String price = pricepro.replaceAll("[£$]", "");
	//	System.out.println("---------------------------" + price);
		return price;
	}

	public void clickAddCard() {
		driver.findElement(btnaddcard).click();
	}

	public void goShopCard() {
		driver.findElement(linkcardshop).click();
	}

	public String checkPrice() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

		String totalpricecard = driver.findElement(pricepagecard).getText();
		String totalprice = totalpricecard.replaceAll("[£$]", "");
		//System.out.println("------------**********" + totalprice);
		return totalprice;

	}

	public String checkQte() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

		String qtecard = driver.findElement(qtepagecard).getAttribute("value");
		//System.out.println("------------**********" + qtecard);
		return qtecard;

	}

	public void updateQTEpageCard(String newQte) {
		driver.findElement(qtepagecard).clear();
		driver.findElement(qtepagecard).sendKeys(newQte);
		driver.findElement(btnupdateqteCard).click();

	}

	public boolean succesAlertUpdate() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		WebElement msgalerte = wait.until(ExpectedConditions.visibilityOfElementLocated(alertupdateqte));

		//System.out.println("***************" + driver.findElement(alertupdateqte).getText());

		if (msgalerte.isDisplayed()) {
			displayed = true;
		} else {
			displayed = false;
		}
		return displayed;

	}

	public void deletQteCard() {
		driver.findElement(btndeleteqte).click();
	}

	public boolean checkDeletElement(String nomproduct) {

		WebElement element = driver.findElement(By.xpath("//div[@class='table-responsive']//table"));
		List<WebElement> rowCollection = element
				.findElements(By.xpath("//div[@class='table-responsive']//table//tbody//tr"));

		System.out.println("Number of rows in this table: " + rowCollection.size());
		int i_RowNum = 1;
		for (WebElement rowElement : rowCollection) {
			List<WebElement> colCollection = rowElement.findElements(By.xpath("td"));

			int i_ColNum = 1;
			for (WebElement colElement : colCollection) {
				if (nomproduct.equalsIgnoreCase(colElement.getText())) {
					productdelet = false;
					System.out.println("Row " + i_RowNum + " Column " + i_ColNum + "  " + colElement.getText());

				}

				i_ColNum = i_ColNum + 1;
			}
			i_RowNum = i_RowNum + 1;
		}
		return productdelet;
	}
}
