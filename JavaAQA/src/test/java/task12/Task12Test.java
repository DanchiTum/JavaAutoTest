package task12;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
//Implement PageFactory for a few pages.
//Implement a Wrapper for common WebElements.
//Implement methods for your web element with console logging.
//Use those methods in a simple TC scenario
//Hyperlinks:
//click - clicks on a hyperlink
//waitForClickable - waits for the hyperlink to become clickable
//getUrl - retrieves the URL of the hyperlink
public class Task12Test {
    private WebDriver driver;
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
    }
    @Test
    public void testNokiaHyperlink() {
        Homepage homePage = new Homepage(driver);
        var nokiaLink = homePage.getNokiaLink();
        nokiaLink.waitForClickable();
        nokiaLink.click();
        Productpage productPage = new Productpage(driver);
        productPage.waitForProductTitle();
        String title = productPage.getProductTitle();
        System.out.println("Product title: " + title);
        assertEquals(title, "Nokia lumia 1520");
    }
    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
