package com.severstal.infocom.TestingRobot;


import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private AppiumDriver<WebElement> driver;
    /**
     * Rigorous Test :-)
     */
    @Test
    @Disabled
    public void testAppium() throws Exception{
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Windows");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("deviceName", "WindowsPC");
        caps.setCapability("app", "C:\\Program Files\\yWorks\\yEd\\yEd.exe");
        driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        driver.findElementsByName("Свернуть").get(0).click();

    }

    @Test
    public void testWinApi() {

    }
}
