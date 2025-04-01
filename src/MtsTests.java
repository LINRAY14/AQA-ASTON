import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class MtsTests {

    private WebDriver driver;
    private PaymentPage paymentPage;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mts.by");
        paymentPage = new PaymentPage(driver);
        paymentPage.closeCookieBannerIfPresent();
    }

    @Test
    public void testBlockTitle() {
        paymentPage.verifyBlockTitle();
    }

    @Test
    public void testPaymentLogosVisible() {
        paymentPage.verifyPaymentLogos();
    }

    @Test
    public void testServiceLinkNavigation() {
        paymentPage.verifyServiceLinkNavigation();
    }

    @Test
    public void testPaymentFormAppears() {
        paymentPage.fillFormForConnection("297777777", "5", "test@example.com");
        paymentPage.verifyPaymentFormDisplayed();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
