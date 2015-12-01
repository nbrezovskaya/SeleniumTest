package com.nina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest extends AbstractBrowserTest {
    @Override
    protected WebDriver getDriver() {
        String chromeDriverPath = getClass().getResource("../../../classes/chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        return new ChromeDriver();
    }
}
