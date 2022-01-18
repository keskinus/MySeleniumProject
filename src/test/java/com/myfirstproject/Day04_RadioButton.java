package com.myfirstproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Day04_RadioButton {
    WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();

    }
    @Test
    public void radioButton(){
        driver.get("https://www.facebook.com");
 //    clicking on the create new account link
        driver.findElement(By.linkText("Create new account")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("MYNAME");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("LASTNAME");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("1111111");
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("secretpass1!");
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();

// sayfada id de numara varsa onu kullnamayin cunku degisebilir
        //some id has number thats why we not use dynamic id
//      NOTE: some ids might be DYNAMIC if id has NUMBER
//      It means id values can change after the next usage.
//      For this reason, wee need to avoid using dynamic ids
//      HOW DO YOU HANDLE DYNAMIC ID???
//      -Dynamic id means id value can change. In this case, I don't prefer to use id.
//      If I have to use it I WRITE DYNAMIC XPATH!!!
//      I find what is the same every single time then write dynamic xpath
//      I can use contains, start-with or ends-with dynamic xpath

//        //tag[contains(@attribute,’value’)]     => (//input[contains(@id,'u_')])[1]
//        //tag[starts-with(@attribute,’value’)]   => (//input[starts-with(@id,’u_')])[1]  Returns the first input whose id starts with u_
//        //tag[ends-with(@attribute,’value’)]    => //input[ends-with(@id,’P7’)] Returns the input elements who ends with P7


//      Selecting birth month
        WebElement month = driver.findElement(By.id("month"));
        Select monthSelect = new Select(month);
        monthSelect.selectByVisibleText("Jun");

//      Selecting birth day
        WebElement day = driver.findElement(By.id("day"));
        Select daySelect = new Select(day);
        daySelect.selectByIndex(2);

//      Selecting birth year
        WebElement year = driver.findElement(By.id("year"));
        Select yearSelect = new Select(year);
        yearSelect.selectByVisibleText("2000");

//       Clicking on the sign up
        driver.findElement(By.name("websubmit")).click();
    }

}
