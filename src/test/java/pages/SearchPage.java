//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//
//public class SearchPage extends BasePage {
//
//    private By searchField = By.name("q");
//
//
//
//    public SearchPage() {
//        super();
//    }
//    public void fillSearchField (String text) {
//        WebElement searchFieldElement = driver.findElement(searchField);
//        searchFieldElement.click();
//        searchFieldElement.sendKeys(text);
//
//    }
//    public void pressEnter () {
//        WebElement searchFieldElement = driver.findElement(searchField);
//        searchFieldElement.sendKeys(Keys.RETURN);
//
//    }
//}
