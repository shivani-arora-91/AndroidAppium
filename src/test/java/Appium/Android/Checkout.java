package Appium.Android;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

import junit.framework.Assert;
import pageObject.CheckoutPage;
import pageObject.FormPage;
import pageObject.Products;

public class Checkout extends Base{
	
	public static AndroidDriver<AndroidElement> driver;
	public static FormPage form;
	public static Products prod;
	public static CheckoutPage checkout;
	 
	@Test
	public void validateTotal() throws InterruptedException, IOException {
		
		 driver= getDriver("GeneralStoreApp");

	     driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	     
	     form = new FormPage(driver);
	     prod = new Products(driver);
	     checkout = new CheckoutPage(driver);

	     form.nameField.sendKeys("Hello");

	     driver.hideKeyboard();

	     form.gender.click();

	     form.country.click();

	     Utilities u = new Utilities(driver);
	     
	     u.scrollToText("Argentina");

	     form.countrySelection.click();

	     form.shopButton.click();

	     prod.addToCart.get(0).click();

	     prod.addToCart.get(0).click();

	    prod.cart.click();

	   int count=checkout.prodSelected.size();

	   double sum=0;

	   for(int i=0;i<count;i++)

	   {

		   String amount1= checkout.prodSelected.get(i).getText();

		   double amount=getAmount(amount1);

		   sum=sum+amount;//280.97+116.97

	   }

	   System.out.println(sum+"sum of products");

	   String total=checkout.totalAmt.getText();

	   total= total.substring(1);

	   double totalValue=Double.parseDouble(total);

	   System.out.println(totalValue+"Total value of products");

	   Assert.assertEquals(sum, totalValue); 

	}

	@Test(dependsOnMethods={"validateTotal"})
	public void validateTnC()
	{
		//Mobile Gestures 

		WebElement checkbox= checkout.TnC;

		TouchAction t=new TouchAction(driver);

		t.tap(tapOptions().withElement(element(checkbox))).perform();

		WebElement tc=checkout.privacyLink;

		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();

		System.out.println(checkout.privacyText.getText());
		checkout.dismissPopUp.click();

		checkout.proceed.click();
		
	}
	public static double getAmount(String value)

	{

	value= value.substring(1);

	double amount2value=Double.parseDouble(value);

	return amount2value;

	}

}
