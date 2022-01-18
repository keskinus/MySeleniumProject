package com.homework;

import com.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class AmazonDropdown  extends TestBase {

    @Test
    public void dropdownTest() {
        driver.get("https://www.amazon.com");

//      Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

//      Print the first selected option and assert if it equals “All Departments”
        Select select = new Select(dropdown);
        WebElement selectedOption = select.getFirstSelectedOption();
        Assert.assertEquals("All Departments", selectedOption.getText());

//      Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you to need to use the get first selected option method
        select.selectByIndex(2);
        WebElement fourthOption = select.getFirstSelectedOption();
        Assert.assertEquals("Amazon Devices", fourthOption.getText());

//      Print all of the dropdown options
        List<WebElement> allOptions = select.getOptions();
        for (WebElement eachOption : allOptions) {
            System.out.println(eachOption);
            System.out.println(eachOption.getText());
            System.out.println("<======================================>");
        }

//      Print the total number of options in the dropdown
        int numberOfOption = allOptions.size(); //ACTUAL 3
        System.out.println("Total number of options : " + allOptions.size());


//      Check if Appliances is a drop-down option. Print true if “Appliances” is an option.
//      Print false otherwise.

        boolean found = false;
        for (WebElement eachDropdown : allOptions)
            if (eachDropdown.getText().contains("Appliances")) {
                found = true;
                System.out.println("true");
            }
        if (!found) {
            System.out.println("false");
        }

//        BONUS: Check if the dropdown is in Alphabetical Order
        List<String> originalList = new ArrayList();
        for (WebElement e : allOptions) {
            originalList.add(e.getText());
        }

   //     Set<String> treeset = new TreeSet(originalList);
            List<String> tempList = originalList;
            Collections.sort(tempList);
            //Assert.assertEquals(originalList,tempList);

            boolean ifSortedAscending = originalList.equals(tempList);
            if (ifSortedAscending) {
                System.out.println("Dropdown is in Alphabetical Order");
            } else {
                System.out.println("Dropdown is  not in Alphabetical Order.");


        }
    }


}





