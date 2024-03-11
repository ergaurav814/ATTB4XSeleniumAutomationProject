package org.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.net.MalformedURLException;
import java.util.Objects;


// do not need to dive too much in threadlocal concept
// anything tht we need to have a thread safe should be declare in <> in front of Threadlocalclass
// first three concepts are used for thread local (get, set , unload)
// next two . one is used for driver initialization
// other is used to quit driver


public class DriverManagerTL {

    public static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();


    public static void setDriver(WebDriver driverRef){


        dr.set(driverRef);

    }

    public static WebDriver getDriver(){


        return dr.get();
    }


    public static void unload(){


        dr.remove();

    }

    public static void init() throws MalformedURLException {
        if (Objects.isNull(DriverManagerTL.getDriver())){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\divya\\IdeaProjects\\ATTB4XSeleniumAutomationProject\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--guest");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--ignore-certificate-errors");
            WebDriver driver = new ChromeDriver(options);
            setDriver(driver);

        }
    }

    public static void down() {
        if (Objects.nonNull(DriverManagerTL.getDriver())) {
            getDriver().quit();
            unload();


        }
    }
}
