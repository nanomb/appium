package com.capgemini.test.appium.setup;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appium {

	private String accessKey = "MyKey";

	protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    public void init() throws Exception {
       	capabilities.setCapability("testName", "Quick Start iOS Native Demo");
    	capabilities.setCapability("accessKey", accessKey);
    	capabilities.setCapability("deviceQuery", "@os='ios' and @category='PHONE'");
    	capabilities.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
    	capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new IOSDriver<IOSElement>(new URL("https://cloud.seetest.io/wd/hub"), capabilities);
    }

    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
