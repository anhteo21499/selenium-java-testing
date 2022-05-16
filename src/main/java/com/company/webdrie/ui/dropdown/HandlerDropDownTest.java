package com.company.webdrie.ui.dropdown;

import com.company.webdrie.ui.base.BaseWebdriverUbuntu;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class HandlerDropDownTest extends BaseWebdriverUbuntu {

    WebDriverWait wait;
    @SneakyThrows
    @Test
    public void TC_01() {
        driver.get("https://tiemchungcovid19.gov.vn/portal/register-person");
        By provinceSelectionLC = By.cssSelector("ng-select[bindvalue='provinceCode']");
        By provinceOptionLC = By.cssSelector("div[role ='option']");
        selectItemInDropDown(provinceSelectionLC, provinceOptionLC, "Tỉnh Bình Phước");
    }
    @SneakyThrows
    @Test
    public void TC_02() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        By countryLC = By.cssSelector("select[name = 'country']");
        selectItemInDropDownSelection(countryLC, "BARBADOS");
    }



    @SneakyThrows
    public void selectItemInDropDown(By parentLC, By childLC, String expectedText) {
        WebElement parentDropDown = driver.findElement(parentLC);
        parentDropDown.click();
        wait = new WebDriverWait(driver, 5);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(childLC));
        List<WebElement> allItemDropDown = driver.findElements(childLC);
        for (WebElement element : allItemDropDown) {
            if (expectedText.equalsIgnoreCase(element.getText())) {
                element.click();
                break;
            }
        }
        Thread.sleep(3000);
    }


    @SneakyThrows
    public void selectItemInDropDownSelection(By selectionLC, String expectedText) {
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
