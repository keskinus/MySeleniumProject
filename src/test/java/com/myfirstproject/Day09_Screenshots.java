package com.myfirstproject;

import com.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Day09_Screenshots extends TestBase {
 /*
    1.How do you take screenshot ? How do you automate taking screenshot in your current project
  - I use  getScreenshotAs method
  - I actually uve reusable method.
  - I call that method when i take screenshot
  - I have a reusable in my utilities package
  - I call that method when i take screenshot
  - I have a reusable in my utilities package. I use that method.

    2. When do you take screenshot?
    - a. I take screenshot at the end of each test case verification
    - Example: verify search functionality, verify login is successful, verify text is equal to ...
    - b. Whenever test case fails, then my automation script capture the screenshot automatically.

  */



//  It is important  to take screenshots
//  We must take screenshots as a proof of test result
// We can automate taking screenshots with selenium
//  getScreenShotAs method takes the screenshots

    public void takeScreenShot() throws IOException {
//        1. TakeScreenshot is used for taking screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
//         2. calling getScreenShotAs method for taking the screenshot
       File image = ts.getScreenshotAs(OutputType.FILE);

//          3. Save is in your project
//          getting the current time for unique name
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date ());
        System.out.println(currentTime);

//      Path of the saved image
        String path = System.getProperty("user.dir") +"/test-output/Screenshots/" +currentTime + ".png";
        System.out.println(System.getProperty("user.dir"));
        System.out.println(path);
        File finalPath = new File(path);
        FileUtils.copyFile(image,finalPath);
    }

    @Test
    public void getScreenShotTest() throws IOException {
        driver.get("https://www.google.com");
        takeScreenShot();
        driver.findElement(By.name("q")).sendKeys("iphone x prices" + Keys.ENTER);
        takeScreenShot();

    }
}
