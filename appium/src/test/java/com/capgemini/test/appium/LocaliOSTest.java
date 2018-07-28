package com.capgemini.test.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class LocaliOSTest {

	private String accessKey = "MyKey";

	protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
    	capabilities.setCapability("testName", "Quick Start iOS Native Demo");
    	capabilities.setCapability("accessKey", accessKey);
    	capabilities.setCapability("deviceQuery", "@os='ios' and @category='PHONE'");
    	capabilities.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
    	capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new IOSDriver<IOSElement>(new URL("https://cloud.seetest.io/wd/hub"), capabilities);
        // driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @Test
    public void quickStartiOSNativeDemo() {
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
        driver.findElement(By.xpath("//*[@id='makePaymentButton']")).click();
        driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("0541234567");
        driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("Jon Snow");
        driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("50");
        driver.findElement(By.xpath("//*[@id='countryButton']")).click();
        driver.findElement(By.xpath("//*[@id='Switzerland']")).click();
        driver.findElement(By.xpath("//*[@id='sendPaymentButton']")).click();
        driver.findElement(By.xpath("//*[@id='Yes']")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}