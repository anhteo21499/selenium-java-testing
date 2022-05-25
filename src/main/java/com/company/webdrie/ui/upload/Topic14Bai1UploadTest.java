package com.company.webdrie.ui.upload;

import com.company.webdrie.ui.base.BaseWebdriverUbuntu;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

public class Topic14Bai1UploadTest extends BaseWebdriverUbuntu {

    private final String urlBaseSource = System.getProperty("user.dir");

    /**
     * upload file using method sendKeys of selenium
     */
    @SneakyThrows
    @Test
    public void TC1() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        String urlFile1 = urlBaseSource + File.separator + "file" + File.separator + "test.png";
        String urlFile2 = urlBaseSource + File.separator + "file" + File.separator + "SELENIUM.png";
        System.out.printf(urlFile1);
        driver.findElement(By.cssSelector("input[type = 'file']")).sendKeys(urlFile1 + "\n" + urlFile2);
        Thread.sleep(5000);
    }
}
