package com.amazon.page;

import com.amazon.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    public static String price,searchbook;

    @FindBy(how = How.ID,using="twotabsearchtextbox")
    WebElement eleSearchTxt;

    @FindBy(how=How.ID,using="nav-search-submit-button")
    WebElement eleSearchBtn;

    @FindBy(how=How.XPATH,using = "//span[@data-component-type='s-search-results']//div[contains(@class,'s-main-slot')]/div[@data-index=1]//h2/a")
    WebElement search;

    @FindBy(how = How.XPATH,using = "//span[@data-component-type='s-search-results']//div[contains(@class,'s-main-slot')]/div[@data-component-type='s-search-result']//span[@class='a-price']/span[@class='a-offscreen']")
    List<WebElement> priceList;

    /**
     * dependency injection - driver.
     *
     * @param driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String get_title(){
        String title=driver.getTitle();
        return title.replace("Amazon.com : ","");

    }

    public void searchAction(String searchtxt){
        eleSearchTxt.sendKeys(searchtxt);
        eleSearchBtn.click();
    }

    public SearchResultPage searchList()  {
        price= priceList.get(0).getAttribute("innerText");
        System.out.println(price);
        searchbook=search.getAttribute("innerText");
        System.out.println(searchbook);

        search.click();

        return PageFactory.initElements(driver, SearchResultPage.class);

    }
}
