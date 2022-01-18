package com.myfirstproject;

import com.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;
/*
Create a class:FileDownloadTest
downloadTest()
In the downloadTest() method, do the following test:
Go to https://the-internet.herokuapp.com/download
Download flower.png file
Then verify if the file downloaded successfully
 */

public class Day08_FileDownloadTest extends TestBase {
    @Test
    public  void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("IMG_1354.jpg")).click();

//      Verify if the file downloaded successfully
//      Waiting for the file to be dowloaded completely
        Thread.sleep(2000); //it will take some time after clicking the link

//        path of the downloaded file
        String filePath = System.getProperty("user.home")+"/Downloads/IMG_1354.jpg";

//      Verification
       boolean isDownloaded =  Files.exists(Paths.get(filePath));
       Assert.assertTrue(isDownloaded);

    }
}
