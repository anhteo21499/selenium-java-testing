package com.company.webdrie.ui.test;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://live.techpanda.org/");
    }

    @SneakyThrows
    @Test(description = "Register with empty data")
    public void TC1() {
        // Login Page Url matching
        driver.findElement(By.xpath("//div[@class='account-cart-wrapper']/child::a[1]")).click();
        Thread.sleep(300);
        driver.findElement(By.xpath("//div[@class='links']//a[contains(text(), 'My Account')][1]")).click();
        driver.findElement(By.xpath("//button[@title='Login']")).click();
    }

    @SneakyThrows
    @Test(description = "Register with invalid email")
    public void TC2() {

    }

    // các t case khasc tuowng tu

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
