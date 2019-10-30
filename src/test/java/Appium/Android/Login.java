package Appium.Android;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObject.FormPage;

public class Login extends Base{
	
	@Test
	public void validateLogin() throws IOException
	{
	
		AndroidDriver<AndroidElement> driver = getDriver("GeneralStoreApp");

	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	     FormPage form = new FormPage(driver);

	     form.nameField.sendKeys("Hello");

	     driver.hideKeyboard();

	     form.gender.click();

	     form.country.click();

	     Utilities u = new Utilities(driver);
	     
	     u.scrollToText("Argentina");

 
	     form.countrySelection.click();

	     form.shopButton.click();
    

	 }


}
