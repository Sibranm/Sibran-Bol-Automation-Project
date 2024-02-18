package com.techmob.step_definitions;

import com.techmob.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setupMethod() {
        System.out.println("--> Before: RUNNING BEFORE EACH SCENARIO");
    }

    @After
    public void tearDownMethod(Scenario scenario) {

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        System.out.println("--> After: RUNNING AFTER EACH SCENARIO");
        Driver.closeDriver();

    }

}
