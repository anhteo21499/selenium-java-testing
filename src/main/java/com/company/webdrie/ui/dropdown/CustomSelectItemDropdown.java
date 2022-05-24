package com.company.webdrie.ui.dropdown;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CustomSelectItemDropdown {

    @SneakyThrows
    public static void selectItemInDropDown(WebDriver driver, By parentLC, By childLC, String expectedText) {
        WebElement parentDropDown = driver.findElement(parentLC);
        parentDropDown.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(childLC));
        List<WebElement> allItemDropDown = driver.findElements(childLC);
        for (WebElement element : allItemDropDown) {
            if (expectedText.contains(element.getText())) {
                element.click();
                break;
            }
        }
        Thread.sleep(3000);
    }


    @SneakyThrows
    public static void selectItemInDropDownSelection(WebDriver driver, By selectionLC, String expectedText) {
        WebElement selectionDropDown = driver.findElement(selectionLC);
        Select select = new Select(selectionDropDown);
        List<WebElement> countryOption = select.getOptions();
        for (WebElement element : countryOption) {
            if (expectedText.equalsIgnoreCase(element.getText())) {
                element.click();
                break;
            }
        }
        Thread.sleep(3000);
    }
}
