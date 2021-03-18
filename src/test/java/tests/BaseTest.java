//package tests;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//
//import java.io.File;
//
//public abstract class BaseTest {
//
//
//
//    private static WebDriver driver;
//
//    public static WebDriver getDriver() {
//        return driver;
//    }
//
//    @BeforeClass1
//    public void setUp () {
//        File file = new File("src/test/resources/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//        driver = new ChromeDriver();
//        driver.get("https://www.google.ru/");
//
//    }
//
//    @AfterClass
//    public void tearDown () {
//        driver.quit();
//
//    }
//
//    @AfterMethod
//    public void goBack (){
//        driver.navigate().back();
//    }
//
//    @DataProvider(name = "dataProvider")
//    public Object[][] dataProviderMethod () {
//        return new Object[][]{{"selenium java"}, {"selenium javascript"}};
//    }
//
//}
