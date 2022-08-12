package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_register {
    public P01_register() {
        PageFactory.initElements(Hooks.driver,this);
    }
    @FindBy(className = "ico-register")
    public WebElement registerbtn;
    @FindBy(className = "male")
    public WebElement gender;


    @FindBy(id = "FirstName")
    public WebElement firstName;


    @FindBy(id = "LastName")
    public WebElement lastName;

    @FindBy (name = "DateOfBirthDay")
    public WebElement birthday;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement birthMonth;


    @FindBy(name = "DateOfBirthYear")
    public WebElement birthYear;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy (id="Password")
    public WebElement passWord;

    @FindBy(id = "ConfirmPassword")
    public WebElement confPass;

    @FindBy(id = "register-button")
    public WebElement registerOkbtn;

    @FindBy(className = "result")
    public WebElement conFirmMess;

    @FindBy(className = "buttons")
    public WebElement Continue;

}
