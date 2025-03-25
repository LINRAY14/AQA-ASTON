import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PaymentTest {

    private WebDriver driver;
    private PaymentPage paymentPage;

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.create();
        paymentPage = new PaymentPage(driver);
        driver.get("https://mts.by");
        paymentPage.closeCookieBannerIfPresent();
    }

    @Test
    public void testConnectionFormSubmission() {
        paymentPage.fillFormForConnection("297777777", "5", "andrei.shunko1498@gmail.com");


        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form#pay-connection")));

        WebElement iframe = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));

        driver.switchTo().frame(iframe);

        paymentPage.checkFormPlaceholders();
        paymentPage.checkDisplayedAmountAndPhone("5.00 BYN", "375297777777");
    }
}
