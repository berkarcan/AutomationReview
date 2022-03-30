package com.cydeo.Bootcamp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumReview {
    public static void main(String[] args) throws InterruptedException {

        //1.setup browser driver
        WebDriverManager.chromedriver().setup();
        //2.create driver object: opens an empty browser
        WebDriver driver = new ChromeDriver();
        //3. navigate to the web page
        driver.get("https://web-table-2.cydeo.com/login");

        //maximize the window
        driver.manage().window().maximize();

        //wait for 2 s static waiting
        Thread.sleep(3000);

        //get the title of the page
        String expectedTitle = "Cydeo Web Table App";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title test passed");
        } else {
            System.out.println("actualTitle: "+actualTitle + " is different from " + "expectedTitle:"+expectedTitle);

        }

    }
}