package com.company.webdrie.ui.popup;

import com.company.webdrie.ui.base.BaseWaiteElement;
import com.company.webdrie.ui.base.BaseWebdriverUbuntu;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RandomPopupTest extends BaseWebdriverUbuntu {

    @SneakyThrows
    @Test
    public void TC1() {
        driver.get("https://dehieu.vn/");
        By popupLC = By.cssSelector("div.popup-content");
        By closeLC = By.cssSelector("button.close");
        By iframeLC = By.xpath("//iframe[@data-testid='dialog_iframe']");

        BaseWaiteElement.waitForElement(driver, 10, popupLC);
        BaseWaiteElement.waitForElement(driver, 25, iframeLC);


        driver.switchTo().frame(driver.findElement(iframeLC));

        if(driver.findElements(By.xpath("//div[@aria-label='đóng']")).size() > 0) {
            driver.findElement(By.xpath("//div[@aria-label='đóng']")).click();
        }

        driver.switchTo().defaultContent();

        driver.findElement(closeLC).click();
    }
}
