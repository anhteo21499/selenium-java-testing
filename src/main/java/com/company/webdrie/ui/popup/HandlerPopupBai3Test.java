package com.company.webdrie.ui.popup;

import com.company.webdrie.ui.base.BaseWebdriverUbuntu;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlerPopupBai3Test extends BaseWebdriverUbuntu {

    public WebDriverWait wait;

    @SneakyThrows
    @Test
    public void TC1() {
        driver.get("https://vnk.edu.vn/");
        By popupLC = By.cssSelector("#tve-p-scroller");
        Assert.assertFalse(driver.findElement(popupLC).isDisplayed());

        // chờ popup xuất hiện
        waitForElement(20, popupLC);
        // chờ iframe xuất hiện
        waitForElement(20, By.xpath("//iframe[@data-testid='dialog_iframe']"));

        Assert.assertTrue(driver.findElement(popupLC).isDisplayed());

        // thực hiện chuyển qua iframe để thao tác và click tắt nó đi
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@data-testid='dialog_iframe']"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.xpath("//div[@aria-label='đóng']")).click();

        // chuyển về màn hình chính và thực hiện đóng popup
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//div[contains(@class,'tve_ea_thrive_leads_form_close')]")).click();

        Thread.sleep(2000);
        Assert.assertFalse(driver.findElement(popupLC).isDisplayed());

    }

    public void waitForElement(int seconds, By elementLocator){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public void waitClickElement(int seconds, By elementLocator){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }


}
