//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//public class SearchResultsPage extends BasePage {
//
//    private By resultRow = By.xpath("//div[@class='g']//h3");
//
//    public SearchResultsPage() {
//        super();
//    }
//
//    public void assertThatTopResultContainsCorrectText(String expected) {
//        WebElement resultRowElement = driver.findElement(resultRow);
//        assertThat(resultRowElement.isDisplayed()).as("Элемент не отображен").isTrue();
//        assertThat(resultRowElement.getText()).as("oshibka1").isEqualTo(expected);
//    }
//
//    public void assertThatTopResultContainsProperAttributeText(String expected) {
//        WebElement resultRowElement = driver.findElement(By.xpath(resultRow));
//        assertThat(resultRowElement.getAttribute("class")).as("oshibka2").contains(expected);
//    }
//}
