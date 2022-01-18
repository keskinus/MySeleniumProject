package com.myfirstproject;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day02_FirstJUnitClass {
    /*
    JUNIT is a esting framework
    JUNIT is one of the oldest JAVA testing framework
    TESTERS ALSO USE UNIT TESTING FOR CREATING AUTOMATION TEST FRAMEWORK
    Developers also use JUnit for their UNIT TESTING
    No more main method

    ********JUNIT has 7 major annotation
    1.@ Test annotation is used to create test cases
    NOTE: all test method will be void
    Because test methods are used for assertions
    2. @ Before     : Runs before each @Test annotation( it is a suport message)
    3. @ After      : Runs after each @Test annotation
    4. @BeforeClass : Runs only once before each class
    5. @ AfterClass : Runs only once after each class
    6. @Ignore      : To skip a test case

    ********** JUNIT ASSERTION
    We use JUnit assertion if actual and expected is equal
    Instead of using if else statement, we will use  JUnit assertions
    It will come from Assert class

    1. Assert.assertEquals("ACTUAL", EXPECTED")
    2. Assert.assertTrue("ACTUAL".contains ("EXPECTED")->Boolean
    2. Assert.assertFalse("ACTUAL".contains ("EXPECTED")-> Boolean




    */

    @Before
    public  void setUp(){
        System.out.println("This is Before method");
    }

    @Test
    public  void test1(){
        System.out.println("This is Test 1");
    }

    //crating a new test case
    @Test
    public void test2(){
        System.out.println("This is Test 2");
    }

    @Ignore
    @Test
    public void test3(){
        System.out.println("This is Test 3");
    }

    @Test
    public void test4(){
        System.out.println("This is Test 4");
    }

    @After
    public void tearDown() {
        System.out.println("This is TEAR DOWN method");
    }


    //ASSERTION
    //  if expected == actual
    @Test
    public  void assertions(){
        //1. Assert.assertEquals("expected", "actual")
        //if assertion fails, we seee error message on the console
        //if assertion pass, then we see a green checkmark only
        //if two are same it will pass, if they are not same tess will fail
        Assert.assertEquals("java","java");

        //2. Assert.assertTrue (BOOLEAN);
        Assert.assertTrue("Selenium".contains("e"));

        //3.Assert.assertFalse(BOOLEAN);
        Assert.assertFalse("Selenium".contains("java")); // "Selenium".contains ("a") -> FALSE

        // We can add a message as well.
        // This message will ONLY WHEN ASSERTION FAILS!!!!
        Assert.assertEquals("ASSERTION FAILED!","java","java");


    }

    public static class Day06_Alerts {
        WebDriver driver;

        /*
        dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
        sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello World”, click OK, and Verify “You entered: Hello Word”
         */

        @Before
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        }
            @Test
            public void acceptAlert () {
    //      onclick mean javascript alert
    //      click on the first alert,

    //       locating the first button
            WebElement button1 = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
    //        clicking
            button1.click();

    //      Verify “You successfully clicked an alert”
    //      We cannot inspect alert elements, so we must use switchTo () function to handle alerts
            String alertText = driver.switchTo().alert().getText();
            Assert.assertEquals("TEXT DOESN'T MATCH","I am a JS Alert",alertText);

    //      click OK
    //      Again, wwe cannot inspect OLK button on the ALERT
    //      So we must switch to alert and accept
            driver.switchTo().alert().accept();

     //     and Verify “You successfully clicked an alert”
            String  actualResult = driver.findElement(By.id("result")).getText();
            Assert.assertEquals("You successfully clicked an alert",actualResult);
        }

        @Test
        public void  dismissAlert(){

    //   click on the second alert
           driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
    //      verify text "I am a JS Confirm”,
            String alertText2 = driver.switchTo().alert().getText();
            Assert.assertEquals("TEXT DOESN'T MATCH","I am a JS Confirm",alertText2);
    //      click cancel
            driver.switchTo().alert().dismiss();
    //      Verify “You clicked: Cancel”
           String  actualResult= driver.findElement(By.id("result")).getText();
            Assert.assertEquals("You clicked: Cancel",actualResult);

    //      EXPECTED DATA COMES FROM THE USER STORIES/ACCEPTANCE CRITERIA
    //      ACTUAL COMES FROM THE WEBSITE
        }


        @Test
        public  void sendKeysAlert(){
    //    click on the third alert,
            driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
    //      verify text “I am a JS prompt”
            String alertText3 = driver.switchTo().alert().getText();
            Assert.assertEquals("TEXT DOESN'T MATCH","I am a JS prompt",alertText3);
    //      type “Hello World”
            driver.switchTo().alert().sendKeys("Hello World");
    //      click OK
            driver.switchTo().alert().accept();
    //      and Verify “You entered: Hello Word”
            String  actualResult= driver.findElement(By.id("result")).getText();
            Assert.assertEquals("You entered: Hello World",actualResult);

        }

    }
}
