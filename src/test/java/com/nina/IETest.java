package com.nina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public  class IETest extends AbstractBrowserTest {
    @Override
    protected WebDriver getDriver() {
        String ieDriverPath = getClass().getResource("../../../classes/IEDriverServer.exe").getPath();
        System.setProperty("webdriver.ie.driver", ieDriverPath);
        return new InternetExplorerDriver();
    }
}

