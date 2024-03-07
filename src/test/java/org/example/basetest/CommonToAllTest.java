package org.example.basetest;

import org.example.driver.DriverManagerTL;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class CommonToAllTest {


    // use of this to start the WebDriver
    // and close the WebDriver


    @BeforeMethod
    protected void setup() throws MalformedURLException {

        DriverManagerTL.init();


    }
    @AfterMethod
    protected void tearDown(){

     DriverManagerTL.down();

    }






}
