package task11;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Homepage {
    private WebDriver driver;
    private By signUpButton = By.id("signin2");
    public Homepage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get("https://www.demoblaze.com/");
    }
    public void clickSignUp() {
        WebElement button = driver.findElement(signUpButton);
        button.click();
    }
}
