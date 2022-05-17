package com.company.webdrie.ui.action;

import com.company.webdrie.ui.base.BaseWebdriverUbuntu;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic10Test extends BaseWebdriverUbuntu {

    public WebDriverWait wait;
    public Actions actions;

    @SneakyThrows
    @Test
    public void TC1() {
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        wait = new WebDriverWait(driver, 10);
        WebElement ageElement = driver.findElement(By.cssSelector("#age"));

        actions = new Actions(driver);

        actions.moveToElement(ageElement).perform();

        WebElement toolTip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ui-tooltip-content")));
        Assert.assertTrue(toolTip.getText().equalsIgnoreCase("We ask for your age only for statistical purposes."));
    }

    @Test
    @SneakyThrows
    public void TC2() {
        driver.get("http://www.myntra.com/");
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[@data-group = 'kids']"))).perform();
        WebElement socksEL = driver.findElement(By.xpath("(//a[@class='desktop-categoryLink'][normalize-space()='Socks'])[2]"));
        String urlHome = driver.getCurrentUrl();
        socksEL.click();
        Assert.assertFalse(urlHome.equalsIgnoreCase(driver.getCurrentUrl()));
    }
}
