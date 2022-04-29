package com.company.webdrie.ui.base;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseWebdriverWindow {

    public WebDriver driver;
    public String projectPath = System.getProperty("user.dir");

    @BeforeTest
    public void beforeTest() {
        // use File.separator to get path with Operating System
        // window : \ - linux : /
        System.setProperty("webdriver.chrome.driver", "E:\\Nga_Project\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @SneakyThrows
    @AfterTest
    public void afterTest() {
        Thread.sleep(5000);
        driver.close();
    }
}
