package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage {
	
	public CheckoutPage(AndroidDriver<AndroidElement> driver)

	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> prodSelected;
	
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalAmt;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	public List<WebElement> productList;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	public WebElement productName;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	public WebElement TnC;
	
	@AndroidFindBy(xpath="//*[@text='Please read our terms of conditions']")
	public WebElement privacyLink;
	
	@AndroidFindBy(id="android:id/message")
	public WebElement privacyText;
	
	@AndroidFindBy(id="android:id/button1")
	public WebElement dismissPopUp;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	public WebElement proceed;
	
	
}
