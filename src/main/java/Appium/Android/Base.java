package Appium.Android;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	
	public AndroidDriver<AndroidElement> getDriver(String appName) throws IOException
	
	{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Parameters.properties");
		Properties prop = new Properties();
		prop.load(fis);
	
		File f = new File("src");
		File fs = new File(f,(String) prop.get(appName));
	
		DesiredCapabilities cap = new DesiredCapabilities();
	
		String device = (String) prop.get("device");
	
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	
 }

}