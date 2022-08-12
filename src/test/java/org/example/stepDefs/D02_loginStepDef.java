package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class D02_loginStepDef {
    P02_login login = new P02_login();
    SoftAssert softAssert= new SoftAssert();

    public static String wrongPass;


    @Given("user go to login page")
    public void goToLoginPage(){ login.loginbtn.click();}

    @When("user login with valid email and Password")
    public void userLoginWithValidEmailAndPassword() throws IOException {
        String email = configurationReader.get("email");
        login.emailTxt.sendKeys(email);
        login.passtext.sendKeys("P@ssw0rd");
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.Okloginbtn.click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        String curUrl = Hooks.driver.getCurrentUrl();
        softAssert.assertEquals(curUrl,"https://demo.nopcommerce.com/");
        softAssert.assertTrue(login.myAccIcon.isDisplayed());
        softAssert.assertAll();

    }

    @When("user login with invalid email and Password")
    public void userLoginWithInvalidEmailAndPassword() {
        wrongPass = RandomStringUtils.randomAlphabetic(6);
        Faker invald = new Faker();
        String invValu = invald.internet().emailAddress();
        login.emailTxt.sendKeys(invValu);
        login.passtext.sendKeys(wrongPass +"A");

    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        String errMess = login.errorMessage.getText();
        System.out.println(errMess);
        softAssert.assertEquals(errMess.contains("Login was unsuccessful"),true);
        String errMessColor = login.errorMessage.getCssValue("color");
        String errMessColorConv = Color.fromString(errMessColor).asHex();
        softAssert.assertEquals(errMessColorConv,"#e4434b");
        softAssert.assertAll();


    }
}
