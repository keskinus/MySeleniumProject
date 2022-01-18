package com.myfirstproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day04_CssSelector {
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.carettahotel.com/Account/Logon");

    }
    /*
    css selector: This is smilar to xpath
    tag[attribute='value']
    . = class
    # = id

    <input id="btnSubmit" type="submit" value="Log in" class="btn btn-primary py-3 px-5">

    css = input[]
    css =.btn-primary
    css = #btnSubmit
     */
    @Test
    public void cssTest(){
        //username
        driver.findElement(By.cssSelector("input[id='UserName']")).sendKeys("manager");
        //password
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Manager1!");
        //login button
        driver.findElement(By.cssSelector("#btnSubmit")).click();

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
