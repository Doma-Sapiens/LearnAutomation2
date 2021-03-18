// здесь использую тест ng

package TestSuites;

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

public class Registration2 {
    JavascriptExecutor js;


    @DataProvider(name = "LegalForm")
    public Object [][] dataProviderMethod () {
        return new Object[][]{{"//div[2]/div[1]/span"}, {"//div[2]/div[2]"}, {"//div[2]/div[3]"}, {"//div[2]/div[4]"}, {"//div[2]/div[5]"}, {"//div[2]/div[6]"}}; // выбор разных организационных форм кроме ип
    }


    @Test(dataProvider = "LegalForm")


//    public void openPageRegistration () throws InterruptedException {
    public void openPageRegistration (String lf) throws InterruptedException {



        long a = 1000000000;
        long b = 2147483647;
        long x = a + (long)(random() * ((b - a) + 1));
        System.out.println("Случайное число x: " + x);

        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://frontend.topnlab.ru/registration");
        driver.manage().window().maximize();



        ((JavascriptExecutor) driver).executeScript("window.open('https://temp-mail.org/ru/')");   // открытие новой вкладки получения писем с помощью новой js
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

//        driver.switchTo().window(tabs.get(0));  // вкладка со страницей регистрации
//        driver.switchTo().window(tabs.get(1));  // вкладка с почтой
//        driver.switchTo().window(tabs1.get(2));  // вкладка с реквизитами

        driver.switchTo().window(tabs.get(1));

        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/div[2]"))); click-to-delete
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("click-to-delete")));
        }


        driver.findElement(By.id("click-to-delete")).click(); // удаление старой почты

        ((JavascriptExecutor) driver).executeScript("window.open('http://mellarius.ru/random-inn')");
        ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(2)); // вкладка с реквизитами
        driver.findElement(By.id("button_genall")).click();  // сгенирировали реквизиты на сатйе mellarius.ru

        WebElement PAO = driver.findElement(By.id("pao"));  // задали ПАО
        String AdvertisingCompanyName = PAO.getAttribute("value"); // текст вставки названия
        System.out.println(AdvertisingCompanyName); // проверяем значение ПАО

        WebElement OGRN = driver.findElement(By.id("ogrn"));
        String ogrn = OGRN.getAttribute("value");
        System.out.println(ogrn);

        WebElement INN = driver.findElement(By.id("innul"));
        String inn = INN.getAttribute("value");
        System.out.println(inn);

        WebElement KPP = driver.findElement(By.id("kpp"));
        String kpp = KPP.getAttribute("value");
        System.out.println(kpp);

        WebElement OGRNIP = driver.findElement(By.id("ogrnip"));
        String ogrnip = OGRNIP.getAttribute("value");
        System.out.println(ogrnip);

        WebElement INNFL = driver.findElement(By.id("innfl"));
        String innfl = INNFL.getAttribute("value");
        System.out.println(innfl);




        driver.switchTo().window(tabs.get(0));

//        WebElement selectProduct = driver.findElement(By.xpath("//div[@id=\'main-page__content-wrap\']/app-registration/main/div/app-registration-form/div/div/div/app-create-company-form/form/div/div/div/div/ng-select/div"));
//        selectProduct.click();
//        {
//            WebDriverWait wait = new WebDriverWait(driver, 10);
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/div[2]")));
//        }
//        driver.findElement(By.xpath("//div[2]/div[2]")).click();
//        driver.findElement(By.xpath("//div[@id=\'main-page__content-wrap\']/app-registration/main/div/app-registration-form/div/div/div/app-create-company-form/form/div/div[2]/div/div/ng-select/div/div/div[2]")).click();
//        driver.findElement(By.xpath(lf)).click();



        WebElement selectProduct = driver.findElement(By.xpath("//div[@id=\'main-page__content-wrap\']/app-registration/main/div/app-registration-form/div/div/div/app-create-company-form/form/div/div/div/div/ng-select/div"));
        selectProduct.click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/div[2]")));
        }
        driver.findElement(By.xpath("//div[2]/div[2]")).click();
        driver.findElement(By.xpath("//div[@id=\'main-page__content-wrap\']/app-registration/main/div/app-registration-form/div/div/div/app-create-company-form/form/div/div[2]/div/div/ng-select/div/div/div[2]")).click();

        driver.findElement(By.xpath(lf)).click();

        // находим ип, чтобы выбирать поля
        WebElement LegalFormSearch = driver.findElement(By.xpath("//div[@id='main-page__content-wrap']/app-registration/main/div/app-registration-form/div/div/div/app-create-company-form/form/div/div[2]/div/div/ng-select/div/div/div[2]/span[2]"));

        String LFS = LegalFormSearch.getText();
        System.out.println(LFS);
        String ip = "ИП";
        if (LFS.equals(ip)) {
            System.out.println("нашли ип");
        }
        else {
            driver.findElement(By.id("input-label-1")).sendKeys("Нерекламное название");
        }





//        WebElement vzvr = driver.findElement(By.cssSelector("h1")); // получаю
//        {
//            WebDriverWait wait = new WebDriverWait(driver, 10);
//            wait.until(ExpectedConditions.textToBePresentInElement(vzvr, "Р"));  // ожидаение конкретного значения в локатеторе
//        }
//        System.out.println(vzvr.getText());                         // текст
//        System.out.println(vzvr.getAttribute("class"));       // значения атрибута  Важно: можно получить, только если на мониторе отображается







        driver.findElement(By.id("input-label-2")).click();
        driver.findElement(By.id("input-label-2")).sendKeys(AdvertisingCompanyName); // ПАО сформировано js

        driver.findElement(By.cssSelector("#at_chef_accon > span")).click(); // открытие аккордеона директора
        driver.findElement(By.cssSelector("#at_bank_accon > span")).click(); // открытие аккордеона банка


//        решаем вопрос с откртыем ак-на для ип
//        driver.findElement(By.xpath("//span[contains(.,'ОГРН/ИНН/КПП')]")).click(); // открытие аккордеона реквизитов не у ИП
        if (LFS.equals(ip)) {
            driver.findElement(By.xpath("//span[contains(.,'ОГРН/ИНН')]")).click();
        }
        else {
            driver.findElement(By.xpath("//span[contains(.,'ОГРН/ИНН/КПП')]")).click(); // открытие аккордеона реквизитов

        }




        driver.findElement(By.cssSelector("#at_legalAdress_accon > span")).click();

        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/input")));
        }

        driver.findElement(By.xpath("//div[2]/input")).click();

        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,\'Санкт-Петербург г.\')]"))); // проверяем кликабельность
        }

        driver.findElement(By.xpath("//span[contains(.,\'Санкт-Петербург г.\')]")).click();
        driver.findElement(By.xpath("//div[3]/div/input")).click();
        driver.findElement(By.xpath("//div[3]/div/input")).sendKeys("123456");
        driver.findElement(By.xpath("//div[@id=\'main-page__content-wrap\']/app-registration/main/div/app-registration-form/div/div/div/app-create-company-form/form/div/div[3]/app-geo-regin/sui-accordion/sui-accordion-panel/div[2]/div/div/app-geo-regin-form/div[4]/div/div/ng-select/div/div/div[2]/input")).click();
        driver.findElement(By.xpath("//div[@id=\'main-page__content-wrap\']/app-registration/main/div/app-registration-form/div/div/div/app-create-company-form/form/div/div[3]/app-geo-regin/sui-accordion/sui-accordion-panel/div[2]/div/div/app-geo-regin-form/div[4]/div/div/ng-select/div/div/div[2]/input")).sendKeys("ленина");
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(.,\'Ленина ул.\')]")));
        }
        driver.findElement(By.xpath("//span[contains(.,\'Ленина ул.\')]")).click();
        driver.findElement(By.xpath("//div[5]/div/input")).click();
        driver.findElement(By.xpath("//div[5]/div/input")).sendKeys("5");
        driver.findElement(By.cssSelector(".registration-block__item:nth-child(6) .ng-valid")).click();
        driver.findElement(By.cssSelector(".registration-block__item:nth-child(6) .ng-valid")).sendKeys("2");
        driver.findElement(By.cssSelector(".registration-block__item:nth-child(7) .ng-valid")).sendKeys("а");
        driver.findElement(By.cssSelector(".registration-block__item:nth-child(8) .ng-valid")).sendKeys("2");
        driver.findElement(By.cssSelector("app-geo-regin-form > .registration-block__item:nth-child(9) .ng-valid")).click();
        driver.findElement(By.xpath("//div[9]/div/input")).sendKeys("6");
        driver.findElement(By.cssSelector("span label")).click();
        driver.findElement(By.cssSelector("#at_actualAdress_accon > span")).click();

//        driver.findElement(By.xpath("//span[contains(.,'ОГРН/ИНН/КПП')]")).click(); // открытие аккордеона реквизитов
//        driver.findElement(By.cssSelector("#at_ogrn_accon > .ng-star-inserted")).click();  // открытие аккордеона реквизитов

        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-label-3")));
        }

        if (LFS.equals(ip)) {
            driver.findElement(By.id("input-label-3")).sendKeys(ogrnip); // огрн чл
            driver.findElement(By.id("input-label-4")).sendKeys(innfl); // инн чл
        }
        else {
            driver.findElement(By.id("input-label-3")).sendKeys(ogrn); // огрн юл
            driver.findElement(By.id("input-label-4")).sendKeys(inn); // инн юл
            driver.findElement(By.id("input-label-5")).sendKeys(kpp); // кпп юл

        }

//        driver.findElement(By.id("input-label-3")).sendKeys(ogrn); // огрн
//        driver.findElement(By.id("input-label-4")).sendKeys(inn); // инн
//        driver.findElement(By.id("input-label-5")).sendKeys(kpp); // кпп


//        driver.findElement(By.cssSelector("#at_bank_accon > span")).click(); // открытие аккордеона банка
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-label-6")));
        }
        driver.findElement(By.id("input-label-6")).click();
        driver.findElement(By.id("input-label-6")).sendKeys("11111111111111111111");
        driver.findElement(By.id("input-label-7")).click();
        driver.findElement(By.id("input-label-7")).sendKeys("Банк");
        driver.findElement(By.id("input-label-8")).click();
        driver.findElement(By.id("input-label-8")).sendKeys("30155555555555555555");
        driver.findElement(By.id("input-label-9")).click();
        driver.findElement(By.id("input-label-9")).sendKeys("778945874");

        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-label-10")));
        }
        driver.findElement(By.id("input-label-10")).click();
        driver.findElement(By.id("input-label-10")).sendKeys("Фамилия");
        driver.findElement(By.id("input-label-11")).click();
        driver.findElement(By.id("input-label-11")).sendKeys("Имя");
        driver.findElement(By.id("input-label-12")).sendKeys("Отчество");
        driver.findElement(By.id("input-label-13")).click();
        driver.findElement(By.id("input-label-13")).sendKeys(x + "");   // вставка номера

        driver.switchTo().window(tabs.get(1));

        WebElement Mail = driver.findElement(By.id("mail"));
//        {
//            WebDriverWait wait = new WebDriverWait(driver, 100);
//            wait.until(ExpectedConditions.textToBePresentInElement(Mail, ".com")); // не отображается
//        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {  // возможно потом можно будет заменить
            e.printStackTrace();
        }
        String mail = Mail.getAttribute("value");
        System.out.println(mail); // proverka pochty

        driver.switchTo().window(tabs.get(0));

        driver.findElement(By.id("input-label-14")).sendKeys(mail);
        driver.findElement(By.id("input-label-15")).click();
        driver.findElement(By.id("input-label-15")).sendKeys(mail);

        driver.findElement(By.id("input-label-16")).click();
        driver.findElement(By.id("input-label-16")).sendKeys("123456");
        driver.findElement(By.id("input-label-17")).click();
        driver.findElement(By.id("input-label-17")).sendKeys("123456");

//        driver.findElement(By.xpath("//label[contains(.,\'Я даю согласие на хранение и обработку данных\')]")).click();  // беда с чекбоксом
//        driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();


        // Нажатие на чекбокс с помощью наведения мыши. Без этого не работает, потому что чекбокс "закрыт" другим элементом
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
        builder.moveToElement(element).click().build().perform();

        driver.findElement(By.xpath("//button[contains(.,\'Зарегистрироваться\')]")).click();


        // Проверки. Сейчас проверяется наличие почты. Потом надо заменить паузу на ожидание
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if (LFS.equals(ip)) {
            WebElement email = driver.findElement(By.xpath("(//span)[12]"));
            Assert.assertEquals(mail, email.getText(), "Почта не отображается или отображается некорректно" );
        }
        else {
            WebElement email = driver.findElement(By.xpath("(//span)[13]"));
            Assert.assertEquals(mail, email.getText(), "Почта не отображается или отображается некорректно" );

        }

//        WebElement email = driver.findElement(By.xpath("(//span)[13]"));
//        Assert.assertEquals(mail, email.getText(), "Почта не отображается или отображается некорректно" );





        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".regconfirm-block__btn")));
        }

        driver.findElement(By.cssSelector(".regconfirm-block__btn")).click();

        driver.navigate().to("http://frontend.topnlab.ru/authorize/login");

//        ожидание. нужно для того, чтобы информация о новой компании попала в базу
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(mail);
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[contains(.,\'Войти\')]")).click();

        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,\'Выйти\')]")));
        }

        driver.findElement(By.xpath("//button[contains(.,\'Выйти\')]")).click();

        driver.quit();
















    }


}

