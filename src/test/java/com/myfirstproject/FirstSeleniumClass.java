package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
//       Craeting the WebDriver object
//        Polymoprphism
        WebDriver driver = new ChromeDriver();
 //Now that I created driver object,
        driver.get("https://www.amazon.com/");


    }
}
