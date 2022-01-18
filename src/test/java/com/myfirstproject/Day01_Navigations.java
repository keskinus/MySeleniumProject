package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_Navigations {
    public static void main(String[] args) throws InterruptedException {
        //Step1 : Set the path and driver name
        //. means absolute place
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

        //Step2: Create Webdriver object(Create chrome driver)
        WebDriver driver = new ChromeDriver();

        //Maximize the window
        driver.manage().window().maximize();

        //Step 3: now I have driver, I can use drive in automation
        //Open google home page https://www.google.com/.
        driver.get("https://www.google.com");
        Thread.sleep(5000);


        // On the same class, Navigate to amazon home page https://www.amazon.com/
        // navigate () is also  used to go to webpages
        driver.navigate().to("https://www.amazon.com/");

        // Navigate back to google
        driver.navigate().back();
        Thread.sleep(5000);

        // Navigate forward to amazon
        driver.navigate().forward();
        Thread.sleep(5000);

        //Refresh the page
        driver.navigate().refresh();

//        Create a new class under : BasicNavigations
//        Create main method

//        Close/Quit the browser
        //to close driver , we can use close() or quit();
       // driver.close();
        driver.quit();

        /*
        What is the difference between get () and navigate to?
        1. get() easier to use, use more than navigate()
        2.get() a little faster
        3.get() takes only string, but navigate.to takes string or URL as parameter
        4. navigate has more options: back, forward, fresh
        -------------------------------------------------
        What is teh difference between close and quit?
        close() -> closes only current working browser
        quit() -> closes all browsers.

        -------------------------------------------
        TWhat is Thread.sleep()?
        It is used to put some wait.
        Thread.sleep(5000) is a JAVA wait. It is not a selenium wait.
        Because this is HARD wait.
        It means, this will put extra wait EVEN IF WE DON'T NEED
        We will use selenium waits. They will be DYNAMIC WAIT.
        * ---------------------------
         */
    }
}
