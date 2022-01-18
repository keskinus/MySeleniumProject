package com.myfirstproject;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day06_NewWindowSel4 {
    @Test
    public void newWindowsTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

//      1. open google in the window 1
        driver.get("https://www.google.com");
        String googleHandle = driver.getWindowHandle();


//        Open amazon in the window 2
//        Creating a new empty window and switching it
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.com");
        String amazonHandle = driver.getWindowHandle();

//        Open linkedin in the window 3
//        Creating a new empty window and switching it
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinHandle = driver.getWindowHandle();

//      SWITCH BACK TO google window
        Thread.sleep(5000);
        driver.switchTo().window(googleHandle);
        System.out.println("GOOGLE URL = >" + driver.getCurrentUrl());

//      SWITCH BACK TO amazon window
        Thread.sleep(5000);
        driver.switchTo().window(amazonHandle);
        System.out.println("AMAZON URL = >" + driver.getCurrentUrl());

//      SWITCH BACK TO linkedin window
        Thread.sleep(5000);
        driver.switchTo().window(linkedinHandle);
        System.out.println("LINKEDIN URL = >" + driver.getCurrentUrl());

    }



}
