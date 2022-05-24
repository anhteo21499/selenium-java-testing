package com.company.webdrie.ui.test;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test1 {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", projectPath + "/gecko_driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.manage().window().maximize();
        jsExecutor = (JavascriptExecutor) driver;
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    @SneakyThrows
    public void TC_02_Google_Docs() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        driver.findElement(By.cssSelector("input[type = 'submit']")).click();
    }
}
