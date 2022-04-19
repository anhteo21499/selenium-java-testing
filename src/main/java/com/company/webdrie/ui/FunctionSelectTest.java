package com.company.webdrie.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FunctionSelectTest {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @BeforeTest
    public void beforeTest() {
        // use File.separator to get path with Operating System
        // window : \ - linux : /
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
    }

    @Test
    public void testCase1() {
        WebElement companySize = driver.findElement(By.name("country"));
        Select selectCompanySize = new Select(companySize);
        System.out.println("check có được chọn multil option không " + selectCompanySize.isMultiple());
        List<WebElement> options = selectCompanySize.getOptions();
        for (int i = 0; i < options.size(); i++) {
            if (i == 2 || i == 4) {
                selectCompanySize.selectByIndex(i);
                System.out.println("option đã được chọn là " + options.get(i).getText());
                System.out.println("vị trí là : " + i );
                break;
            }

        }

        int index = 0;
        for (WebElement option : options) {
            if (option.isSelected()) {
                System.out.println("option đã được chọn là " + option.getText());
                System.out.println("vị trí là : " + (index+1));
                break;
            }
        }


        List<WebElement> optionSelectionAll = selectCompanySize.getAllSelectedOptions();
        for (WebElement option : optionSelectionAll) {
            if (option.isSelected()) {
                System.out.println("các element đã được chọn là : " + option.getText());
                break;
            }
        }

        System.out.println("\n");
        int index1 = 0;
        List<WebElement> optionAll = driver.findElements(By.tagName("option"));
        for (WebElement option : optionAll) {
            System.out.println("Giá trị thứ" + index1 + " là :" + option.getText());
            System.out.println("Giá trị khi get attribute là : " + index1 + " là :" + option.getAttribute("value"));
            index1++;
        }



    }
}
