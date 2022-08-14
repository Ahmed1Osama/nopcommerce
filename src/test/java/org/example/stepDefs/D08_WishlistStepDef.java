package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;

public class D08_WishlistStepDef {

    P03_homePage wisher = new P03_homePage();
    SoftAssert softAssert= new SoftAssert();


    @Given("user click on the wishlist icon")
    public void addItemToWLisT(){
        wisher.htcLoliicon.click();
    }

    @Then("user can get successfully message with green background")
    public void userCanGetSuccessfullyMessage() {
        softAssert.assertTrue(wisher.sucssMessage.isDisplayed());
        String background = wisher.notificationSection.getCssValue("background-color");
        String convertedbackgroundcolor = Color.fromString(background).asHex();
        System.out.println(convertedbackgroundcolor);
        System.out.println(background);
        String actualResult = convertedbackgroundcolor;
        String expectedResult = "#4bb07a";
        softAssert.assertEquals(actualResult,expectedResult);
        softAssert.assertAll();
    }

    @When("success message disappear go to wishlist")
    public void successMessageDisappearGoToWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(wisher.notificationSection));
        wisher.wishlistTab.click();
    }

    @Then("get Qty value more than 0")
    public void getQtyValueMoreThanO() {
        String qty = wisher.qty.getAttribute("value");
        System.out.println(qty);
        softAssert.assertNotEquals(qty,"0");
        softAssert.assertAll();

    }
}
