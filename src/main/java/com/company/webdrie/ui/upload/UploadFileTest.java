package com.company.webdrie.ui.upload;

import com.company.webdrie.ui.base.BaseWebdriverUbuntu;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class UploadFileTest extends BaseWebdriverUbuntu {

    private final String urlBase = System.getProperty("user.dir");

    /**
     * upload file using Robot of java
     */
    @SneakyThrows
    @Test
    public void TC1() {
        StringSelection fileUpload = new StringSelection(urlBase + File.separator + "file" + File.separator + "test");
        Robot robot = new Robot();
        driver.get("https://smallseotools.com/plagiarism-checker/");
        driver.findElement(By.cssSelector("label[for ='fileUpload']")).click();
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileUpload, null);
        // action event
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(2000);
        // release button keyboard
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        // enter to get file
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
    }

    /**
     * upload file using sendKeys
     */
    @SneakyThrows
    @Test
    public void TC2() {
        // thay file để upload
        String imageFile = urlBase + File.separator + "file" + File.separator + "testfile.doc";
        System.out.println(imageFile);
        driver.get("https://smallseotools.com/plagiarism-checker/");
        driver.findElement(By.cssSelector("input#fileUpload")).sendKeys(imageFile);
        Thread.sleep(5000);
    }

    /**
     * screenshot after each test case
     */
    @SneakyThrows
    @AfterMethod
    public void screenShotTest() {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File fileScreenShot = screenshot.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(fileScreenShot, new File(urlBase + File.separator + "file" + File.separator + Math.random() + ".png"));
    }
}
