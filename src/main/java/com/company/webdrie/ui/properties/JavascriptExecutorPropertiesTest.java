package com.company.webdrie.ui.properties;

import com.company.webdrie.ui.base.BaseWebdriverWindow;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class JavascriptExecutorPropertiesTest  extends BaseWebdriverWindow {
    Properties properties = new Properties();

    @BeforeClass
    public void getPage() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
    }

    @Test
    @SneakyThrows
    public void TC111() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.getElementsByName('submit').click();");
//        js.executeScript("document.getElementsByName('submit').click();");
        WebElement buttonLogin = driver.findElement(By.name("submitt"));
        js.executeScript("arguments[0].click();", buttonLogin);
        Actions actions = new Actions(driver);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(By.name("submit")));
    }

    @AfterMethod
    @SneakyThrows
    public void takeScreenShot(ITestResult iTestResult) {
        loadProperties();
        String pathSaveScreenShot = properties.getProperty("PATH-FILE-TAKE-SCREEN-SHOT" ,
                projectPath + File.separator +  "image" + File.separator);
        System.out.println("day la duong dan" + pathSaveScreenShot);
        if(iTestResult.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(source, new File(pathSaveScreenShot + iTestResult.getName() + ".png"));
        }
    }

    @SneakyThrows
    private void loadProperties() {
        String fileName = "./conf/conf";
        FileInputStream propsFile = new FileInputStream(fileName);
        properties.load(propsFile);
    }
}
