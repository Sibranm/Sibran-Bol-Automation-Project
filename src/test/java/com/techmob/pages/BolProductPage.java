package com.techmob.pages;

import com.techmob.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BolProductPage {

    public BolProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@aria-label='In winkelwagen'])[1]")
    public WebElement firstCartOnProductPage;

    @FindBy(className = "add-on-page-header__title")
    public WebElement productInShoppingCartMsg;

    @FindBy(xpath = "//input[@id='8293']")
    public WebElement bookProductDutchLanguageCheckbox;



}
