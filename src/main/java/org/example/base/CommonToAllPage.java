package org.example.base;

import org.example.driver.DriverManagerTL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//Common functions i.e
//waits
//WebDriver
// This page is common to all pages so that we can reuse
public class CommonToAllPage {

    public CommonToAllPage() {

    }

    public void implicitWait(){

        DriverManagerTL.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


public void clickElement(By by){    // will be used for click

    DriverManagerTL.getDriver().findElement(by).click();   // calling function

}

    public WebElement presenceOfElement(final By elementLocation) {
        return new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    protected void enterInput(By by, String key) {

        DriverManagerTL.getDriver().findElement(by).sendKeys(key);
    }



    protected WebElement getElement(By key) {

        return DriverManagerTL.getDriver().findElement(key);
    }


    public WebElement elementToBeClickable(final By elementIdentifier) {
        WebElement element = new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(elementIdentifier));
        return element;
    }

    public void iWaitForElementToBeVisible(WebElement loc, String url){

        try {
            WebDriverWait wait = new WebDriverWait(DriverManagerTL.getDriver(),Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfAllElements(loc));
            wait.until(ExpectedConditions.urlContains(url));
        } catch (Exception e) {
            System.out.println("Failed to wait");;
        }


    }



}
