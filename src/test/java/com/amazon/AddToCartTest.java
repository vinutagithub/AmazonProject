package com.amazon;


import com.amazon.base.BaseTest;
import com.amazon.page.AddToCart;
import com.amazon.page.HomePage;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddToCartTest extends BaseTest {

    @Test
    public void test_AddToCartPricecheck() {

        driver.navigate().to(url);
        /*
         * Inserting cookies to the driver so that we get the same page from previous testcase
         */
        for (Cookie cookie : cookieInstance_1) {
            driver.manage().addCookie(cookie);
        }

        addToCart = new AddToCart(driver);

        /*
         *revisiting the site after adding cookies
         */
        driver.navigate().to(url);

        System.out.println("Asserting initial price with the price in the cart");


        Assert.assertEquals(addToCart.getBuyPrice(), HomePage.price);

    }
}
