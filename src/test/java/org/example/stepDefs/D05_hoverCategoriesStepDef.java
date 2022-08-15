package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.*;
import static org.example.stepDefs.Hooks.driver;

public class D05_hoverCategoriesStepDef {

    P03_homePage hover = new P03_homePage();
    SoftAssert softAssert = new SoftAssert();
    Actions actions = new Actions(driver);
    public static int selectedCategory;
    int selectedSubCategory;
    List<WebElement> mainCategories;
    List<WebElement> subCategoryLinks;
    String locator;
    String selectedMainCategoryText;
    String selectedSubCategoryText;


    @Given("user hover on one of the main categories")
    public void hoverMainMenu() throws InterruptedException {
        mainCategories = hover.maincategories;
        int cout = mainCategories.size();
        System.out.println(cout);
        int min = 0;
        int max = cout - 1;
        selectedCategory = (int) floor(random() * ( max - min + 1 ) + min);
        actions.moveToElement(mainCategories.get(selectedCategory)).perform();
        selectedMainCategoryText = mainCategories.get(selectedCategory).getText();
        System.out.println("the selected category is   " + selectedMainCategoryText);
        Thread.sleep(2000);

    }


    @When("user could view sub category if exist")
    public void userCouldViewSubCategoryIfExist() {
        selectedCategory = selectedSubCategory + 1;
        locator = "(//ul[@class='top-menu notmobile']//ul)[" + selectedCategory + "]/li";
        subCategoryLinks = driver.findElements(By.xpath(locator));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    }

    @Then("user can select sub category or open main category")
    public void userCanSelectSubCategoryOrOpenMainCategory() throws InterruptedException {
        if (!subCategoryLinks.isEmpty()) {
            selectedSubCategory = subCategoryLinks.size();
            System.out.println(selectedSubCategory);
            System.out.println(subCategoryLinks.get(0).getText());
            System.out.println(subCategoryLinks.get(1).getText());
            int countS = subCategoryLinks.size();
            int minS = 0;
            int maxS = countS - 1;
            selectedSubCategory = (int) floor(random() * ( maxS - minS + 1 ) + minS);
            actions.moveToElement(subCategoryLinks.get(selectedSubCategory)).perform();
            selectedSubCategoryText = subCategoryLinks.get(selectedSubCategory).getText();
            System.out.println("Sub category is :   " + selectedSubCategoryText);
            Thread.sleep(1000);
            subCategoryLinks.get(selectedSubCategory).click();
            softAssert.assertEquals(hover.pageTitle.getText().toLowerCase().trim(), selectedSubCategoryText.toLowerCase().trim());
            softAssert.assertAll();
        }else {
            mainCategories.get(selectedCategory-1).click();
            softAssert.assertEquals(hover.pageTitle.getText().toLowerCase().trim(), selectedMainCategoryText.toLowerCase().trim());
            softAssert.assertAll();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

        }


