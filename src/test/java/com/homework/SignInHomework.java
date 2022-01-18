package com.homework;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SignInHomework {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @After
    public void tearDown() {
        //driver.quit();

    }

    @Test
    public void createAccount() {
        driver.findElement(By.xpath("//a[@class='login']")).click();
        driver.findElement(By.id("email_create")).sendKeys("celine3@gmail.com");
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @Test
    public void signupInfo () {

            WebElement createText = driver.findElement(By.xpath("//h1[text()='Create an account']"));
            Assert.assertEquals("CREATE AN ACCOUNT", createText.getText());

            WebElement personalText = driver.findElement(By.xpath("//h3[text()='Your personal information']"));
            Assert.assertEquals("YOUR PERSONAL INFORMATION", personalText.getText());

            WebElement title = driver.findElement(By.xpath("//label[text()='Title']"));
            Assert.assertEquals("Title", title.getText());

            WebElement checkbox1 = driver.findElement(By.id("uniform-id_gender2"));
            checkbox1.click();

            driver.findElement(By.id("customer_firstname")).sendKeys("Jane");
            driver.findElement(By.id("customer_lastname")).sendKeys("Khan");
            //driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("email")).sendKeys("celine3@gmail.com");
            driver.findElement(By.id("passwd")).sendKeys("pword1234!");

            //      Selecting birth day
            WebElement day = driver.findElement(By.id("days"));
            Select daySelect = new Select(day);
            daySelect.selectByIndex(2);

            //      Selecting birth month
            WebElement month = driver.findElement(By.id("months"));
            Select monthSelect = new Select(month);
            monthSelect.selectByIndex(3);


//      Selecting birth year
            WebElement year = driver.findElement(By.id("years"));
            Select yearSelect = new Select(year);
            yearSelect.selectByValue("2000");

            driver.findElement(By.id("uniform-newsletter")).click();

            driver.findElement(By.id("firstname")).clear();
            driver.findElement(By.id("firstname")).sendKeys("Jane");
            driver.findElement(By.id("lastname")).clear();
            driver.findElement(By.id("lastname")).sendKeys("Khan");
            driver.findElement(By.id("company")).sendKeys("Apple");
            driver.findElement(By.id("address1")).sendKeys("1 Apple Park Way");
            driver.findElement(By.id("city")).sendKeys("Cupertino");

            WebElement state = driver.findElement(By.id("id_state"));
            Select stateSelect = new Select(state);
            stateSelect.selectByVisibleText("California");

            driver.findElement(By.id("postcode")).sendKeys("95118");

            WebElement country = driver.findElement(By.id("id_country"));
            Select countrySelect = new Select(country);
            countrySelect.selectByVisibleText("United States");

            driver.findElement(By.id("other")).sendKeys("first test");
            driver.findElement(By.id("phone")).sendKeys("4354502121");
            driver.findElement(By.id("phone_mobile")).sendKeys("4304502121");
            driver.findElement(By.id("alias")).sendKeys("");
            driver.findElement(By.id("submitAccount")).click();
        }

        @Test
                public void lastPage() {

            boolean myAccount = driver.findElement(By.xpath("//h1[text()='My account']")).isDisplayed();

            WebElement testElement = driver.findElement(By.xpath("//*[@id='center_column']/h1"));
            // Assert.assertTrue(testElement.isDisplayed());

            String text = testElement.getText();
            System.out.println(text);
            Assert.assertEquals("MY ACCOUNT", text);



    }

}
