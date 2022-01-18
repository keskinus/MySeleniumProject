package com.myfirstproject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_CheckBox {
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
 //         ADDING   IMPLICITLY WAIT
 //         SELENIUM 3
 //         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 //         SELENIUM 4
 //         Implicitly wait is used to put DYNAMIC WAIT for the driver
 //         Dynamic wait means driver will only wait WHEN NEEDED.
 //         When we use implicit wait in before method, then we do not need to use implicit  wait again

 //         thread.sleep(10);  -> WAIT 10 second NO MATTER WHAT
 //         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); -> WAIT UP 10 second
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkBox() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //locating the first checkbox
         WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

 //     Verify that checkbox1  is NOT CHECKED
        Assert.assertTrue(!checkbox1.isSelected());

 //     //locating the checkbox2
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
 //     Verify that checkbox2  is Selected
        Assert.assertTrue(checkbox2.isSelected());

//       How to check or Uncheck a check box
        checkbox1.click();// check

        checkbox2.click();//unchecked

 //     How to check only unchecked boxes?
 //     if checkbox is NOT check  then click
        if(!checkbox1.isSelected()){
            checkbox1.click();
        }
        if(!checkbox2.isSelected()){
            checkbox2.click();
        }

//      Asserting if both checkboxes are checked
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());
    }
}
