package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class Day10_Synchronization2 {


    /*
    Create a class:Synchronization2. Create a method: isEnabled
    Go to https://the-internet.herokuapp.com/dynamic_controls
    Click enable Button
    And verify the message is equal to “It's enabled!”
    And verify the textbox is enabled (I can type in the box)
    And click on Disable button
    And verify the message is equal to “It's disabled!”
    And verify the textbox is disabled (I cannot type in the box)
    NOTE: .isEnabled(); is used to check if an element is enabled or not
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

    }
    @Test
    public void isEnabled(){
        driver  .findElement(By.xpath("(//button[@type='button'])[2]")).click();
        //    And verify the message is equal to “It's enabled!”
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//SELENIUM3
        WebElement enabledMessage =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String enabledMessageText = enabledMessage.getText();
        Assert.assertEquals("It's enabled!", enabledMessageText);
       // And verify the textbox is enabled (I can type in the box)
        WebElement textbox = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textbox.isEnabled());

        //And click on Disable button
        driver  .findElement(By.xpath("(//button[@type='button'])[2]")).click();
        WebElement disableddMessage =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String disabledMessageText = disableddMessage.getText();
        Assert.assertEquals("It's disabled!", disabledMessageText);


    }
}
