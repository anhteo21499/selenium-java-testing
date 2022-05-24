package com.company.webdrie.ui.iframe;

import com.company.webdrie.ui.base.BaseWebdriverUbuntu;
import com.company.webdrie.ui.dropdown.CustomSelectItemDropdown;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HandlerIFrameBai7Test extends BaseWebdriverUbuntu {

    @SneakyThrows
    @Test
    public void TC1() {
        driver.get("https://kyna.vn/");
        List<WebElement> iframeFB = driver.findElements(By.cssSelector("div.face-content > iframe"));
        Assert.assertTrue(iframeFB.size() > 0);

        driver.switchTo().frame(driver.findElement(By.cssSelector("div.face-content > iframe")));

        String numberLike = driver.findElement(By.cssSelector("div._1drq")).getText();
        System.out.printf(numberLike);
        Assert.assertTrue(numberLike.contains("167K"));

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.cssSelector("#cs_chat_iframe")));
        driver.findElement(By.xpath("//div[contains(@class , 'border_overlay meshim_widget_widgets_BorderOverlay')]")).click();

        driver.findElement(By.cssSelector("input[ng-model='login.username']")).sendKeys("anhteo");
        driver.findElement(By.cssSelector("input[ng-model='login.phone']")).sendKeys("0966046668");

        WebElement dropdownServiceEL = driver.findElement(By.cssSelector("select#serviceSelect"));

        CustomSelectItemDropdown.selectItemInDropDown(driver, By.cssSelector("select#serviceSelect "), By.cssSelector("select#serviceSelect > option"), "HỖ TRỢ KỸ THUẬT");
    }

}
