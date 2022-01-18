package com.myfirstproject;


import com.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day08_FileUploadTest extends TestBase {
  /*
  Class Name: FileUploadTest
    Method Name: fileUploadTest
    When user goes to https://the-internet.herokuapp.com/upload
    When user selects an image from the desktop
    And click on the upload button
    Then verify the File Uploaded!  Message displayed
   */

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");

//       send the path of the file
//       STEP1: Path of the image
        String pathOfImage = System.getProperty("user.home") + "/Desktop/download.png";

        Thread.sleep(3000);
 //     STEP 2: send keys the path of the image
       WebElement chooseFileButon = driver.findElement(By.id("file-upload"));
       chooseFileButon.sendKeys(pathOfImage);

//      STEP 3 : Click upload

        WebElement submit = driver.findElement(By.id("file-submit"));
        submit.click();

//      Verify the file is uploaded
        String actualSuccessMessage = driver.findElement(By.xpath("//h2")).getText();
        Assert.assertEquals("File Uploaded!",actualSuccessMessage);
    }
}
