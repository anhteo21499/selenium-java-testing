package com.company.topic9;

import com.company.webdrie.ui.base.BaseWebdriverUbuntu;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bai1 extends BaseWebdriverUbuntu {

    @Test
    @SneakyThrows
    public void TC1() {
        driver.get("https://www.fahasa.com/customer/account/create");
        By loginLocator = By.cssSelector("li.popup-login-tab-login");
        By userNameLC = By.cssSelector("#login_username");
        By passLC = By.cssSelector("#login_password");
        By submitLoginLC = By.className("fhs-btn-login");

        WebElement loginBtn = driver.findElement(loginLocator);

        loginBtn.click();

        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // remove thuộc tính ẩn nút > hiển thị cái nút lên
        js.executeScript("arguments[0].removeAttribute('disabled');", driver.findElement(submitLoginLC));

//        Assert.assertFalse(driver.findElement(submitLoginLC).isEnabled());

        driver.findElement(userNameLC).sendKeys("nguyenquocanh20499@gmail.com");
        driver.findElement(passLC).sendKeys("AnhTeo99");

        Assert.assertTrue(driver.findElement(submitLoginLC).isEnabled());
//        verify button đăng nhập màu đỏ
        String backColor = loginBtn.getCssValue("background-color");
        System.out.printf(backColor);

        String colorSubmitHex = Color.fromString(backColor).asHex();

        System.out.printf("color" + colorSubmitHex);

    }
}
