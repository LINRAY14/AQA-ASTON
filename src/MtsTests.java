import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class MtsTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mts.by");

        try {
            WebElement cookieBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//button[contains(text(),'Принять')]")));
            cookieBtn.click();
            System.out.println("Cookie баннер принят.");
        } catch (TimeoutException e) {
            System.out.println("Cookie баннер не найден или уже скрыт.");
        }
    }

    @Test
    public void testBlockTitle() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay__wrapper']//h2")));
        String expectedText = "Онлайн пополнение без комиссии";
        String actualText = title.getText().replace("\n", " ").trim();
        Assert.assertTrue(actualText.contains("Онлайн пополнение") &&
                        actualText.contains("без комиссии"),
                "Заголовок блока: '" + expectedText +  "' не отображается");
    }

    @Test
    public void testPaymentLogosVisible() {
        String[] expectedAlts = {
                "Visa", "Verified By Visa", "MasterCard",
                "MasterCard Secure Code", "Белкарт"
        };

        for (String alt : expectedAlts) {
            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class=\"pay__partners\"]//img[@alt='" + alt + "']")));

                    Assert.assertTrue(logo.isDisplayed(), "Логотип не найден: " + alt);
        }
    }
    @Test
    public void testServiceLinkNavigation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/help/poryadok-oplaty-i-bezopasnost-internet-platezhey')]")));
        link.click();

        wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));


        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class=\"container-fluid\"]/h3[1]")));
        String expectedText = "Оплата банковской картой";
        String actualText = title.getText().trim();
        Assert.assertTrue(actualText.contains(expectedText),
                "Заголовок блока: '" + expectedText +  "' не отображается");

    }
    @Test
    public void testPaymentFormAppears() {

        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-phone")));
        phoneField.sendKeys("297777777");

        WebElement amountField = driver.findElement(By.id("connection-sum"));
        amountField.sendKeys("5");

        WebElement emailField = driver.findElement(By.id("connection-email"));
        emailField.sendKeys("test@example.com");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.cssSelector("iframe.bepaid-iframe")));

        WebElement paymentBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.app-wrapper")));

        Assert.assertTrue(paymentBlock.isDisplayed(), "Форма оплаты не появилась.");

        System.out.println("Форма оплаты появилась - тест пройден");
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}


