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
//- Verify that the user account is created and logged in
public class Task11Test {
//    In short, I noticed that I didn't complete the last point, which is to check if everything is ok,
//    if we are logged in, so I sat down to do it again, thinking of doing it as a second scenario,
//    and then asked a logical question. Why am I doing this in a second scenario?
//    Then I got angry and deleted half of the code and started to assemble something more like Page Objects from it.
//    With verification that we were logged in. This is the result
    WebDriver driver;
    Homepage homePage;
    Signuppage signupPage;
    Loginpage loginPage;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        homePage = new Homepage(driver);
        signupPage = new Signuppage(driver);
        loginPage = new Loginpage(driver);
    }
    @Test
    public void testUserSignUpAndLogin() {
        homePage.open();                                             // Registration
        homePage.clickSignUp();
        signupPage.waitForVisible();
        String username = "TestUser" + UUID.randomUUID().toString().substring(0, 6);
        signupPage.enterUsername(username);
        signupPage.enterPassword("Password123");
        signupPage.clickSignUp();
        String alertText = signupPage.getAlertTextAndAccept();
        Assert.assertTrue(alertText.contains("Sign up successful"),"Error");
        homePage.clickLogin();                                       // Login
        loginPage.waitForVisible();
        loginPage.enterUsername(username);
        loginPage.enterPassword("Password123");
        loginPage.clickLogin();
        String loggedInUser = homePage.waitForLoggedInUser();
        Assert.assertTrue(loggedInUser.contains(username),"User is not logged in.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
