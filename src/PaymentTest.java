import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PaymentTest {

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
    }

    @Test
    public void testConnectionFormSubmission() {
        paymentPage.fillFormForConnection("297777777", "5", "andrei.shunko1498@gmail.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("iframe.bepaid-iframe")));
        driver.switchTo().frame(iframe);

        paymentPage.checkFormPlaceholders();
        paymentPage.checkDisplayedAmountAndPhone("5.00 BYN", "375297777727");

        System.out.println(" testConnectionFormSubmission: Все проверки прошли успешно.");
    }

    @AfterMethod
    public void logTestResult(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                System.out.println("Тест '" + result.getName() + "' пройден успешно.");
                break;
            case ITestResult.FAILURE:
                System.out.println(" Тест '" + result.getName() + "' упал с ошибкой: " + result.getThrowable());
                break;
            case ITestResult.SKIP:
                System.out.println(" Тест '" + result.getName() + "' был пропущен.");
                break;
        }
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
