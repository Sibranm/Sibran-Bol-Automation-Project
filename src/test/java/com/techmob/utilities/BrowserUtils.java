package com.techmob.utilities;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    public static void verifyTitle(String expectedTitle) {

        Assert.assertTrue(Driver.getDriver().getTitle().equals(expectedTitle));

    }

    public static void verifyTitleContains(String expectedInTitle) {

        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));

    }

    public static WebElement waitForVisibility(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickability(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

//    public static void sleep(int second){
//        second *= 1000;
//        try {
//            Thread.sleep(second);
//        } catch (InterruptedException e) {
//
//        }
//    }

    public static void scrollToElement(WebElement element) {

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public static List<String> getElementsHrefAsString(List<WebElement> list) {

        List<String> hrefsAsString = new ArrayList<>();

        for (WebElement links : list) {

            hrefsAsString.add(links.getAttribute("href"));

        }

        return hrefsAsString;

    }

    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if (y == 1)
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (WebDriverException we) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    public static boolean isValidLink(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            // Get the HTTP response code
            int responseCode = connection.getResponseCode();

            System.out.println("responseCode = " + responseCode);
            // Check if the response code indicates a successful request
            if (responseCode == 403 || responseCode == 999) {
                return true;
            }
            return responseCode == HttpURLConnection.HTTP_OK;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
