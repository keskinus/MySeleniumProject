package com.myfirstproject;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day06_NewTabsSel4 {
    @Test
    public void newTabs() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

//      1. open google in the window 1
        driver.get("https://www.google.com");
        String googleWindowHandle = driver.getWindowHandle();

//      2. open amazon in the tab 2
//      Creating and switching to a new EMPTY Tab
        WebDriver amazonTab = driver.switchTo().newWindow(WindowType.TAB);
        amazonTab.get("https://www.amazon.com");
        String amazonWindowHandle = driver.getWindowHandle(); // give me your id. we need to switch between yhe windows

//      3. Open linkedin in a new tab
//      Create a new tab and switch to that tab automatically
        WebDriver linkedinTab = driver.switchTo().newWindow(WindowType.TAB);
        linkedinTab.get("https://www.linkedin.com");
//       getting the window handle of that window b/c i am working on multiple tabs
        String linkedinWindowHandle = driver.getWindowHandle();

//      Switching back to goggle tab
        Thread.sleep(3000);
        driver.switchTo().window(googleWindowHandle);
        System.out.println("GOOGLE URL => " +driver.getCurrentUrl());

//      Switching back to amazon tab
        Thread.sleep(3000);
        driver.switchTo().window(amazonWindowHandle);
        System.out.println("AMAZON URL => " + driver.getCurrentUrl());

//      Switching back to linkedin tab
        Thread.sleep(3000);
        driver.switchTo().window(linkedinWindowHandle);
        System.out.println("LINKEDIN URL => " + driver.getCurrentUrl());






    }


}

