package com.luma.testsuite;

import com.luma.customlisteners.CustomListeners;
import com.luma.pages.HomePage;
import com.luma.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Listeners(CustomListeners.class)
public class WomenJacketTest extends BaseTest {

    HomePage homePage = new HomePage();

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "regression"})
    //1. verifyTheSortByProductNameFilter
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        //* Mouse Hover on Women Menu
        //  waitUntilVisibilityOfElementLocated(By.xpath("(//span[contains(text(),'Women')])[1]"),5);
        Thread.sleep(2000);
        homePage.mouseHoverToWomenMenu();
        //* Mouse Hover on Tops
        homePage.mouseHoverToTopMenu();
        //* Click on Jackets
        homePage.clickOnJacket();
        List<WebElement> jacketsElementsList = driver.findElements(By.xpath("//strong[@class='product name product-item-name']//a"));
        ArrayList<String> jacketsNameListBefore = new ArrayList<>();
        for (WebElement e : jacketsElementsList) {
            jacketsNameListBefore.add(e.getText());
        }
        System.out.println(jacketsNameListBefore);
        jacketsNameListBefore.sort(String.CASE_INSENSITIVE_ORDER);
        //* Select Sort By filter “Product Name”
        homePage.verifySortByProductName();
        //* Verify the products name display in alphabetical order
        Assert.assertEquals(homePage.afterSortingByProductName(), homePage.defaultProductList());

    }

    @Test(groups = {"smoke", "regression"})
    //2. verifyTheSortByPriceFilter
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        //* Mouse Hover on Women Menu
        Thread.sleep(2000);
        homePage.mouseHoverToWomenMenu();
        //* Mouse Hover on Tops
        homePage.mouseHoverToTopMenu();
        //* Click on Jackets
        homePage.clickOnJacket();
        Thread.sleep(2000);
        List<WebElement> jacketsElementsList = driver.findElements(By.xpath("//span[@class='price-wrapper ']//span"));
        ArrayList<Double> jacketsPriceListBefore = new ArrayList<>();
        for (WebElement e : jacketsElementsList) {
            jacketsPriceListBefore.add(Double.valueOf(e.getText().replace("$", "")));
        }
        //* Select Sort By filter “Price”
        homePage.verifySortByPrice();
        //* Verify the products price display in Low to High
        Thread.sleep(2000);
        Assert.assertEquals(homePage.defaultProductsPriceList(), homePage.afterSortingByProductsPriceList());
    }
}
