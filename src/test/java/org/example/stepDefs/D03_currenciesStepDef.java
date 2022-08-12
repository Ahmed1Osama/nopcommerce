package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D03_currenciesStepDef {
    P03_homePage home =new P03_homePage();
    SoftAssert softAssert= new SoftAssert();

    @Given("Select Euro currency from the dropdown list on the top left of home page")
    public void selectEur( ){
        Select selectedC = new Select(home.Crrency);
        selectedC.selectByVisibleText("Euro");

    }

    @Then("Find all Elements with Euro currency")
    public void findAllElementsWithEuroCurrency() {
        List<WebElement> allEruo = home.getEuro;
        for (WebElement element : allEruo){
            softAssert.assertTrue(element.getText().contains("€"));
            System.out.println(element.getText());
        }

    }
}
