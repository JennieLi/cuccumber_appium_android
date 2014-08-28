/**
 * Copyright (C) 2013 Myriad Group AG. All Rights Reserved.
 */

package com.example.automation;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.exmaple.automation.ConfigsUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import static org.junit.Assert.assertTrue;

public class StepDefs {
	private AppiumDriver mAppiumDriver;
	private ConfigsUtils mConfigUtils = new ConfigsUtils();

	@Before
	public void setUp() throws IOException, InterruptedException {
		File appDir = new File(mConfigUtils.getProperty("APP_DIR"));
	    File app = new File(appDir, mConfigUtils.getProperty("APK_NAME"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, mConfigUtils.getProperty("DEVICE_NAME"));
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, mConfigUtils.getProperty("PLATFORM_NAME"));
	    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	    
	    mAppiumDriver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	@After
	public void tearDown(Scenario scenario) {
	}

	// Given I am on the "Main" screen
	@Given("^I am on the screen with keyword \"([^\"]*)\"$")
	public void I_am_on_the_screen(String screenKeyWords) throws Exception {
		assertTrue(mAppiumDriver.isAppInstalled("com.example.androidtestapp"));
		System.out.println("On Screen: '" + screenKeyWords + "'");
		List<WebElement> elements = mAppiumDriver.findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").text(\"" + screenKeyWords + "\")");
		System.out.println("Found elements: " + elements.size()); 
		assertTrue(elements.size() > 0);
	}

}
