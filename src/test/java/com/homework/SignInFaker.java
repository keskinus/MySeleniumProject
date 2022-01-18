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

public class SignInFaker {
    Faker faker = new Faker();
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
        driver.findElement(By.id("email_create")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("SubmitCreate")).click();

        WebElement createText = driver.findElement(By.xpath("//h1[text()='Create an account']"));
        Assert.assertEquals("CREATE AN ACCOUNT", createText.getText());

        WebElement personalText = driver.findElement(By.xpath("//h3[text()='Your personal information']"));
        Assert.assertEquals("YOUR PERSONAL INFORMATION", personalText.getText());

        WebElement title = driver.findElement(By.xpath("//label[text()='Title']"));
        Assert.assertEquals("Title", title.getText());

        WebElement checkbox1 = driver.findElement(By.id("uniform-id_gender2"));
        checkbox1.click();

        driver.findElement(By.id("customer_firstname")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("customer_lastname")).sendKeys(faker.name().lastName());
        //driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("passwd")).sendKeys(faker.internet().password());

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

        driver.findElement(By.id("firstname")).sendKeys("");
        driver.findElement(By.id("lastname")).sendKeys("");
        driver.findElement(By.id("company")).sendKeys(faker.company().name());
        driver.findElement(By.id("address1")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.id("city")).sendKeys(faker.address().cityName());

        WebElement state = driver.findElement(By.id("id_state"));
        Select stateSelect = new Select(state);
        stateSelect.selectByVisibleText("California");

        driver.findElement(By.id("postcode")).sendKeys(faker.address().zipCode());

        WebElement country = driver.findElement(By.id("id_country"));
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("United States");

        driver.findElement(By.id("other")).sendKeys("first test");
        driver.findElement(By.id("phone")).sendKeys(faker.phoneNumber().subscriberNumber());
        driver.findElement(By.id("phone_mobile")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.id("alias")).sendKeys("");
        driver.findElement(By.id("submitAccount")).click();


        boolean myAccount = driver.findElement(By.xpath("//h1[text()='My account']")).isDisplayed();

        WebElement testElement = driver.findElement(By.xpath("//*[@id='center_column']/h1"));
        // Assert.assertTrue(testElement.isDisplayed());

        String text = testElement.getText();
        System.out.println(text);
        Assert.assertEquals("MY ACCOUNT", text);



    }

}
