package com.cydeo.Bootcamp;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;

public class BasicNavigationWithTestNG {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        //setup and create browser driver
        driver= WebDriverFactory.getDriver(ConfigurationReader.get("browser"));

        //navigate to the web page
        driver.get(ConfigurationReader.get("webTable.url"));

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void Test1(){

        System.out.println(driver.findElement(By.name("username")).getLocation()); //(128, 261) x and y coordinate of the web element in the page

        System.out.println(driver.findElement(By.name("username")).getSize());  //(618, 48) length height

        //to send value we use sendKeys
        driver.findElement(By.name("username")).sendKeys(ConfigurationReader.get("webTable.userName"));

        driver.findElement(By.name("password")).sendKeys(ConfigurationReader.get("webTable.pw"));


        driver.findElement(By.xpath("//button[.='Login']")).click();
        // driver.findElement(By.name("password")).sendKeys(ConfigurationReader.get("webTable.pw"), Keys.ENTER);  //easier

        String expectedUrl = "https://web-table-2.cydeo.com/orders";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl,"URL is not as expected");



    }


}
