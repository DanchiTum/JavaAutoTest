package task11;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.UUID;
//1. Make up one simple UI end-to-end test case for your test page from Task_10
//2. Automate that scenario using WebDriver
//3. Create PageObject (use Business object if needed)for all pages used in the scenario
//
//Scenario example (new account)
//- Navigate to the sign-up page
//- Enter a valid email address, a username, and a strong password
//- Click on the "Sign Up" button
//- Verify that the user is redirected to the home page
public class Task11Test {
    WebDriver driver;
    Homepage homePage;
    Signupmodel signUpModal;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        homePage = new Homepage(driver);
        signUpModal = new Signupmodel(driver);
    }
    @Test
    public void testUserSignUp() {
        homePage.open();
        homePage.clickSignUp();
        signUpModal.waitForVisible();
        String Username = "Testuser" + UUID.randomUUID().toString().substring(0, 6);
        signUpModal.fillForm(Username, "Password123");
        signUpModal.submit();
        String alertText = signUpModal.getAlertTextAndAccept();
        Assert.assertTrue(alertText.contains("Sign up successful"), "Unexpected alert message: " + alertText);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
