package com.company;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAsserts {

    @Test
    public void RunTestAssert() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        String driverPath = "/home/anh/Documents/SELE2/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);

        //Khai báo đối tượng của SoftAssert
        SoftAssert softassert = new SoftAssert();

        driver.get("https://crm.anhtester.com/signin");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        //Login account
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin02@mailinator.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);

        //Chọn menu Client và nhấn Add button
        driver.findElement(By.xpath("//span[text()='Clients']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='Add client']")).click();
        Thread.sleep(1000);

        //Kiểm tra giá trị Header dialog Add Client
        WebElement header = driver.findElement(By.xpath("//h4[@id='ajaxModalTitle']"));
        //Assert.assertEquals(header.getText(), "Add client");  //Hard Assert
        softassert.assertEquals(header.getText(), "Add client"); //Soft Assert

        //Điền giá trị cho Form Add Client
        driver.findElement(By.id("company_name")).sendKeys("Selenium Java 06122021");
        Thread.sleep(1000);
        //Click dropdown
        driver.findElement(By.xpath("//div[@id='s2id_created_by']")).click();
        Thread.sleep(1000);
        //SetText input
        driver.findElement(By.xpath("//input[@id='s2id_autogen2_search']")).sendKeys("Admin 01");
        Thread.sleep(1000);
        //Dùng lệnh Enter
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.id("address")).sendKeys("Phuong 6");
        Thread.sleep(1000);
        driver.findElement(By.id("city")).sendKeys("Cao Lanh");
        Thread.sleep(1000);
        driver.findElement(By.id("state")).sendKeys("Dong Thap");
        Thread.sleep(1000);
        //Click Save button
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

        Thread.sleep(2000);

        //Click tab Clients
        driver.findElement(By.xpath("//a[contains(text(),'Clients')]")).click();
        Thread.sleep(1000);
        //Search giá trị Company Name vừa Add
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Selenium Java 06122021");
        Thread.sleep(1000);
        //Check text của item hiển thị sau khi search
        String item_client = driver.findElement(By.xpath("//table[@id='client-table']//tr[1]/td[2]//a")).getText();
        //Kiểm tra giá trị Text
        //Assert.assertTrue(item_client.equals("Selenium Java 06122021"));
        //Assert.assertEquals(item_client, "Selenium Java 06122021");

        softassert.assertTrue(item_client.equals("Selenium Java 06122021"));

        Thread.sleep(1000);

        softassert.assertAll(); //Bắt buộc
    }

}
