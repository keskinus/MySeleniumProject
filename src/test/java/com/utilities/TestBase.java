package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public  abstract class TestBase {
 //     Making this abstarct, because we just want to implement the methods without showing the details
 //     We also do not want to create an object on TestBase, just want to use the method inside it.


 //  testbase hakkinda note --> // abstract class in constructor child class dan kullanilamamaz, dolayisiyla child dan bu class in object ini olusturamayiz.
    //    // bu sinifin abstract olmasi extend ederek methodlari kullanmamiz icin onemli
 //     1.Before
 //     2.After
 //     Why TestBase?
 //     We use TestBase for REPEATED PRE CONDITION AND  AFTER CONDITION
 //     TestBase is reusable
 //     This will make actual  test class shorter

    protected WebDriver driver;
    protected ExtentHtmlReporter extentHtmlReporter;
    protected ExtentReports extentReports;
    protected ExtentTest extentTest;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

//      Create html report test-output folder. name = my_project_report.html
//        Path of the html report
        String reportPath =  System.getProperty("user.dir")+ "/test-output/my_project_report.html";
//        Creating html report in the file path
        extentHtmlReporter= new ExtentHtmlReporter(reportPath);
//      Adding custom information
//        Creating extent report
        extentReports=new ExtentReports();
//      Adding  custom information
        extentReports.setSystemInfo("Test Enviroment", "Test Enviroment");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Team","Team Galaxy");
        extentHtmlReporter.config().setReportName("GMI Bank test reports");
        extentHtmlReporter.config().setDocumentTitle("JUnit Reports");


//        Attaching html report the Extent report
        extentReports.attachReporter(extentHtmlReporter);
//      So far the report creating is DONE.
        extentTest =extentReports.createTest("My Project Extent Reports","Automation Login Scenarios");

    }

    @After
    public void tearUp() {
       // driver.close();
        extentReports.flush();
    }

}
