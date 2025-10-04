package task11;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Signupmodel {
    private WebDriver driver;
    private WebDriverWait wait;
    private By usernameInput = By.id("sign-username");
    private By passwordInput = By.id("sign-password");
    private By signUpButton = By.xpath("//button[text()='Sign up']");
    public Signupmodel(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void waitForVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
    }
    public void fillForm(String username, String password) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void submit() {
        driver.findElement(signUpButton).click();
    }
    public String getAlertTextAndAccept() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
        return text;
    }
}
