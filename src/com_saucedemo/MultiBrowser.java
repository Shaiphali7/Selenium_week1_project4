package com_saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {
    static String browser = "Edge";
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;


    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wronge browser name");
        }

        driver.get(baseUrl);
        //Maximise Browser
        driver.manage().window().maximize();
        // giving Implicit wait to Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//Printing the title of page
        System.out.println("Title of the page: " + driver.getTitle());
//Printing the current Url
        System.out.println("Current Url is: " + driver.getCurrentUrl());
        //Printing Source code
        System.out.println("Source code of page: " + driver.getPageSource());
        //Adding the value in UserField
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("123@gmail.com");
        //Adding the value in Password
        driver.findElement(By.name("password")).sendKeys("1234#");
//Closing the browser
        driver.close();
    }
}
