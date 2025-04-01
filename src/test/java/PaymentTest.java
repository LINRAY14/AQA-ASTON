import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.time.Duration;

import static org.openqa.selenium.OutputType.*;
import org.openqa.selenium.TakesScreenshot;

@Epic("MTS Automation")
@Feature("Connection Payment")
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

    @Test(description = "Отправка формы пополнения и проверка отображения суммы и телефона")
    @Story("Submit payment form and verify result")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяется корректное отображение суммы и номера телефона после заполнения формы оплаты.")
    public void testConnectionFormSubmission() {
        paymentPage.fillFormForConnection("297777777", "5", "andrei.shunko1498@gmail.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("iframe.bepaid-iframe")));
        driver.switchTo().frame(iframe);

        paymentPage.checkFormPlaceholders();
        paymentPage.checkDisplayedAmountAndPhone("5.00 BYN", "297777777");

        System.out.println(" testConnectionFormSubmission: Все проверки прошли успешно.");
    }

    @Attachment(value = "Скриншот при ошибке", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(BYTES);
    }

    @AfterMethod
    public void logTestResult(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                System.out.println("Тест '" + result.getName() + "' пройден успешно.");
                break;
            case ITestResult.FAILURE:
                System.out.println(" Тест '" + result.getName() + "' упал с ошибкой: " + result.getThrowable());
                saveScreenshot();
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
