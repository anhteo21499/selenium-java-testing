package com.company.webdrie.ui;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VerifyPageTest {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://live.techpanda.org/");
    }

    @Test
    @SneakyThrows
    public void TC1() {
        clickHandler(driver, "div.footer div.links ul li.first a[title ^='My Account']");
        Thread.sleep(3000);
        String urlTo = "http://live.techpanda.org/index.php/customer/account/login/";
        Assert.assertEquals(driver.getCurrentUrl(), urlTo);
        Thread.sleep(3000);
        urlTo = "http://live.techpanda.org/index.php/customer/account/create/";
        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), urlTo);
    }

    @Test
    public void verifyTitle() {
        clickHandler(driver, "div.footer div.links ul li.first a[title ^='My Account']");
        Assert.assertEquals(driver.getTitle(),"Customer Login");
        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
    }

    @Test()
    public void handleUrlPage() {
        clickHandler(driver, "div.footer div.links ul li.first a[title ^='My Account']");
        clickHandler(driver, "a[title='Create an Account']");
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
        driver.navigate().forward();
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

    }

    @Test
    public void verifyPageSource() {
        clickHandler(driver, "div.footer div.links ul li.first a[title ^='My Account']");
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Login or Create an Account"));
        clickHandler(driver, "a[title='Create an Account']");
        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
    }



    public void clickHandler(WebDriver webDriver, String pathElementByCss) {
        driver.findElement(By.cssSelector(pathElementByCss)).click();
    }

}
