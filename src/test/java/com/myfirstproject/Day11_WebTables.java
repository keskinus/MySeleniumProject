package com.myfirstproject;

import com.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class Day11_WebTables extends TestBase {
    @Test
    public void printEntireTable() {
        //as a single element
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***Print Table Data***");
        WebElement entireTable = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(entireTable.getText());

    }

    @Test
    public void getRows() {
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***Print Table Rows***");
        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
        int rowNum = 1;
        for (WebElement eachRow : tableRows) {
            System.out.println("Row Number" + rowNum + " => " + eachRow.getText());
            rowNum++;
        }
    }

    @Test
    public void getRow3() {
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***3rd Row***");
        WebElement row3 = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[3]"));
        System.out.println(row3.getText());
    }

    @Test
    public void getCellData() {
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***All Table Data***");
        int dataNumber = 1;
        List<WebElement> allCellData = driver.findElements(By.xpath("//table[@id='table1']//tbody//td"));
        for (WebElement eachCellData : allCellData) {
            System.out.println("Data number " + dataNumber + " => " + eachCellData.getText());
            dataNumber++;
            System.out.println();
        }


    }

    @Test
    public void getCellData1() {
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***All Table Data***");
        List<WebElement> allCellData = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
        for (WebElement eachCellData : allCellData) {
            System.out.println(eachCellData.getText());
            System.out.println();
        }
    }

    @Test
    public void getColumns() {
        //get column 5
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***5th ColumnData***");
        List<WebElement> column5Data = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        for (WebElement columnData : column5Data) {
            System.out.println(columnData.getText());
        }


    }
    //Create a printCellData method
    //printData(2,3)  => 2nd row 3rd column => "//table[@id='table1']//tbody//tr[2]//td[3]"
    //printData (1,4) => 1st row 4th column => "//table[@id='table1']//tbody//tr[1]//td[4]"

    public void printCellData(int row, int column){
        try {
            String dynamicXpath = "//table[@id='table1']//tbody//tr[" + row + "]//td[" + column + "]";
            WebElement cellData = driver.findElement(By.xpath(dynamicXpath));
            System.out.println(cellData.getText());
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
    }
    @Test
    public void printCellTest(){
        driver.get("https://the-internet.herokuapp.com/tables");
        printCellData(3,2);

    }
//  Get the first column data(Lastname)
// And verify the list is not in aphabetical order

    @Test
    public void printFirstColData() {
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***1th ColumnData***");
        List<WebElement> column1Data = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[1]"));

        List<String> originalList = new ArrayList();
        for (WebElement e : column1Data) {
            originalList.add(e.getText());}
        Set<String> treeset = new TreeSet(originalList);
        Assert.assertFalse("List is  not in Alphabetical Order.",originalList.equals(treeset));

//        boolean ifSortedAscending = originalList.equals(treeset);
//        if (ifSortedAscending) {
//            System.out.println("List is in Alphabetical Order");
//        } else {
//            System.out.println("List is  not in Alphabetical Order.");
//
//        }
//
//        List<String> list = new ArrayList<>();
//        for(WebElement columnData : column1Data){
//            list.add(columnData.getText());
//        }

//        List<String> temp = new ArrayList<>(originalList);
//        originalList.sort(Comparator.comparing(String::toUpperCase));
//        System.out.println(originalList);
//        Assert.assertFalse(originalList.equals(temp));

    }
    }








