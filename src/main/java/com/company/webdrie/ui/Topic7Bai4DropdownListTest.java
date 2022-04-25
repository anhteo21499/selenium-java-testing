package com.company.webdrie.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic7Bai4DropdownListTest {
    private WebDriver driver;
    private final String projectPath = System.getProperty("user.dir");
    private final Random random = new Random();
    List<WebElement> options;
    Select selection;

    @BeforeTest
    public void beforeTest() {
        // use File.separator to get path with Operating System
        // window : \ - linux : /
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register");
    }

    @Test
    public void testDropdown() {
        driver.findElement(By.cssSelector("div.header-links li:first-child")).click();
        WebElement dayPath = driver.findElement(By.name("DateOfBirthDay"));
        selection = new Select(dayPath);
        options = selection.getOptions();
        Assert.assertEquals(options.size(), 32);
        selection.selectByVisibleText("1");
//        c2 : dduyệt option tìm giá trị text với giá trị cần tìm và chọn nó
//        for(int i = 0; i < options.size(); i++) {
//            if(options.get(i).getText().equals("1"))
//                selection.selectByIndex(i);
//        }
        WebElement monthPath = driver.findElement(By.name("DateOfBirthMonth"));
        selection = new Select(monthPath);
        options  = selection.getOptions();
        Assert.assertEquals(options.size(), 13);
        selection.selectByVisibleText("May");

        WebElement yearPath = driver.findElement(By.name("DateOfBirthYear"));
        selection = new Select(yearPath);
        options  = selection.getOptions();
        System.out.printf("year size" + options.size());
        Assert.assertEquals(options.size(), 112);
        selection.selectByVisibleText("1980");

    }
}
