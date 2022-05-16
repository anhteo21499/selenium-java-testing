package com.company.check;

import com.company.webdrie.ui.base.BaseWebdriverUbuntu;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class CompareClickAction extends BaseWebdriverUbuntu {

    @Test
    public void compare() throws InterruptedException {
//        driver.get("https://demo.guru99.com/test/newtours/register.php");
//        WebElement submitBtn = driver.findElement(By.cssSelector("input[name = 'submit']"));
        Actions actions = new Actions(driver);
//        actions.click(submitBtn);
//        submitBtn.click();


        driver.get("https://tiemchungcovid19.gov.vn/portal/portal-report");

        List<WebElement> arrL = driver.findElements(By.cssSelector("input[placeholder= 'Số lô']"));

        WebElement aLast = arrL.get(2);

//        aLast.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", aLast);
        aLast.sendKeys("123");
        Thread.sleep(3000);
        aLast.click();
//        actions.click(aLast);
    }
}
