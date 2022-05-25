package com.company.webdrie.ui.youtube;

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

public class HandleMultipleWindowsTest {
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
    public void testCase1() {
        String urlHome = driver.getWindowHandle();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("span[class = 'ribbon-topnav ws-hide-1066']")).click();
        Thread.sleep(3000);
        Set<String> windowCurrent = driver.getWindowHandles();
        System.out.printf(windowCurrent.toString());
        Thread.sleep(3000);
        driver.switchTo().window(urlHome);

        Actions actions = new Actions(driver);
        WebElement tryItWeb = driver.findElement(By.xpath("//a[@href ='tryit.asp?filename=trycss_tooltip']"));
        actions.moveToElement(tryItWeb).click().perform();
        Thread.sleep(3000);
        WebElement runBtn = driver.findElement(By.id("runbtn"));
        actions.moveToElement(runBtn);
    }

    public void waitForElement(int seconds, String waitConditionLocator){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(waitConditionLocator)));
    }
}
