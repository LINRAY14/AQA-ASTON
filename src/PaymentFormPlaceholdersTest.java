
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PaymentFormPlaceholdersTest {

    private WebDriver driver;
    private PaymentPage paymentPage;

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.create();
        paymentPage = new PaymentPage(driver);
        driver.get("https://mts.by");
    }

    @Test
    public void testPlaceholdersForAllPaymentOptions() {
        checkPlaceholders("Услуги связи", "connection-phone", "connection-sum",
                "Номер телефона", "Сумма");
        checkPlaceholders("Домашний интернет", "internet-phone", "internet-sum",
                "Номер абонента", "Сумма");
        checkPlaceholders("Рассрочка", "score-instalment", "instalment-sum",
                "Номер счета на 44", "Сумма");
        checkPlaceholders("Задолженность", "score-arrears", "arrears-sum",
                "Номер счета на 2073", "Сумма");
    }

    private void checkPlaceholders(String option, String phoneId, String sumId,
                                   String expectedPhonePlaceholder, String expectedSumPlaceholder) {
        paymentPage.selectPaymentOption(option);
        assertEquals(paymentPage.getPhonePlaceholder(phoneId), expectedPhonePlaceholder);
        assertEquals(paymentPage.getSumPlaceholder(sumId), expectedSumPlaceholder);
    }
}
