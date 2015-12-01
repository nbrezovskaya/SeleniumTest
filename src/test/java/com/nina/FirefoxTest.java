package com.nina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest extends AbstractBrowserTest {
    @Override
    protected WebDriver getDriver() {
        return new FirefoxDriver();
    }
}
