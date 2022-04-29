package com.company.webdrie.ui;

import com.company.webdrie.ui.base.BaseWebdriverWindow;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class JavascriptExecutorTest extends BaseWebdriverWindow {

    @BeforeClass
    public void getPage() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
    }
    @Test
    @SneakyThrows
    public void TC1() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.getElementsByName('submit').click();");
//        js.executeScript("document.getElementsByName('submit').click();");
        WebElement buttonLogin = driver.findElement(By.name("submit"));
        js.executeScript("arguments[0].click();", buttonLogin);
        Actions actions = new Actions(driver);
        System.out.println(projectPath);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(By.name("submit")));
    }

    @AfterMethod
    @SneakyThrows
    public void takeScreenShot(ITestResult iTestResult) {
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(source, new File(projectPath + File.separator +  "image" + File.separator + iTestResult.getName() + ".png"));
        }
    }
}
