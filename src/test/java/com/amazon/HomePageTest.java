package com.amazon;

import com.amazon.base.BaseTest;
import com.amazon.page.HomePage;
import com.amazon.page.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    // HomePage hp;

    @DataProvider(name = "searchDataProvider")
    public Object[][] searchData() {
        return new Object[][]{{"qa testing for beginners"}};
    }

    @Test(groups = {"UI", "Functional"}, dataProvider = "searchDataProvider")
    public void test_001(String search) {

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        hp.searchAction(search);
        Assert.assertEquals(hp.get_title(), search);
    }

    @Test
    public void test_002() {
        SearchResultPage sp = hp.searchList();
        url = driver.getCurrentUrl();
        System.out.println(url);
        System.out.println("Assertion of Item price with searchpage - it is " + sp.getBuyPrice());
        Assert.assertEquals(HomePage.price, sp.getBuyPrice());
    }

}
