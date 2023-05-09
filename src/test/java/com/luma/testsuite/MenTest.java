package com.luma.testsuite;

import com.luma.customlisteners.CustomListeners;
import com.luma.pages.HomePage;
import com.luma.pages.MenPage;
import com.luma.pages.OverNightDufflePage;
import com.luma.pages.ShoppingCartPage;
import com.luma.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class MenTest extends BaseTest {

    HomePage homePage;
    MenPage menPage;
    ShoppingCartPage shoppingCartPage;
    OverNightDufflePage overNightDufflePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        shoppingCartPage = new ShoppingCartPage();
        overNightDufflePage = new OverNightDufflePage();
        homePage = new HomePage();
        menPage = new MenPage();
    }

    @Test(groups = {"sanity", "regression"})
    //1. userShouldAddProductSuccessFullyToShoppingCart()
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //* Mouse Hover on Men Menu
        Thread.sleep(2000);
        homePage.mouseHoverToMenMenu();
        //* Mouse Hover on Bottoms
        homePage.mouseHoverToBottomMenu();
        //* Click on Pants
        homePage.mouseHoverAndClickOnPantMenu();
        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        menPage.mouseHoverAndClickOnPantSize();
        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        menPage.mouseHoverAndClickOnBlackColour();
        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        menPage.mouseHoverAndClickOnAddToCart();
        //* Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        Assert.assertEquals(menPage.verifyProductAddedToCartSuccessfully(), "You added Cronus Yoga Pant to your shopping cart.");
        //* Click on ‘shopping cart’ Link into message
        menPage.clickOnShoppingCart();
        //* Verify the text ‘Shopping Cart.’
        Assert.assertEquals(shoppingCartPage.verifyTextShoppingCart(), "Shopping Cart");
        //* Verify the product name ‘Cronus Yoga Pant’
        Assert.assertEquals(shoppingCartPage.verifyProductName(), "Cronus Yoga Pant");
        //* Verify the product size ‘32’
        Assert.assertEquals(shoppingCartPage.verifyProductSize(), "32");
        //* Verify the product colour ‘Black’
        Assert.assertEquals(shoppingCartPage.verifyProductColour(), "Black");
    }
}
