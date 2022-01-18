package com.homework;

import com.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class IFrameTest extends TestBase {
    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("https://html.com/tags/iframe");

        //scroll over the video
        JavascriptExecutor je= (JavascriptExecutor) driver;
        WebElement video = driver.findElement(By.xpath("//div[@class='render']"));
        je.executeScript("arguments[0].scrollIntoView(true);",video);

        //Switch to iframe
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        driver.switchTo().frame(iframeElement);

        //click and play the video
        WebElement play = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        play.click();
        Thread.sleep(5000);

        //stop the video
        WebElement stop = driver.findElement(By.xpath("//div[@id='movie_player']"));
        stop.click();

        // exit from the iframe
        driver.switchTo().defaultContent();



    }
}
