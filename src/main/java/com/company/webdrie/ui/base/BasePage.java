package com.company.webdrie.ui.base;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Set;


public class BasePage {
    public boolean checkTitleExistPage(WebDriver driver, String title) {
        Set<String> urlIds = driver.getWindowHandles();
        for (String item : urlIds) {
            driver.switchTo().window(item);
            if (driver.getTitle().contains(title.trim())) {
                return true;
            }
        }
        return false;
    }

    @SneakyThrows
    public void sleepThread(int miniSecond) {
        Thread.sleep(miniSecond);
    }
}
