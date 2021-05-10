package com.amazon;

import com.amazon.base.BasePage;
import com.amazon.base.BaseTest;
import com.amazon.page.HomePage;
import com.amazon.page.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.hamcrest.MatcherAssert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class SearchPageTest extends BaseTest {


    @Test
    public void test_searchPagePricecheck() {

        driver.get(url);

        sp = new SearchResultPage(driver);

        System.out.println("Asserting the price to SearchresultPage : " + sp.getBuyPrice());
        Assert.assertEquals(sp.getBuyPrice(), HomePage.price);

    }

    @Test(priority = 2)
    public void test_pageTiltle(){
       addToCart=sp.buttonClickAction();
       url=driver.getCurrentUrl();
       cookieInstance_1=driver.manage().getCookies();

       assertThat(addToCart.get_title(),containsString("Amazon.com Shopping Cart"));
    }
}
