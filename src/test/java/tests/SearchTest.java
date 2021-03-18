package tests;
//
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;

import static java.lang.Math.random;
//
public class SearchTest  {

    @Test
    public void openPageRegistration () throws InterruptedException {

        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://frontend.topnlab.ru/registration");
        driver.manage().window().maximize();
        WebElement selectProduct = driver.findElement(By.xpath("//div[@id=\'main-page__content-wrap\']/app-registration/main/div/app-registration-form/div/div/div/app-create-company-form/form/div/div/div/div/ng-select/div"));
        selectProduct.click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/div[2]")));
        }
        driver.findElement(By.xpath("//div[2]/div[2]")).click();
        driver.findElement(By.xpath("//div[@id=\'main-page__content-wrap\']/app-registration/main/div/app-registration-form/div/div/div/app-create-company-form/form/div/div[2]/div/div/ng-select/div/div/div[2]")).click();



//        driver.findElement(By.xpath("//div[2]/div[1]/span")).click();
        driver.findElement(By.xpath("//div[2]/div[2]")).click();

        WebElement LegalFormSearch = driver.findElement(By.xpath("//div[@id='main-page__content-wrap']/app-registration/main/div/app-registration-form/div/div/div/app-create-company-form/form/div/div[2]/div/div/ng-select/div/div/div[2]/span[2]"));

        String LFS = LegalFormSearch.getText();
        System.out.println(LFS);
        String ip = "ИП";



        if (LFS.equals(ip)) {
            System.out.println("fffffffffffffff");
        }
        else {
            driver.findElement(By.id("input-label-1")).sendKeys("Нерекламное название");
        }

    }
    }
//
//
//}
