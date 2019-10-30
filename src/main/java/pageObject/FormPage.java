package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	
	public FormPage(AndroidDriver<AndroidElement> driver)

	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement gender;
	
	@AndroidFindBy(id="android:id/text1")
	public WebElement country;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement shopButton;
	
	@AndroidFindBy(xpath="//*[@text='Argentina']")
	public WebElement countrySelection;
	
	@AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\")")
	public WebElement dropDownList;
	
	@AndroidFindBy(xpath="//android.widget.Toast[1]")
	public WebElement errorMessage;
}
