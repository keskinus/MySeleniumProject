package com.myfirstproject;

import com.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class Day09_ScreenshotSel4 extends TestBase {
 /*
    In selenium 4, we can take screenshot of specific elements
  */
    @Test
    public void takeScreenShotTest() throws IOException {
        driver.get("https://www.google.com/");
//      get the screenshot of ONLY THE GOOGLE LOGO

        WebElement googleLogo = driver.findElement(By.xpath("//img[@class='lnXdpd']"));
        File googleLegoImage = googleLogo.getScreenshotAs(OutputType.FILE);

//      Save the file as googleLego.png
        File finalPath = new File("googleLogoImage");
        FileUtils.copyFile(googleLegoImage,finalPath);

    }
}
