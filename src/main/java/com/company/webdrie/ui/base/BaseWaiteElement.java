package com.company.webdrie.ui.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWaiteElement {

    public static void waitForElement(WebDriver driver, int seconds, By elementLocator) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public static void waitClickElement(WebDriver driver, int seconds, By elementLocator) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }

}
