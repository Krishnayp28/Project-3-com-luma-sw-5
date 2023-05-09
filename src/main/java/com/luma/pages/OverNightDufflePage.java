package com.luma.pages;

import com.aventstack.extentreports.Status;
import com.luma.customlisteners.CustomListeners;
import com.luma.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class OverNightDufflePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Overnight Duffle')]")
    WebElement bagProduct;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Overnight Duffle')]")
    WebElement getTextOfBagProductName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='qty']")
    WebElement changeQty;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//div[@data-ui-id='message-success']")
    WebElement getTextAddedToShoppingCart;

    @CacheLookup
    @FindBy(xpath = "//a[text()='shopping cart']")
    WebElement shoppingCartLink;


    public void clickOnOvernightDuffelBag() {
        Reporter.log("Click on Over Night Duffel Bag" + bagProduct.toString());
        clickOnElement(bagProduct);
        CustomListeners.test.log(Status.PASS, "Click on Over Night Duffel Bag");
    }

    public String verifyTextOverNigtDuffelBag() {
        Reporter.log("Get Text Over Night Duffel Bag" + getTextOfBagProductName.toString());
        CustomListeners.test.log(Status.PASS, "Get Text Over Night Duffel Bag");
        return getTextFromElement(getTextOfBagProductName);
    }

    public void chageQtyOfBag() {
        Reporter.log("Change Qty of Bag" + changeQty.toString());
        clickOnElement(changeQty);
        changeQty.clear();
        sendTextToElement(changeQty, "3");
        CustomListeners.test.log(Status.PASS, "Change Qty of Bag");
    }

    public void clickOnAddToCartProduct() {
        Reporter.log("Click on Add to Cart" + addToCart.toString());
        clickOnElement(addToCart);
        CustomListeners.test.log(Status.PASS, "Click on Add to Cart");
    }

    public String verifyTextAddedToShoppingCartSuccessfully() {
        Reporter.log("Get Text Product Added to Shopping cart Successfully" + getTextAddedToShoppingCart.toString());
        CustomListeners.test.log(Status.PASS, "Get Text Product Added to Shopping cart Successfully");
        return getTextFromElement(getTextAddedToShoppingCart);

    }

    public void clickOnShoppingCartLink() {
        Reporter.log("Click on Shopping cart Link" + shoppingCartLink.toString());
        clickOnElement(shoppingCartLink);
        CustomListeners.test.log(Status.PASS, "Click on Shopping cart Link");
    }
}
