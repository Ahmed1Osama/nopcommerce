package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class P03_homePage {
    public P03_homePage() {
        PageFactory.initElements(Hooks.driver,this);
    }

    @FindBy(id="customerCurrency")
       public WebElement Crrency;
    @FindBy(className = "prices")
    public List<WebElement> getEuro;

    @FindBy(id = "small-searchterms")
    public WebElement searchBar;

    @FindBy(css = ".search-box .search-box-button")
    public WebElement searchbtn;
    @FindBy(className = "product-item")
    public List<WebElement> searchResult;

    @FindBy(className = "product-item")
    public WebElement product;

    @FindBy(className = "sku")
    public WebElement serilProduct;

    @FindBy(xpath= "/html/body/div[6]/div[2]/ul[1]") ////ul[@class=\"top-menu notmobile\"]/li"
    public List<WebElement> maincategories;               // /html/body/div[6]/div[2]/ul[1]
                                                         // /html/body/div[6]/div[2]/ul[1]/li


    @FindBy(className = "page-title")
    public WebElement pageTitle;


    @FindBy(className = "nivoSlider")
    public WebElement slider;


    public void implicitWait(){
        Hooks.driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }
    public void implicitWaitUntill(String s, String style, String s1) {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.attributeToBe(By.xpath(s), style, s1));
    }
}
