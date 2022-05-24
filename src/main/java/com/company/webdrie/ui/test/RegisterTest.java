package com.company.webdrie.ui.test;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegisterTest {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", projectPath + "/gecko_driver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test(description = "Register with empty data")
    public void TC1() {
        // Login Page Url matching
        driver.findElement(By.xpath("//div[@class='field_btn']//button[@type='submit']")).click();
        var textTxtFirstname = driver.findElement(By.xpath("//div[@class='field']//label[@id='txtFirstname-error']")).getText();
        Assert.assertEquals("vui lòng nhập họ tên".toLowerCase(), textTxtFirstname.toLowerCase());
        // các element khác tương tự
    }

    @SneakyThrows
    @Test(description = "Register with invalid email")
    public void TC2() {
        driver.findElement(By.id("txtFirstname")).sendKeys("JAVA_SELENIUM");
        driver.findElement(By.id("txtPassword")).sendKeys("SELENIUM_25");
        driver.findElement(By.id("txtCPassword")).sendKeys("SELENIUM_25");
        driver.findElement(By.id("txtPhone")).sendKeys("0966043338");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='field_btn']//button[@type='submit']")).click();
    }

    // các t case khasc tuowng tu

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
