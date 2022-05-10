package com.company.youtube;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ManagerWaitTest {
    private WebDriver driver;
    private final String projectPath = System.getProperty("user.dir");

    @BeforeTest
    public void beforeTest() {
        // use File.separator to get path with Operating System
        // window : \ - linux : /
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/css/css_tooltip.asp");
    }

    @Test
    @SneakyThrows
    public void implicitWait() {
//         wait này áp dụng cho tất cả các chức năng tìm kiếm đợi element
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @SneakyThrows
    public void explicitWait() {
//         wait này áp dụng cho tất cả các chức năng tìm kiếm đợi element
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                (By.cssSelector("span[class = 'ribbon-topnav ws-hide-1066']")))).click();
    }


}
