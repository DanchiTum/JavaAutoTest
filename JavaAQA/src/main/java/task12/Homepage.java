package task12;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
public class Homepage {
    private WebDriver driver;
    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[contains(text(),'Nokia lumia 1520')]")
    private WebElement nokiaLinkRaw;
    public Hyperlink getNokiaLink() {
        return new Hyperlink(driver, nokiaLinkRaw);
    }
}
