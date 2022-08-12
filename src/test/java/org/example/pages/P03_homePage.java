package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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





}
