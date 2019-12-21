package Academy;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base{
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();	
		log.info("Driver is initialized");
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String password,String text) throws IOException {	
		driver.get(prop.getProperty("url"));
		log.info("Navigates to Home Page");
		LandingPage lp=new LandingPage(driver);
		lp.clickLogin().click();
		
		LoginPage lop=new LoginPage(driver);
		lop.getEmail().sendKeys(username);
		lop.getPassword().sendKeys(password);
		log.info(text);
		lop.getLogin().click();	
		log.info("Successfully Logged in");
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[2][3];
		data[0][0]="Restricteduser@qa.com";
		data[0][1]="12345";
		data[0][2]="Restricted";
		
		data[1][0]="NonRestricted@qa.com";
		data[1][1]="45678";
		data[1][2]="NonRestricted"; 
		
		return data;		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	} 

}
