package com.company.webdriver;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LocatorTopic08 {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        // System.setProperty("webdriver.gecko.driver", projectPath + "/gecko_driver/geckodriver");
        // driver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.driver", projectPath + "/chromedriver");
        driver = new ChromeDriver();

        // set thời gian chờ tìm element cho cả project
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    @SneakyThrows
    public void TestCase1() {
        driver.findElement(By.id("email")).sendKeys("dam@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.name("login")).click();
        Thread.sleep(5000);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }


}
