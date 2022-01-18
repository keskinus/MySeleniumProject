package com.myfirstproject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day06_Alerts {
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAlert(){
//        click on the first alert,
//        verify the text “I am a JS Alert” ,
//        click OK ,
//        and Verify “You successfully clicked an alert”
//        locating he first button
//        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        WebElement button1=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
//        clicking
        button1.click();
//        verify the text “I am a JS Alert” ,
//        We cannot inspect alert elements, so we must use switchTo() function to handle alerts
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals("TEXT DOESN'T MATCH","I am a JS Alert",alertText);
//        click OK
//        Again, we cannot inspect Ok button on the ALERT
//        so we must switch to alert and accept
        driver.switchTo().alert().accept();
//        and Verify “You successfully clicked an alert”
        String actualResult=driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You successfully clicked an alert",actualResult);
    }
    @Test
    public void dismissAlert(){
//        click on the second alert,
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
//        verify text "I am a JS Confirm”,
        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Confirm",actualAlertText);
//        click cancel, "
        driver.switchTo().alert().dismiss();
//        "Verify “You clicked: Cancel”
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You clicked: Cancel",actualResult);
//        EXPECTED DATA COMES FROM THE USER STORIES/ACCEPTANCE CRITERIA
//        ACTUAL COMES FROM THE WEBSITE
    }
    //    click on the third alert,
//    verify text “I am a JS prompt”,
//    type “Hello World”,
//    click OK,
//    and Verify “You entered: Hello Word”
    @Test
    public void sendKeysAlert(){
//    click on the third alert,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
//    verify text “I am a JS prompt”,
        String actualText = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS prompt",actualText);
//    type “Hello World”, click OK,
        driver.switchTo().alert().sendKeys("Hello World");
//        click OK
        driver.switchTo().alert().accept();
        //    and Verify “You entered: Hello World”
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You entered: Hello World",actualResult);
    }

}
