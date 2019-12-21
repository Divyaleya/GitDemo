package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	
	private By login=By.cssSelector("a[href*='sign_in']");
	private By header=By.cssSelector("[id='content'] h2");
	private By contact=By.xpath("//a[text()='Contact']");
	private By subText=By.cssSelector(".col-sm-6.col-md-8.hidden-xs.video-banner>h3");

	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement clickLogin() {
		return driver.findElement(login);
	}
	
	public WebElement checkHeader() {
		return driver.findElement(header);
	}
	
	public WebElement checkContact() {
		return driver.findElement(contact);
	}
	
	public WebElement getSubText() {
		return driver.findElement(subText);
	}
}
