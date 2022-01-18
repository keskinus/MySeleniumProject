package com.myfirstproject;

import com.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day08_AuthenticationTest extends TestBase {
    @Test
    public  void basicAuth(){
//     Authentication is done for verification
//      https://username:password@url/

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");//log in

//        Verifying the login is successful
        String congratsMessage = driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(congratsMessage.contains("Congratulations!"));

    }
}
