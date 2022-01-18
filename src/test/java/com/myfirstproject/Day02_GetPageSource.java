package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSource {
    //getPageSource() returns page source code as a string
    //We might use this to verify if a certain text exist in the entire page
    //Note that pageSource is not used a lot to do assertions
    //Because it is too general and can lead false result

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        //getting the page source
        String pageSource = driver.getPageSource();

        //Checking if 'Best Seller' exist on the entire page
        if(pageSource.contains("Best Seller")){
            System.out.println("PASS");
        } else{
            System.out.println("FAILS");
        }

        driver.quit();
    }
}
