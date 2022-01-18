package com.homework;

import com.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FirstColData extends TestBase {
    //  Get the first column data(Lastname)
// And verify the list is not in aphabetical order

    @Test
    public void printFirstColData() {
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***1th ColumnData***");
        List<WebElement> column1Data = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[1]"));
        for (WebElement columnData : column1Data) {
            System.out.println(columnData.getText());
        }
        List<String> originalList = new ArrayList();
        for (WebElement e : column1Data) {
            originalList.add(e.getText());}
        Set<String> treeset = new TreeSet(originalList);
        Assert.assertFalse("List is  not in Alphabetical Order.",originalList.equals(treeset));

        boolean ifSortedAscending = originalList.equals(treeset);
        if (ifSortedAscending) {
            System.out.println("List is in Alphabetical Order");
        } else {
            System.out.println("List is  not in Alphabetical Order.");

        }


//        List<String> temp = new ArrayList<>(originalList);
//        originalList.sort(Comparator.comparing(String::toUpperCase));
//        System.out.println(originalList);
//        Assert.assertFalse(originalList.equals(temp));

    }
}
