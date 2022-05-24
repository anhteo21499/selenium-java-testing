package com.company.webdrie.ui.window;

import com.company.webdrie.ui.base.BaseWebdriverUbuntu;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WindowHandlerTest extends BaseWebdriverUbuntu {

    @SneakyThrows
    @Test
    public void TC1() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement googleEL = driver.findElement(By.cssSelector("a[href = 'https://google.com.vn']"));
        WebElement facebookEl = driver.findElement(By.cssSelector("a[href = 'https://facebook.com']"));
        WebElement tikiEL = driver.findElement(By.cssSelector("a[href = 'https://tiki.vn']"));


    }
}
