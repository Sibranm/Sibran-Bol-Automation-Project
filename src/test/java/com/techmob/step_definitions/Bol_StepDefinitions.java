package com.techmob.step_definitions;

import com.techmob.pages.BolHomePage;
import com.techmob.pages.BolLoginPage;
import com.techmob.pages.BolProductPage;
import com.techmob.utilities.BrowserUtils;
import com.techmob.utilities.ConfigurationReader;
import com.techmob.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.List;

public class Bol_StepDefinitions {

    BolHomePage bolHomePage = new BolHomePage();

    @Given("User is on the Bol homepage")
    public void user_is_on_the_bol_home_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        bolHomePage.clickAcceptCookies();
        bolHomePage.clickDoorgaan();

    }

    @When("user types {string} in the search bar and press enter")
    public void user_types_a_product_name_in_the_search_bar(String searchWord) {

        bolHomePage.searchForProduct(searchWord);

    }

    @Then("user should be able to see {string} in the title")
    public void user_should_be_able_to_see_relevant_results(String expectedWordInTitle) {

        BrowserUtils.verifyTitleContains(expectedWordInTitle);

    }

    @When("user clicks on the shopping cart on homepage")
    public void user_clicks_on_the_shopping_cart_on_homepage() {

        //BrowserUtils.waitForVisibility(bolHomePage.shoppingCart, 5);
        bolHomePage.clickShoppingCart();

    }

    BolProductPage bolProductPage = new BolProductPage();

    @Then("the user selects the option to add previously founded item to the cart")
    public void user_should_be_able_to_add_founded_item_to_shopping_cart() {

        bolProductPage.firstCartOnProductPage.click();

    }

    @Then("the item should be successfully added to the shopping cart")
    public void the_item_should_be_successfully_added_to_the_shopping_cart() {

        Assert.assertTrue(bolProductPage.productInShoppingCartMsg.getText().trim().equals("Het artikel is toegevoegd aan je winkelwagen"));

    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {

        try {

            BrowserUtils.waitForVisibility(bolHomePage.loginButton, 10);
            bolHomePage.clickLogin();

        } catch (StaleElementReferenceException e) {

            BrowserUtils.waitForVisibility(bolHomePage.loginButton, 10);
            bolHomePage.clickLogin();
            e.printStackTrace();

        }

    }

    BolLoginPage bolLoginPage = new BolLoginPage();


    @When("user enters {string} and wrong {string} and press enter")
    public void user_enters_wrong_and_wrong_and_press_enter(String email, String password) {

        bolLoginPage.login(email, password);

    }

    @Then("there is an error message is displayed {string}")
    public void there_is_an_error_message_is_displayed(String errorMessage) {

        BrowserUtils.waitForVisibility(bolLoginPage.errorMessage, 10);
        Assert.assertTrue(bolLoginPage.errorMessage.getText().equals(errorMessage));

    }

    @When("user clicks on Category dropdown")
    public void user_clicks_on_category_dropdown() {

        bolHomePage.clickCategory();

    }

    @When("user clicks on {string} further on {string} finally on {string} link")
    public void user_clicks_on_further_on_finally_on_link(String category1, String category2, String category3) {

        bolHomePage.navigateToCategory(category1, category2, category3);

    }


    @Then("user ends up on a page that displays {string} products")
    public void user_ends_up_on_a_page_that_displays_products(String category3) {


        System.out.println(Driver.getDriver().getTitle());
        BrowserUtils.verifyTitleContains(category3);

    }

    @Then("user should only see the Dutch\\(Nederlands boeken) books")
    public void user_should_only_see_the_dutch_nederlands_boeken_books() {

        Assert.assertEquals(bolProductPage.bookProductDutchLanguageCheckbox.getAttribute("checked"), "true");


    }

    @When("user scroll down to where the footer links are")
    public void user_scroll_down_to_where_the_footer_links_are() {

        try {

            bolHomePage.scrollIntoFooterLinksArea();

        } catch (StaleElementReferenceException e) {

            bolHomePage.scrollIntoFooterLinksArea();
            e.printStackTrace();

        }
//        BrowserUtils.waitForVisibility(bolHomePage.footerLinksArea,5);

    }


    @Then("all footer links have href attributes with valid link")
    public void all_footer_links_have_href_attributes_with_valid_link() {

        List<String> actualLinks = BrowserUtils.getElementsHrefAsString(bolHomePage.allFooterLinks);

        SoftAssertions softAssertions = new SoftAssertions();

        for (String url : actualLinks) {

            System.out.println(url);
            softAssertions.assertThat(BrowserUtils.isValidLink(url)).as(url).isTrue();

        }

        softAssertions.assertAll();

    }


}
