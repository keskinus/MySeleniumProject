package com.myfirstproject;

import com.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Day07_Actions4 extends TestBase {
    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);

//      1. Create actions object for keyboard actions
        Actions actions = new Actions(driver);

//      2.use the proper actions methods
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();//scrolling page down
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();//scrolling page down

//      ARROW_DOWN moving page down a little bit.
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();//scrolling page down
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();//scrolling page down

//      PAGE_UP and ARROW_UP is used to move the pages up
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();//scrolling page down
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();//scrolling page down

    }

}
