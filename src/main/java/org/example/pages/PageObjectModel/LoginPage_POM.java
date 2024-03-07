package org.example.pages.PageObjectModel;

import org.example.base.CommonToAllPage;
import org.example.driver.DriverManagerTL;
import org.example.utils.PropertyReader;
import org.openqa.selenium.By;

public class LoginPage_POM extends CommonToAllPage {

    public LoginPage_POM() {
        super();

    }

    By username = By.id("login-username");
    By password = By.id("login-password");
    By signButton = By.id("js-login-btn");
    By error_message = By.id("js-notification-box-msg"); // this is for negative test case


    public LoginPage_POM loginToVWOPositive() throws Exception {    // here by PropertyReader class we are reading username and pass
        //exception is suggested as may this file is empty of not found in future

        enterInput(username, PropertyReader.readKey("username"));
        enterInput(password, PropertyReader.readKey("password"));
        clickElement(signButton);
        return this;

        // if we dont call these function from base class , then Drivermanager.getDriver().findelemet(password).click
        //if login is successfull we have to pass the  control to dashboard
    }

    public void OpenURL(String url){

        DriverManagerTL.getDriver().get(url);

    }

    public String loginToVWONegative() throws Exception {    // here by PropertyReader class we are reading username and pass
        //exception is suggested as may this file is empty of not found in future

        enterInput(username,"admin"); // hardcoded wrong value
        enterInput(password, PropertyReader.readKey("password"));
        clickElement(signButton);
        visibilityOfElement(error_message);
        return  getElement(error_message).getText();


    }

    public DashboardPage_POM afterLogin(){  // this method is created to give control to dashboard page

        return new DashboardPage_POM();
    }

}