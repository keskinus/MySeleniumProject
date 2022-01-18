package com.myfirstproject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Day11_ExtentReports  extends TestBase {
//  3 Libraries to remember?????
//  Extent reports are used for customized html reports
//  It is used to add (logs)steps on the test cased when needed
//  We have the extent reports set ups in test base

    @Test
    public void  extentReportsTest(){

        extentTest.pass("Going to the google home page");
        driver.get("https://www.google.com");
        extentTest.pass("Searching for iphone");
        driver.findElement(By.name("q")).sendKeys("iphone x" + Keys.ENTER);
        extentTest.pass("Printing the result");
        //Logging as failed
        extentTest.fail("THIS WILL FAIL");
        //logging as skipped
        extentTest.skip("THIS IS SKIPPED");

        // when company need this we will use it
       // we should use extends report as a proof of  the execution
        // to see the reports my_project_report.html->right click open in -> browser->chrome

    }
}
