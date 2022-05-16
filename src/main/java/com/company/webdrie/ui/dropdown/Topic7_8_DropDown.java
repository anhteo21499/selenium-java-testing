package com.company.webdrie.ui.dropdown;

import com.company.webdrie.ui.base.BaseWebdriverUbuntu;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Topic7_8_DropDown extends BaseWebdriverUbuntu {

    @SneakyThrows
    @Test(description = "xử lí dropdown líst topic 7 và 8 ")
    public void TC6() {

        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        By numberLC = By.cssSelector("#number-button");
        By commonItemLC = By.cssSelector(".ui-menu-item");
        CustomSelectItemDropdown.selectItemInDropDown(driver, numberLC, commonItemLC, "19");
        Thread.sleep(3000);
    }

}
