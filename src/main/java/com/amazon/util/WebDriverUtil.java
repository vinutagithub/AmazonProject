package com.amazon.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtil {

    private static WebDriverUtil instWebDriverUtil=null;

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private WebDriverUtil(){}

    public static WebDriverUtil getInstWebDriverUtil(){
        if(instWebDriverUtil ==null) {
            instWebDriverUtil = new WebDriverUtil();
        }
        return (instWebDriverUtil);
    }

    /**
     * setting driver Object based on input parameter.
     **/
    public final void getWebDriver(String drivername){
        switch(drivername){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;

        }

    }

    public WebDriver getDriver(){
        return driver.get();
    }
}
