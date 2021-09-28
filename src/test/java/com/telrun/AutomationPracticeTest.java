package com.telrun;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AutomationPracticeTest {

    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("http://automationpractice.com/index.php");
    }

    @Test
    public void searchProductTests() {
        wd.findElement(By.id("search_query_top")).click();
//XPath: //*[@id="search_query_top"]
        //*[@id="center_column"]/h1
        wd.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys("summer dresses"+ Keys.ENTER );
        String text = wd.findElement(By.className("lighter")).getText();
        Assert.assertEquals(text.toLowerCase(),"\"summer dresses\"");

       wd.findElement(By.id("uniform-selectProductSort")).click();
       wd.findElement(By.xpath("//*[@id=\"selectProductSort\"]/option[2]")).click();
////*[@id="selectProductSort"]/option[4]
        ////*[@id="selectProductSort"]/option[2]

    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        wd.quit();
        //wd.close(); - sakriwaet odnu wkladku
    }
}
