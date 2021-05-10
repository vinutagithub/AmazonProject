package com.amazon.page;

import com.amazon.base.BasePage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class SearchResultPage extends BasePage {

    @FindBy(how= How.ID,using = "newBuyBoxPrice")
    WebElement eleBuyPrice;

    @FindBy(how=How.ID,using = "add-to-cart-button")
    WebElement eleAddtocartBttn;

    /**
     * dependency injection - driver.
     *
     * @param driver
     */
    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getBuyPrice(){
        return (eleBuyPrice.getText());
    }


    public AddToCart buttonClickAction(){

        eleAddtocartBttn.click();
        return PageFactory.initElements(driver,AddToCart.class);
    }


}
