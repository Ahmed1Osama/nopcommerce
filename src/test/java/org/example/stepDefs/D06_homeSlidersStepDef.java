package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.asserts.SoftAssert;

public class D06_homeSlidersStepDef {

    P03_homePage homeSlider =new P03_homePage();
    SoftAssert softAssert= new SoftAssert();


    @Given("first slider is clickable on home page")
    public void firstSliderClickable(){
        homeSlider.slider.click();
        homeSlider.implicitWait();

    }
    @Then("user should navigate to clickable URL {string}")
    public void userShouldNavigateToClickableURL(String arg0) {
        if (arg0.equals("Nokia1020")){
            softAssert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/nokia-lumia-1020");
            softAssert.assertAll();
        } else if (arg0.equals("Iphone")) {
            softAssert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/iphone-6");
            softAssert.assertAll();
        }
    }

    @Given("second slider is clickable on home page")
    public void secondSliderIsClickableOnHomePage() {

        // *[@id="nivo-slider"]
        // Xpath Iphone //*[@id="nivo-slider"]/a[1]
        // Xpath Nokia //*[@id="nivo-slider"]/a[2]
        homeSlider.implicitWaitUntill("//*[@id=\"nivo-slider\"]/a[1]", "style", "display: none;");
        homeSlider.slider.click();
        homeSlider.implicitWait();

    }
}
