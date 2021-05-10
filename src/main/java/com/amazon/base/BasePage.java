package com.amazon.base;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class BasePage {

    protected WebDriver driver;


    /**
     * dependency injection - driver.
     * @param driver
     */
    public BasePage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public String get_title(){

        String title=driver.getTitle();
        return title;

    }



}
