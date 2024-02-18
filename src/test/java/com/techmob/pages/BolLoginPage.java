package com.techmob.pages;

import com.techmob.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BolLoginPage {
    public BolLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "j_username")
    public WebElement emailBox;

    @FindBy(name = "j_password")
    public WebElement passwordBox;

    @FindBy(xpath = "//p[.='De combinatie van e-mailadres en wachtwoord is niet geldig.']")
    public WebElement errorMessage;

    public void login(String email, String password){

        emailBox.sendKeys(email);
        passwordBox.sendKeys(password + Keys.ENTER);


    }

}
