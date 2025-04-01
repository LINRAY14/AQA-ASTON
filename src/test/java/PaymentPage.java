import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PaymentPage {

    private WebDriver driver;

    public void fillFormForConnection(String phone, String amount, String email) {
        selectPaymentOption("Услуги связи");

        WebElement phoneField = driver.findElement(By.id("connection-phone"));
        WebElement amountField = driver.findElement(By.id("connection-sum"));
        WebElement emailField = driver.findElement(By.id("connection-email"));
        closeCookieBannerIfPresent();
        WebElement submitButton = driver.findElement(By.cssSelector("form#pay-connection button[type='submit']"));

        phoneField.sendKeys(phone);
        amountField.sendKeys(amount);
        emailField.sendKeys(email);
        submitButton.click();
    }
    public void closeCookieBannerIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement cookieCancel = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button.cookie__cancel")
            ));


            try {
                cookieCancel.click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cookieCancel);
            }

        } catch (NoSuchElementException | TimeoutException ignored) {

        }
    }


    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectPaymentOption(String option) {
        WebElement dropdown = driver.findElement(By.id("pay"));
        dropdown.findElement(By.xpath(".//option[text()='" + option + "']")).click();
    }

    public String getPhonePlaceholder(String inputId) {
        return driver.findElement(By.id(inputId)).getAttribute("placeholder");
    }

    public String getSumPlaceholder(String inputId) {
        return driver.findElement(By.id(inputId)).getAttribute("placeholder");
    }

    public void checkDisplayedAmountAndPhone(String expectedAmount, String expectedPhone) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement amountText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.pay-description__cost > span")
        ));
        Assert.assertEquals(amountText.getText().trim(), expectedAmount);
        if (!amountText.isDisplayed()) {
            throw new AssertionError("Сумма '" + expectedAmount + "' не отображается!");
        }


        String fullPhone = String.format("375%s", expectedPhone);
        WebElement phoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(), '" + fullPhone + "')]")
        ));

        WebElement phoneText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(), '" + fullPhone + "')]")
        ));
        if (!phoneText.isDisplayed()) {
            throw new AssertionError("Телефон '" + fullPhone + "' не отображается!");
        }

        System.out.println("Сумма и номер телефона успешно отображаются.");
    }





    public void checkFormPlaceholders() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String[] labels = {
                "Номер карты",
                "Срок действия",
                "CVC",
                "Имя держателя"
        };

        for (String label : labels) {
            WebElement labelElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'" + label + "')]")
            ));
            if (!labelElement.isDisplayed()) {
                throw new AssertionError("Плейсхолдер '" + label + "' не отображается!");
            }
        }
    }
    public void verifyBlockTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='pay__wrapper']//h2")));
        String expectedText = "Онлайн пополнение без комиссии";
        String actualText = title.getText().replace("\n", " ").trim();
        Assert.assertTrue(actualText.contains("Онлайн пополнение") &&
                        actualText.contains("без комиссии"),
                "Заголовок блока: '" + expectedText + "' не отображается");
        System.out.println("Заголовок блока '" + actualText + "' отобразился");
    }

    public void verifyPaymentLogos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String[] expectedAlts = {
                "Visa", "Verified By Visa", "MasterCard",
                "MasterCard Secure Code", "Белкарт"
        };

        for (String alt : expectedAlts) {
            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class=\"pay__partners\"]//img[@alt='" + alt + "']")));
            Assert.assertTrue(logo.isDisplayed(), "Логотип не найден: " + alt);
            System.out.println("Логотип '" + alt + "' отобразился");
        }
    }

    public void verifyServiceLinkNavigation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href, '/help/poryadok-oplaty-i-bezopasnost-internet-platezhey')]")
        ));
        link.click();


        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h3[contains(text(),'Оплата банковской картой')]")
        ));

        String expected = "Оплата банковской картой";
        String actual = heading.getText().trim();

        Assert.assertTrue(actual.contains(expected),
                "Ожидали заголовок: '" + expected + "', но получили: '" + actual + "'");

        System.out.println("Успешная навигация на страницу: '" + actual + "'");
    }


    public void verifyPaymentFormDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.cssSelector("iframe.bepaid-iframe")));

        WebElement paymentBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.app-wrapper")));

        Assert.assertTrue(paymentBlock.isDisplayed(), "Форма оплаты не появилась.");
        System.out.println("Форма оплаты отобразилась");
    }

}