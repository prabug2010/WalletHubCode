package com.wallethub.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;

public class TestBaseClass {

	public WebDriver driver;
	public  Map<String, String> testConfig = new HashMap<String, String>();
	
	public TestBaseClass() {
		browserInitialization();
	}
		
	public void browserInitialization() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("./src/test/resources/ConfigFile/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		for (String key : prop.stringPropertyNames()) {
			String val = prop.getProperty(key);
			testConfig.put(key, val);
		}
		String browserType = testConfig.get("browser") != null ? testConfig.get("browser").toUpperCase() : "CHROME";
		switch (browserType) {
		case "FIREFOX":
			FirefoxProfile newProfile = new FirefoxProfile();
			newProfile.setPreference("dom.webnotifications.enabled", false);
			DesiredCapabilities desCap = DesiredCapabilities.firefox();
			desCap.setCapability(FirefoxDriver.PROFILE, newProfile);
			FirefoxOptions opt = new FirefoxOptions();
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
		      //disable notification parameter
		     options.addArguments("--disable-notifications");
		      // configure options parameter to Chrome driver
		//      Map<String, Object> pref = new HashMap<String, Object>();
		  //    pref.put("profile.default_content_setting_values.notifications", 2);
		  	//	options.setExperimentalOption("pref", pref);
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			break;

		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Chrome as browser of choice..");
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
	}
}