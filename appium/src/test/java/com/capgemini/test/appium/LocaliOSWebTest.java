package com.capgemini.test.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileBrowserType;

public class LocaliOSWebTest {

	private String accessKey = "eyJ4cC51Ijo4Nzc1MzAsInhwLnAiOjg3NzUyOSwieHAubSI6Ik1UVXpNamN3TXpFNU9EVTFNZyIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE4NDgwNjM5NjMsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.i4B3zcZA6mJhIyXaMvCVGz5I8i3SBAwWCs4vAFSZ34c";

	protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
    	capabilities.setCapability("testName", "Quick Start iOS Browser Demo");
    	capabilities.setCapability("accessKey", accessKey);
    	capabilities.setCapability("deviceQuery", "@os='ios' and @version='11.2.2' and @category='PHONE'");
    	capabilities.setBrowserName(MobileBrowserType.SAFARI);
        driver = new IOSDriver<IOSElement>(new URL("https://cloud.seetest.io/wd/hub"), capabilities);
    }

    @Test
    public void quickStartiOSNativeDemo() {
    	driver.rotate(ScreenOrientation.PORTRAIT);
        driver.get("https://www.google.com");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("lst-ib")));
        WebElement searchBar = driver.findElement(By.id("lst-ib"));
        searchBar.click();
        searchBar.sendKeys("Experitest");
        searchBar.sendKeys(Keys.ENTER);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}