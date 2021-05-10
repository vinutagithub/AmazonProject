package com.amazon.page;

import com.amazon.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {

   // @FindBy(how=How.id,using = "")
    /**
     * dependency injection - driver.
     *
     * @param driver
     */
    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
