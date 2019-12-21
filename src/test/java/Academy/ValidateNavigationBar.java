package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateNavigationBar extends Base{
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void navigationBarValidation() throws IOException {		
		LandingPage lp=new LandingPage(driver);
		Assert.assertTrue(lp.checkContact().isDisplayed());
		log.info("Assertion is successful for navigation bar");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}
	
	
}
