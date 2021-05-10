package com.amazon.base;

import com.amazon.page.AddToCart;
import com.amazon.page.HomePage;
import com.amazon.page.SearchResultPage;
import com.amazon.util.WebDriverUtil;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Set;

/**
 * Base Test will be extended to the testclasses in src/test/java
 * it contains initial setup and teardown
 * 
 */
public class BaseTest {

    protected WebDriver driver;
    protected WebDriverUtil driverUtil;
    protected SearchResultPage sp;
    protected HomePage hp;
    protected AddToCart addToCart;
    protected static String url;
    protected static Set<Cookie> cookieInstance_1;



    @BeforeClass
    public void initialsetup(){
        driverUtil=WebDriverUtil.getInstWebDriverUtil();
        driverUtil.getWebDriver("chrome");
        driver=driverUtil.getDriver();
        hp= new HomePage(driver);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }



}
