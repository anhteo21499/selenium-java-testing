package com.company.webdrie.ui.test;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic7Bai1Test {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    Random random = new Random();

    @BeforeTest
    public void beforeTest() {
        // use File.separator to get path with Operating System
        // window : \ - linux : /
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/v4");
    }

    @Test
    @SneakyThrows
    public void TestCase1() {
        driver.findElement(By.xpath("//a[text()='here']")).click();
        driver.findElement(By.name("emailid")).sendKeys("anh@gmail.com");
        driver.findElement(By.name("btnLogin")).click();
        Thread.sleep(2000);
        String username = driver.findElement(By.xpath("//td[text()= 'User ID :' and @class = 'accpage']/following-sibling::td")).getText();
        String password = driver.findElement(By.xpath("//td[text()= 'Password :' and @class = 'accpage']/following-sibling::td")).getText();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().back();

        // set username and pass
        driver.findElement(By.name("uid")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("btnLogin")).click();

        // click create new account
        driver.findElement(By.xpath("//a[text() = 'New Customer']")).click();

        // mock data new account
        String customerName = "Selenium online";
        String gender = "male";
        String dateOfBirth = "10/01/2000";
        String address = "18 Lê Văn Lương";
        String city = "HN";
        String state = "Mb Bank";
        String pin = "123456";
        String mobileNumber = "0966043338";
        String email = "nguyenquocanh" + random.nextInt(1000) + "@gmail.com";
        String passwordMock = "anhteo";

        // enter info create account
        driver.findElement(By.name("name")).sendKeys(customerName);
        driver.findElement(By.cssSelector("input[name = 'rad1'][value='m']")).isEnabled();
        driver.findElement(By.cssSelector("input[name = 'dob']")).sendKeys(dateOfBirth);
        driver.findElement(By.cssSelector("textarea[name = 'addr']")).sendKeys(address);
        driver.findElement(By.cssSelector("input[name = 'city']")).sendKeys(city);
        driver.findElement(By.cssSelector("input[name = 'state']")).sendKeys(state);
        driver.findElement(By.cssSelector("input[name = 'pinno']")).sendKeys(pin);
        driver.findElement(By.cssSelector("input[name = 'telephoneno']")).sendKeys(mobileNumber);
        driver.findElement(By.cssSelector("input[name = 'emailid']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name = 'password']")).sendKeys(passwordMock);
        driver.findElement(By.cssSelector("input[type = 'submit']")).click();


    }


    private String formatText(String text) {
        return text.trim();
    }

    private Boolean checkContainText(String chain, String keyContain) {
        return chain.contains(keyContain);
    }
}
