package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class D04_searchStepDef {

    P03_homePage searchPro =new P03_homePage();
    SoftAssert softAssert= new SoftAssert();


    @Given("user enter search {string} and get search result")
    public void userEnterSearchAndGetSearchResult(String arg0) throws InterruptedException {
        searchPro.searchBar.sendKeys(arg0);
        searchPro.searchbtn.click();
        int count =searchPro.searchResult.size();
        System.out.println("number of item "+count);
    }

    @When("user get search result on valid page")
    public void userGetSearchResultOnValidPage() {
        String thecurrentUrl =Hooks.driver.getCurrentUrl();
        softAssert.assertTrue(thecurrentUrl.contains("https://demo.nopcommerce.com/search?q="));
    }

    @Then("each result contains the search word{string}")
    public void eachResultContainsTheSearchWord(String arg0) {
        if(arg0.equals("book")||arg0.equals("laptop")||arg0.equals("nike")) {
            List<WebElement> containWord = searchPro.searchResult;
            for (WebElement element : containWord) {
                softAssert.assertTrue(element.getText().toLowerCase(Locale.ROOT).contains(arg0));
                System.out.println(element.getText());
            }
        } else if (arg0.equals("SCI_FAITH")||arg0.equals("APPLE_CAM")||arg0.equals("SF_PRO_11")) {

                Assert.assertTrue(searchPro.serilProduct.getText().contains(arg0));
                System.out.println(searchPro.serilProduct.getText());


        }


    }


    @When("user click on the product in search result")
    public void userClickOnTheProductInSearchResult() {
        searchPro.product.click();

    }
}
