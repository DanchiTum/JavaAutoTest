package task10;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
//1. Set up ChromeDriver using the driver file and properties.
//2. Set up ChromeDriver using DriverManager.
//3. Navigate to the page assigned to your variant.
//4. Select any three different elements.
//5. Interact with all the selected elements.
//6. Verify the visibility of each element using assertions.
//7. Wrap all these steps into a TestNG test case.
public class Task10Test {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void testElementsInteraction() {
        driver.get("https://www.demoblaze.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("signin2")));
        button.click();
        WebElement input1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
        WebElement input2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-password")));
        WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign up']")));
        input1.sendKeys("Selenium Test username");
        input2.sendKeys("Selenium Test password");
        signupButton.click();
        Assert.assertTrue(button.isDisplayed(), "Button not visible");
        Assert.assertTrue(input1.isDisplayed(), "Input1 not visible");
        Assert.assertTrue(input2.isDisplayed(), "Input2 not visible");
        Assert.assertTrue(signupButton.isDisplayed(), "Sign up button not visible");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
