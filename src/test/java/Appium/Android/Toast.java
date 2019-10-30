package Appium.Android;

import java.io.IOException;

import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
import pageObject.FormPage;

public class Toast extends Base{
	
	@Test
	public void validateToast() throws IOException
	{
		
	
		AndroidDriver<AndroidElement> driver = getDriver("GeneralStoreApp");

	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     FormPage form = new FormPage(driver);

	     form.gender.click();

	     form.country.click();

	     Utilities u = new Utilities(driver);
	     
	     u.scrollToText("Argentina");


	     form.countrySelection.click();

	     form.shopButton.click();

	    String toastMessage = form.errorMessage.getAttribute("name");

	    System.out.println("Text for toast message is: " + toastMessage);
	    
	    Assert.assertEquals("Please enter your name", toastMessage);
	
	}



}


