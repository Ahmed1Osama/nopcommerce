package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.github.javafaker.Faker;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class D01_registerStepDef {
    P01_register reg =new P01_register();
    SoftAssert softAssert = new SoftAssert();
    
    @Given("user go to register page")
    public void goToRegisterPage()
    {

        reg.registerbtn.click();

    }

    @When("user select gender type")
    public void userSelectGenderType() {
        reg.gender.click();
    }

    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String arg0, String arg1) {
        reg.firstName.sendKeys(arg0);
        reg.lastName.sendKeys(arg1);
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        Select selectDay = new Select(reg.birthday);
        selectDay.selectByValue("16");

        Select selectMonth = new Select(reg.birthMonth);
        selectMonth.selectByValue("4");

        Select selectYear= new Select(reg.birthYear);
        selectYear.selectByValue("1990");

    }

    @And("user enter email")
    public void userEnterEmail() throws IOException {
        Faker fake = new Faker();
        String email= fake.internet().safeEmailAddress();
        configurationReader.set("email",email);
        reg.email.sendKeys(email);
        System.out.println(email);
            }

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String arg0, String arg1) {
        reg.passWord.sendKeys(arg0);
        reg.confPass.sendKeys(arg1);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        reg.registerOkbtn.click();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        softAssert.assertTrue(reg.conFirmMess.isDisplayed());
        String successMessage = reg.conFirmMess.getText();
        softAssert.assertEquals(successMessage, "Your registration completed");
        String  successMessageColor = reg.conFirmMess.getCssValue("color");
        System.out.println(successMessageColor);
        softAssert.assertEquals(successMessageColor, "rgba(76, 177, 124, 1)");

    }
}
