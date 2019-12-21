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

public class ValidateHeader extends Base{
	public static Logger log=LogManager.getLogger(Base.class.getName());
	LandingPage lp;
			
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void headerValidation() throws IOException {
		new LandingPage(driver);
		System.out.println(lp.checkHeader().getText());
		Assert.assertEquals(lp.checkHeader().getText(), "FEATURED COURSES123");	
		log.info("Assertion is successful");
		Assert.assertTrue(lp.checkContact().isDisplayed());
	}
	
	@Test
	public void subTitleValidation() throws IOException {
		new LandingPage(driver);
		Assert.assertEquals(lp.getSubText().getText(), "An Academy to learn Everything about Testing");	
		log.info("Assertion is successful");
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}

}
