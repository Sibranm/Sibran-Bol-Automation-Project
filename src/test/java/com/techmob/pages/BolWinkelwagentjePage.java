package com.techmob.pages;

import com.techmob.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BolWinkelwagentjePage {

    public BolWinkelwagentjePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
