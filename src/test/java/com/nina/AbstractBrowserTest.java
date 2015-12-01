package com.nina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public abstract class AbstractBrowserTest {

    protected abstract WebDriver getDriver();

    @Test
    public void testBrowser() {
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.get("http://onliner.by/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String title= driver.getTitle();
        assertEquals(title, "Onliner.by");

        WebElement login = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver d) {
                        return d.findElement(By.cssSelector(".auth-bar__item.auth-bar__item--text"));
                    }
                });
        login.click();

        WebElement emailField = driver.findElement(By.xpath(".//*[@id='auth-container__forms']/div/div[2]/form/div[1]/div[1]/input"));
        emailField.sendKeys("nbrezovskaya@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath(".//*[@id='auth-container__forms']/div/div[2]/form/div[1]/div[2]/input"));
        passwordField.sendKeys("123456");

        WebElement authorizationButton = driver.findElement(By.cssSelector(".auth-box__auth-submit.auth__btn.auth__btn--green"));
        authorizationButton.click();

        List<WebElement> exit = driver.findElements(By.cssSelector(".exit"));
        assertNotNull(exit);

        List<WebElement> allElements = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<List<WebElement>>() {
                    @Override
                    public List<WebElement> apply(WebDriver d) {
                        return d.findElements(By.xpath(".//*[@id='container']/div/div[2]/div/div/div[1]/ul/li"));
                    }
                });

        Random random = new Random();
        int index = random.nextInt(allElements.size());
        WebElement randomTheme = allElements.get(index);
        String linkText = randomTheme.getText();
        randomTheme.click();

        WebElement themeTitle = driver.findElement(By.cssSelector(".schema-header__title"));
        String linkTitle = themeTitle.getText();
        assertEquals(linkText, linkTitle);

        WebElement logout = driver.findElement(By.cssSelector(".exit"));
        assertEquals(logout.getAttribute("class"), "exit");
        logout.click();

        driver.close();

    }

}
