package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_login {
    public P02_login() {
        PageFactory.initElements(Hooks.driver,this);
    }
    @FindBy(className = "ico-login")
    public WebElement loginbtn;
    @FindBy(id = "Email")
    public WebElement emailTxt;
    @FindBy (id= "Password")
    public WebElement passtext;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")
    public WebElement Okloginbtn;
    @FindBy(className = "ico-account")
    public WebElement myAccIcon;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]")
    public WebElement errorMessage;




}
