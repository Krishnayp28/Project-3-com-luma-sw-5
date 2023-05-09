package com.luma.pages;

import com.aventstack.extentreports.Status;
import com.luma.customlisteners.CustomListeners;
import com.luma.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "(//span[contains(text(),'Women')])[1]")
    WebElement womenMenu;

    @CacheLookup
    @FindBy(xpath = "(//span[contains(text(),'Tops')])[1]")
    WebElement topsMenu;

    @CacheLookup
    @FindBy(xpath = "(//span[contains(text(),'Jackets')])[1]")
    WebElement jacket;

    @CacheLookup
    @FindBy(xpath = "(//select[@id='sorter'])[1]")
    WebElement sortBy;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Men')]")
    WebElement menMenu;

    @CacheLookup
    @FindBy(xpath = "(//span[text()='Bottoms'])[2]")
    WebElement bottomMenu;

    @CacheLookup
    @FindBy(xpath = "(//span[text()='Pants'])[2]")
    WebElement pant;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Gear')]")
    WebElement gearMenu;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Bags')]")
    WebElement bag;

    @CacheLookup
    @FindBy(xpath = "//strong[@class='product name product-item-name']")
    List<WebElement> productList;

    @CacheLookup
    @FindBy(xpath = "//span[@class='price-wrapper ']//span")
    List<WebElement> priceList;


    public void mouseHoverToWomenMenu() {
        Reporter.log("Mouse hover to women menu" + womenMenu.toString());
        mouseHoverToElement(womenMenu);
        CustomListeners.test.log(Status.PASS, "Mouse hover to women menu" + womenMenu);
    }

    public void mouseHoverToTopMenu() {
        Reporter.log("Mouse hover to top menu" + topsMenu.toString());
        mouseHoverToElement(topsMenu);
        CustomListeners.test.log(Status.PASS, "Mouse hover to top menu" + topsMenu);
    }

    public void clickOnJacket() {
        Reporter.log("Click on Jacket" + jacket.toString());
        mouseHoverToElementAndClick(jacket);
        CustomListeners.test.log(Status.PASS, "Click on Jacket"+jacket);
    }

    public void verifySortByProductName() {
        Reporter.log("Verify product displayed sort by Product name" + sortBy.toString());
        selectByValueFromDropDown(sortBy, "name");
        CustomListeners.test.log(Status.PASS, "Verify product displayed sort by Product name"+sortBy);
    }

    public void verifySortByPrice() {
        Reporter.log("Verify Product display sort by Price" + sortBy.toString());
        selectByValueFromDropDown(sortBy, "price");
        CustomListeners.test.log(Status.PASS, "Verify Product display sort by Price"+sortBy);
    }

    public void mouseHoverToMenMenu() {
        Reporter.log("Mouse hover to Men menu" + menMenu.toString());
        mouseHoverToElement(menMenu);
        CustomListeners.test.log(Status.PASS, "Mouse hover to Men menu"+menMenu);
    }

    public void mouseHoverToBottomMenu() {
        Reporter.log("Mouse hover to Bottom menu" + bottomMenu.toString());
        mouseHoverToElement(bottomMenu);
        CustomListeners.test.log(Status.PASS, "Mouse hover to Bottom menu"+bottomMenu);
    }

    public void mouseHoverAndClickOnPantMenu() {
        Reporter.log("Mouse hover to Pant menu and Click" + pant.toString());
        mouseHoverToElementAndClick(pant);
        CustomListeners.test.log(Status.PASS, "Mouse hover to Pant menu and Click"+pant);
    }

    public void mouseHoverToGearMenu() {
        Reporter.log("Mouse hover to Gear menu" + gearMenu.toString());
        mouseHoverToElement(gearMenu);
        CustomListeners.test.log(Status.PASS, "Mouse hover to Gear menu"+gearMenu);
    }

    public void clickOnBag() {
        Reporter.log("Click on Bag" + bag.toString());
        clickOnElement(bag);
        CustomListeners.test.log(Status.PASS, "Click on Bag"+bag);
    }

    public ArrayList<String> defaultProductList() {
        // Get all the products name and stored into array list
        List<WebElement> jacketsElementsList = productList;
        ArrayList<String> jacketsNameBefore = new ArrayList<>();
        for (WebElement e : jacketsElementsList) {
            jacketsNameBefore.add(e.getText());
        }
        System.out.println(jacketsNameBefore);
        Reporter.log("Default Product List" + productList.toString());
        CustomListeners.test.log(Status.PASS, "Default Product List"+productList);
        return jacketsNameBefore;

    }

    public ArrayList<String> afterSortingByProductName() {
        List<WebElement> jacketsElementsList = productList;
        ArrayList<String> jacketsNameAfter = new ArrayList<>();
        for (WebElement value : jacketsElementsList) {
            jacketsNameAfter.add(value.getText());
        }
        System.out.println(jacketsNameAfter);
        Reporter.log("Product list after sort by Product name" + productList.toString());
        CustomListeners.test.log(Status.PASS, "Product list after sort by Product name"+productList);
        return jacketsNameAfter;
    }

    public ArrayList<Double> defaultProductsPriceList() {
        // Get all the products name and stored into array list
        List<WebElement> jacketsElementsList = priceList;
        ArrayList<Double> jacketsPriceListBefore = new ArrayList<>();
        for (WebElement e : jacketsElementsList) {
            jacketsPriceListBefore.add(Double.valueOf(e.getText().replace("$", "")));
        }
        System.out.println(jacketsPriceListBefore);
        Reporter.log("Default Product list" + priceList.toString());
        CustomListeners.test.log(Status.PASS, "Default Product list"+priceList);
        return jacketsPriceListBefore;
    }


    public ArrayList<Double> afterSortingByProductsPriceList() {
        List<WebElement> jacketsElementsList = priceList;
        ArrayList<Double> jacketsPriceListAfter = new ArrayList<>();
        for (WebElement value : jacketsElementsList) {
            jacketsPriceListAfter.add(Double.valueOf(value.getText().replace("$", "")));
        }
        System.out.println(jacketsPriceListAfter);
        Reporter.log("Product list after sort by Price" + priceList.toString());
        CustomListeners.test.log(Status.PASS, "Product list after sort by Price"+priceList);
        return jacketsPriceListAfter;
    }

}
