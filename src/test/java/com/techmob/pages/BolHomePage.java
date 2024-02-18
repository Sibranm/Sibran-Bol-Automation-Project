package com.techmob.pages;

import com.techmob.utilities.BrowserUtils;
import com.techmob.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BolHomePage {

    public BolHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#js-first-screen-accept-all-button")
    public WebElement acceptCookies;

    @FindBy(xpath = "//button[.='Doorgaan']")
    public WebElement doorgaan;

    @FindBy(id = "searchfor")
    public WebElement searchBar;

    @FindBy(id = "basket")
    public WebElement shoppingCart;

    @FindBy(xpath = "(//span[.='Inloggen'])[2]")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@data-test='category-menu']")
    public WebElement categoryButton;

    @FindBy(xpath = "//ul[@class='c-bKvviC c-bOtMYW c-bKvviC-byEgVF-columns-1 c-bKvviC-dYjHli-columns-5']")
    public WebElement footerLinksArea;

    @FindBy(xpath = "(//ul[@class='c-bKvviC c-bOtMYW c-bKvviC-byEgVF-columns-1 c-bKvviC-dYjHli-columns-5'])//a")
    public List<WebElement> allFooterLinks;



    public void clickAcceptCookies() {

        acceptCookies.click();

    }

    public void clickDoorgaan() {

        doorgaan.click();

    }

    public void clickLogin() {

        loginButton.click();

    }

    public void clickShoppingCart() {

        try {

            shoppingCart.click();

        }catch (StaleElementReferenceException e){

            shoppingCart.click();
            e.printStackTrace();

        }


    }

    public void searchForProduct(String searchWord){

        try {

            searchBar.sendKeys(searchWord + Keys.ENTER);

        }catch (StaleElementReferenceException e){

            searchBar.sendKeys(searchWord + Keys.ENTER);
            e.printStackTrace();

        }

    }

    public void clickCategory() {

        try {

            categoryButton.click();

        } catch (StaleElementReferenceException e) {

            categoryButton.click();
            e.printStackTrace();

        }


    }

    public void navigateToCategory(String category, String category1, String finalCategory) {

        String moduleLocator = "//a[normalize-space()='" + category + "' and @class='wsp-category-nav-ab__link js_cat_link']";
        String subModuleLocator = "(//span[.='" + category1 + "'])[1]";
        String finalCategoryLocator = "//a[.='" + finalCategory + "']";

        WebElement categoryOption = Driver.getDriver().findElement(By.xpath(moduleLocator));
        BrowserUtils.waitForVisibility(categoryOption, 10);

        categoryOption.click();
        WebElement subCategoryOption = Driver.getDriver().findElement(By.xpath(subModuleLocator));
        BrowserUtils.waitForVisibility(subCategoryOption, 10);

        subCategoryOption.click();
        WebElement finalCategoryOption = Driver.getDriver().findElement(By.xpath(finalCategoryLocator));
        BrowserUtils.waitForVisibility(finalCategoryOption, 10);

        finalCategoryOption.click();


    }

    public void scrollIntoFooterLinksArea(){

        BrowserUtils.scrollToElement(footerLinksArea);

    }


}
