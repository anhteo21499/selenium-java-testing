package com.company.webdrie.ui.window;

import com.company.webdrie.ui.base.BasePage;
import com.company.webdrie.ui.base.BaseWebdriverUbuntu;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;


public class WindowHandlerTest extends BaseWebdriverUbuntu {

    private final BasePage basePage = new BasePage();

    @SneakyThrows
    @Test
    public void TC1() {
        String googleTitle = "Google";
        String facebookTitle = "Facebook – log in or sign up";
        String tikiTitle = "Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh";
        driver.get("https://automationfc.github.io/basic-form/index.html");
        String webBaseId = driver.getWindowHandle();

        WebElement googleEL = driver.findElement(By.cssSelector("a[href = 'https://google.com.vn']"));
        WebElement facebookEl = driver.findElement(By.cssSelector("a[href = 'https://facebook.com']"));
        WebElement tikiEL = driver.findElement(By.cssSelector("a[href = 'https://tiki.vn']"));

        googleEL.click();
        Thread.sleep(1000);
        Assert.assertTrue(basePage.checkTitleExistPage(driver, googleTitle));
        driver.close();

        // switch home page
        driver.switchTo().window(webBaseId);

        Thread.sleep(2000);
        facebookEl.click();
        Assert.assertTrue(basePage.checkTitleExistPage(driver, facebookTitle));
        driver.close();

        Thread.sleep(2000);
        // switch home page
        driver.switchTo().window(webBaseId);

        tikiEL.click();
        Assert.assertTrue(basePage.checkTitleExistPage(driver, tikiTitle));
        driver.close();
    }



}
