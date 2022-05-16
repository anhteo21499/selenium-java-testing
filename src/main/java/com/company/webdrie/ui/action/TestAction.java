package com.company.webdrie.ui.action;

import com.company.webdrie.ui.base.BaseWebdriverUbuntu;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestAction extends BaseWebdriverUbuntu {

    @SneakyThrows
    @Test(description = " kiểm tra function Actions có tự động cuộn khi click element không")
    public void TC1() {
        driver.get("https://www.thegioididong.com/");

        By policyLC = By.xpath("//a[text() ='Tuyển dụng']");
//
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i.vieclam-closepopup"))).click();


        actions.click(driver.findElement(policyLC)).perform();
//        driver.findElement(policyLC).click();
//        Thread.sleep(3000);
    }

    @SneakyThrows
    @Test
    public void TC2() {
        driver.get("https://vieclam.thegioididong.com/");
        By bachoaLC = By.cssSelector("i.vieclam-chainbhx");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i.vieclam-closepopup"))).click();

        Actions actions = new Actions(driver);
        actions.click(driver.findElement(bachoaLC)).perform();
//        driver.findElement(bachoaLC).click();
    }
}
