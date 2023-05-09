package com.luma.pages;

import com.aventstack.extentreports.Status;
import com.luma.customlisteners.CustomListeners;
import com.luma.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class MenPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "(//div[@aria-label='32'])[1]")
    WebElement pantSize;

    @CacheLookup
    @FindBy(xpath = "(//div[@option-label='Black'])[1]")
    WebElement pantColour;

    @CacheLookup
    @FindBy(xpath = "(//span[text()='Add to Cart'])[1]")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    WebElement getTextAddedToShoppingCart;

    @CacheLookup
    @FindBy(xpath = "//a[text()='shopping cart']")
    WebElement shoppingCartLink;

    public void mouseHoverAndClickOnPantSize() {
        Reporter.log("Mouse hover and click on Pant size" + pantSize.toString());
        mouseHoverToElementAndClick(pantSize);
        CustomListeners.test.log(Status.PASS, "Mouse hover and click on Pant size");
    }

    public void mouseHoverAndClickOnBlackColour() {
        Reporter.log("Mouse hover and click on Black colour" + pantColour.toString());
        mouseHoverToElementAndClick(pantColour);
        CustomListeners.test.log(Status.PASS, "Mouse hover and click on Black colour");
    }

    public void mouseHoverAndClickOnAddToCart() {
        Reporter.log("Mouse hover and click on Add to cart" + addToCart.toString());
        mouseHoverToElementAndClick(addToCart);
        CustomListeners.test.log(Status.PASS, "Mouse hover and click on Add to cart");
    }

    public String verifyProductAddedToCartSuccessfully() {
        Reporter.log("Verify product added to cart successfully" + getTextAddedToShoppingCart.toString());
        CustomListeners.test.log(Status.PASS, "Verify product added to cart successfully");
        return getTextFromElement(getTextAddedToShoppingCart);
    }

    public void clickOnShoppingCart() {
        Reporter.log("Click on shopping cart" + shoppingCartLink.toString());
        clickOnElement(shoppingCartLink);
        CustomListeners.test.log(Status.PASS, "Click on shopping cart");
    }
}
