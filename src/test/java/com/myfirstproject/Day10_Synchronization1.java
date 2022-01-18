package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day10_Synchronization1 {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
//      Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

    }
    @Test
    public void synchronization1(){
 //     Click on remove button
        driver  .findElement(By.xpath("//button[@type='button'][1]")).click();
//      And verify the message is equal to “It's gone!”
        /*
        * After we click on the button, It's gone! message take a few seonds.
        * Note that IF I DON'T USE wAIT, then element will not be found
        * NOSuchElementException
        * We will use Explicit Wait for the message
        1. Create WebDriverWait object
        2.Use appropriate condition
         */
//      1. CREATE WEBDRIVERWAIT object
 //     WebDriver wait = new WebDriverWait(driver,10);//SELENIUM3
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//SELENIUM3

 //     2. Use for a specific condition
 //     We have problem of visibility on It's gone message
 //     So we will wait for that locator
 //     Explicit wait does the followings:
 //       1. waits for the element up to 10 secs
 //       If the element is visible in 10 secs, then it RETURNS that element
       WebElement goneMessage =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
       String goneMessageText = goneMessage.getText();
       WebElement message = driver.findElement(By.id("message"));
       Assert.assertEquals("It's gone!", goneMessageText);

//      Then click on Add button
        driver.findElement(By.xpath("//button[@type='button'][1]")).click();
//      And verify the message is equal to “It's back!”
        WebElement backMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        String backMessageText = backMessage.getText();
        Assert.assertEquals("It's back!", backMessageText);

    }

    @Test
    public void synchronization2() throws InterruptedException {
//      NO WAIT IN THIS TEST
//      If you do not use wait, the message will not be found
//      Click on remove button
        driver  .findElement(By.xpath("//button[@type='button'][1]")).click();
//      getting the message element
//        Thread.sleep(5000);
//      This test wait because if implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement goneMessage = driver.findElement(By.xpath("//*[@id='message']"));
//      getting the text message
        String backMessageText = goneMessage.getText();
//      assertion
        Assert.assertEquals("It's gone!", backMessageText);

        /*
         * What are the selenium waits?
         *>>>>  Selenium waits are implicit, explicit and fluent wait. They are dynamic waits. We use them for wait issue(synchronization).

         * Can we use both implicit and explicit wait together? Yes, but not recommended, cause it might put additional extra wait.
         *>>>> -Yes, but not recommended, cause it might put additional extra wait. So if possible, do not use both.
         *
         * Which one do you prefer? Why?
         *>>>> -I have an implicit wait in my  testBase class. It is very useful, because it handles minor wait issues.
         * However , I personally like explicit wait, because it works really well in expected conditions, such as when element is not clickable
         * or load takes time, or element is not visible, or when there is a pop-up, then explicit wait works better. Manual testing
         * helps me to understand when to specifically use explicit wait.
         *
         * When do you get issue ?
         *>>>> -Wrong locator : instead of // p[@id='message'] you wrote // p[@class='message']
         * -element locator may be dynamic (dynamic id)
         * -wait issue-page is slow -database issue - page can be heavy(multiple iframes, videos,popups,...)
         * computer slow - internet issue
         * -element can be inside the iframe - alert that you have to handle.
         *
         * What do you do when your test case fail?
         * >>>>-Read the error log/message on the console
         * - double check
         * - then we do manuel test more time(STEP BY STEP).
         * Try different solutions based on the error.
         * -If you cannot figure out the solution for automation, check with your teammates(especially leads)
         *
         * What is the difference between implicit and explicit wait?
         * - implicit wait is global wait. It applies the wait automatically, whenever driver is called.
         * - implicit wait has only one syntax: driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         *
         * -explicit wait is local wait. It can only be applied specific elements.
         * -explicit wait performs better especially under specific expected conditions.
         * When element is not visible, or when there is a pop up, then explicit wait works better
         * -WebDriverWait object must be created for explicit wait
         * -explicit wait has more than condition
         * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
         * wait.until(ExpectedConditions.elementToBeSelected())
         * wait.until(ExpectedConditions.elementToBeSelected())
         *
         * */

    }
    @After
    public void tearDown(){
//        driver.quit();
    }
}
