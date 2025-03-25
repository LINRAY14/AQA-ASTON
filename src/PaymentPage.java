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
                // Если перекрыто — кликаем через JS
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

    public void enterPhoneNumber(String inputId, String phone) {
        WebElement phoneInput = driver.findElement(By.id(inputId));
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void enterAmount(String inputId, String amount) {
        WebElement amountInput = driver.findElement(By.id(inputId));
        amountInput.clear();
        amountInput.sendKeys(amount);
    }

    public void enterEmail(String inputId, String email) {
        WebElement emailInput = driver.findElement(By.id(inputId));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void clickContinueButton() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    public String getBePaidButtonAmount() {
        return driver.findElement(By.cssSelector("button[type='submit']")).getText(); // например "Оплатить 5.00 BYN"
    }

    public String getBePaidPhoneNumber() {
        return driver.findElement(By.xpath("//div[contains(text(),'Оплата:')]/b")).getText(); // "375297777777"
    }

    public boolean isPaymentSystemIconDisplayed(String altText) {
        return driver.findElement(By.xpath("//div[contains(@class,'pay__partners')]//img[@alt='" + altText + "']")).isDisplayed();
    }

    public void checkDisplayedAmountAndPhone(String expectedAmount, String expectedPhone) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement amountText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.pay-description__cost > span")
        ));
        Assert.assertEquals(amountText.getText().trim(), "5.00 BYN");
        if (!amountText.isDisplayed()) {
            throw new AssertionError("Сумма '" + expectedAmount + "' не отображается!");
        }


          WebElement phoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
          By.xpath("//span[contains(text(), '" + expectedPhone + "')]")
           ));
          if (!phoneElement.isDisplayed()) {
              throw new AssertionError("Телефон '" + expectedPhone + "' не отображается!");
          }

        // Возвращаемся из iframe
        driver.switchTo().defaultContent();
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

}
