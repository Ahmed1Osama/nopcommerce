package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.ArrayList;
import static org.example.stepDefs.Hooks.driver;

public class D07_followUsStepDef {

    P03_homePage subscribe =new P03_homePage();
    ArrayList<String> tabs;
    WebDriverWait wait;

    @Given("user can opens {string} link")
    public void userCanOpensLink(String arg0) {
       switch (arg0){
           case "facebook":subscribe.faceBook.click();break;
           case "twitter" :subscribe.twitter.click();break;
           case "rss"     :subscribe.rss.click();break;
           case "youtube" :subscribe.youTube.click();break;
       }

    }

    @When("user can see new tab")
    public void userCanSeeNewTab() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println("Number of opened taps  "+tabs.size());
    }

    @And("user can switch between two tabs")
    public void userCanSwitchBetweenTwoTabs() throws InterruptedException {
        driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1:  " +driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.switchTo().window(tabs.get(0));
        System.out.println("tab 0:  " + driver.getCurrentUrl());
        Thread.sleep(2000);
    }
    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String arg0) throws InterruptedException {

        String current =driver.getCurrentUrl();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Assert.assertEquals(current,arg0);
        Thread.sleep(3000);
        driver.close();
    }
}
