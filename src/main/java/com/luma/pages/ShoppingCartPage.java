package com.luma.pages;

import com.aventstack.extentreports.Status;
import com.luma.customlisteners.CustomListeners;
import com.luma.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {@CacheLookup
@FindBy(xpath = "//span[text()='Shopping Cart']")
WebElement getTextShoppingCart;


    @CacheLookup
    @FindBy(xpath = "(//a[text()='Cronus Yoga Pant '])[2]")
    WebElement getTextOfProductName;

    @CacheLookup
    @FindBy(xpath = "//dd[contains(text(),'32')]")
    WebElement getTextOfProductSize;

    @CacheLookup
    @FindBy(xpath = "//dd[contains(text(),'Black')]")
    WebElement getTextProductColour;

    @CacheLookup
    @FindBy(xpath = "(//a[text()='Overnight Duffle'])[2]")
    WebElement getTextBagName;

    @CacheLookup
    @FindBy(xpath = "//input[@value = '3']")
    WebElement getTextOfQty;

    @CacheLookup
    @FindBy(xpath = "(//span[text()='$135.00'])[4]")
    WebElement getPriceOfProduct;

    @CacheLookup
    @FindBy(xpath = "//input[@class='input-text qty']")
    WebElement changeQty;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Update Shopping Cart')]")
    WebElement updateCart;

    @CacheLookup
    @FindBy(xpath = "(//span[@class='price'])[12]")
    WebElement getTextOfProductPrice;


    public String verifyTextShoppingCart() {
        Reporter.log("Get Text Shopping cart" + getTextShoppingCart.toString());
        CustomListeners.test.log(Status.PASS, "Get Text Shopping cart");
        return getTextFromElement(getTextShoppingCart);
    }

    public String verifyProductName() {
        Reporter.log("Get Text Product Name" + getTextOfProductName.toString());
        CustomListeners.test.log(Status.PASS, "Get Text Product Name");
        return getTextFromElement(getTextOfProductName);
    }

    public String verifyProductSize() {
        Reporter.log("Verify product size" + getTextOfProductSize.toString());
        CustomListeners.test.log(Status.PASS, "Verify product size");
        return getTextFromElement(getTextOfProductSize);
    }

    public String verifyProductColour() {
        Reporter.log("Verify product colour" + getTextProductColour.toString());
        CustomListeners.test.log(Status.PASS, "Verify product colour");
        return getTextFromElement(getTextProductColour);
    }

    public String verifyTextBagName() {
        Reporter.log("Get text bag name" + getTextBagName.toString());
        CustomListeners.test.log(Status.PASS, "Get text bag name");
        return getTextFromElement(getTextBagName);
    }

    public String verifyQtyOfProduct() {
        String expectedQty = "3";
        WebElement actualElement = getTextOfQty;
        String actualQty = actualElement.getAttribute("value");
        Reporter.log("Verify Qty of product" + getTextOfQty.toString());
        CustomListeners.test.log(Status.PASS, "Verify Qty of product");
        return actualQty;
    }

    public String verifyProductPrice() {
        Reporter.log("Verify price of product" + getPriceOfProduct.toString());
        CustomListeners.test.log(Status.PASS, "Verify price of product");
        return getTextFromElement(getPriceOfProduct);
    }

    public void changeQtyOfProduct() {
        clickOnElement(changeQty);
        changeQty.clear();
        sendTextToElement(changeQty, "5");
        Reporter.log("Change Qty of Product" + changeQty.toString());
        CustomListeners.test.log(Status.PASS, "Change Qty of Product");
    }

    public void updateShoppingCart() {
        Reporter.log("Update shopping cart" + updateCart.toString());
        clickOnElement(updateCart);
        CustomListeners.test.log(Status.PASS, "Update shopping cart");
    }

    public String verifyUpdatedProductPrice() {
        Reporter.log("Verify product price is updated" + getTextOfProductPrice.toString());
        CustomListeners.test.log(Status.PASS, "Verify product price is updated");
        return getTextFromElement(getTextOfProductPrice);
    }

}
