package com.amazon.page;

import com.amazon.base.BasePage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddToCart  extends BasePage {



    @FindBy(how=How.XPATH,using="//div[@id='hlb-subcart']//span[contains(@class,'a-color-price hlb-price')]")
    WebElement eleAddtoChart;

    /**
     * dependency injection - driver.
     *
     * @param driver
     */
    public AddToCart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public String getBuyPrice(){
        return eleAddtoChart.getAttribute("innerText");
    }

    public CheckoutPage addtocartAction(){
        return PageFactory.initElements(driver,CheckoutPage.class);
    }
}
