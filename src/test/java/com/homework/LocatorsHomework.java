package com.homework;

import com.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocatorsHomework extends TestBase {
    @Test
    public void locators() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement title = driver.findElement(By.cssSelector(".title"));
        Assert.assertEquals("PRODUCTS", title.getText());

       //And gets all the prices on a list
        List<WebElement> price = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
             for (WebElement price1:price)
             System.out.println(price1.getText());
        // Creating a list to sort
        List<String> allPrices = new ArrayList<>();
            for (WebElement prices : price) {
               allPrices.add(prices.getText());
       }
       System.out.println( allPrices);

            List<Double> sortedPrices = new ArrayList<Double>();
                for (String prices:allPrices) {
                    //Remove the $ and , character using sub():
                    prices = prices.substring(1);
                    //prices.strip("$");
//                    //replace('$', "")
//
//                    //to convert the string to double you need to pass the string as an argument to the double()
//                    //To get the string value of an int,double
                        sortedPrices.add(Double.valueOf(prices));
                   //sortedPrices.add(Double.parseDouble(prices));
                   // System.out.println(prices);
//
       }

//                Double max = Collections.max(sortedPrices);
//                System.out.println(max);
//
//                Double min = Collections.min(sortedPrices);
//                System.out.println(min);
//
                Collections.sort(sortedPrices);
               System.out.println(sortedPrices);
//
//            //The verifies the minimum price is greater than $5
//            //The verifies the maximum price is less than $50
            Assert.assertTrue(sortedPrices.get(0) > 5 && sortedPrices.get(sortedPrices.size()-1) < 50);
//
//       LinkedList<Double> doublePrice = new LinkedList<>();
//        Assert.assertTrue(sortedPrices.getFirst()>5); Linkedin List ile kullanilir
//       Assert.assertTrue(sortedPrices.getLast()<50);
     }

    }
