package com.myfirstproject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day03_Locators {
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://a.testaddressbook.com/sign_in");

    }

    @Test
    public void locators() throws InterruptedException {

  //     Location the email input
        driver.findElement(By.id("session_email")).sendKeys("testtechproed@gmail.com");

  //    Locating the password and typing the password and typing the password
        driver.findElement(By.id("session_password")).sendKeys("Test1234!");

 //     Locating the sign in button
        driver.findElement(By.name("commit")).click();
        Thread.sleep(2000);

//        Then verify that the expected user id  testtechproed@gmail.com (USE getText() method to get the text from the page) 
//        1. locate the element
//        2. getText wil return the text as String
//        3.assert

        WebElement userId = driver.findElement(By.className("navbar-text"));
        System.out.println(userId);
        String actualUserIdText = userId.getText();
        System.out.println(actualUserIdText);
        String expectedUserId = "testtechproed@gmail.com";
        Assert.assertEquals("ID Test Fails", expectedUserId,actualUserIdText);


//        Verify the Addresses and Sign Out  texts are displayed  

        WebElement addressesElement=driver.findElement(By.linkText("Addresses"));
//        isDisplayed() return true if element is displayed.
//        Returns false if element is not displayed
        Assert.assertTrue(addressesElement.isDisplayed());
//        sign out
        WebElement signOutElement = driver.findElement(By.linkText("Sign out"));

//          Find the number of total link on the page 
//          How do you find total number of link on the page?(Interview Question
//          How many a tag on the page?
 //         a tag is used to create links
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));//return all links on the page
        System.out.println("Total number of link : "+ allLinks.size());// find  total number of link we use size
        //

        //Find link names
        for(WebElement eachElement:allLinks) {
            System.out.println(eachElement.getText());
        }
            //          Sign out from the page
        driver.findElement(By.partialLinkText("Sign out")).click();


 //    NOTE: make sure do the assertion for verifying the sign out successful
        boolean isSigneOut = driver
                            .getCurrentUrl()
                            .equals("http://a.testaddressbook.com/sign_in");

        Assert.assertTrue(isSigneOut);
        Thread.sleep(2000);


    }
    @After
    public void tearDown() {
        driver.close();
    }
}
