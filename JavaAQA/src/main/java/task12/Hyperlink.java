package task12;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
public class Hyperlink {
    private WebDriver driver;
    private WebElement element;
    public Hyperlink(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.element = element;
    }
    public void click() {
        System.out.println("Clicking hyperlink: " + getUrl());
        element.click();
    }
    public void waitForClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
        System.out.println("Hyperlink is clickable: " + getUrl());
    }
    public String getUrl() {
        return element.getAttribute("href");
    }
}
