package Appium.Android;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import pageObject.CheckoutPage;
import pageObject.FormPage;
import pageObject.Products;
public class AddToCart extends Base {
	
	
	@Test
	void validateCart() throws IOException {
	
		
		AndroidDriver<AndroidElement> driver=getDriver("GeneralStoreApp");

	     driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	     
	     FormPage form = new FormPage(driver);
	     Products prod = new Products(driver);
	     CheckoutPage checkout = new CheckoutPage(driver);
	     
	     form.nameField.sendKeys("Hello");

	     driver.hideKeyboard();

	     form.gender.click();

	     form.country.click();

	     Utilities u = new Utilities(driver);
	     
	     u.scrollToText("Argentina");

	     form.countrySelection.click();

	     form.shopButton.click();

	     driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));

	     int count=    checkout.productList.size();

	     for(int i=0;i<count;i++)

	     {
	    	 String text= prod.prodList.get(i).getText();
	     	 if(text.equalsIgnoreCase("Jordan 6 Rings"))

	     	 {	
	     		 prod.addProduct.get(i).click();
	     		 break;

	     	 }

	    }

	   prod.cart.click();  

	   String lastpageText=checkout.productName.getText();

	   AssertJUnit.assertEquals("Jordan 6 Rings", lastpageText);
	
	 
	}

}
