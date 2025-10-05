package task11;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Homepage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By signUpButton = By.id("signin2");
    private By loginButton = By.id("login2");
    private By loggedInUser = By.id("nameofuser"); // Welcome <username>
    public Homepage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void open() {
        driver.get("https://www.demoblaze.com/");
    }
    public void clickSignUp() {
        driver.findElement(signUpButton).click();
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    public String waitForLoggedInUser() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInUser));
        return driver.findElement(loggedInUser).getText();
    }
}
