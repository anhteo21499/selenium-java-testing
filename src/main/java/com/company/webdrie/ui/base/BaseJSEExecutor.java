package com.company.webdrie.ui.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseJSEExecutor {
    WebDriver driver;
    JavascriptExecutor javascriptExecutor;

    public Object executeForBrowser(String nativeQuery) {
        return javascriptExecutor.executeScript(nativeQuery);
    }

    /**
     * chuyển trang sử dụng js
     *
     * @param url
     */
    public void navigatePageByUrl(String url) {
        javascriptExecutor.executeScript("window.location = ''" + url + "'");
    }

    /**
     * click element by locator xpath
     *
     * @param locator
     */
    public void clickToElement(String locator) {
        javascriptExecutor.executeScript("arguments[0].click();", getElement(locator));
    }

    /**
     * cuộn để thẻ lên đầu trang
     *
     * @param locator
     */
    public void scrollElementTop(String locator) {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    /**
     * cuộn đến thẻ xuống cuối trang
     *
     * @param locator
     */
    public void scrollElementDown(String locator) {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

    /**
     * xóa thuộc tính của thẻ
     *
     * @param locator
     * @param attribute
     */
    public void removeAttribute(String locator, String attribute) {
        javascriptExecutor.executeScript("arguments[0].removeAttribute('" + attribute + "');", getElement(locator));
    }

    /**
     * send dữ liệu vào thẻ value
     * @param locator
     * @param value
     */
    public void sendKeyToElement(String locator, String value) {
        javascriptExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    /**
     * find element by xpath
     *
     * @param xpath
     * @return
     */
    public WebElement getElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }


}