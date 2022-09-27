package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class Order {
    private WebDriver driver;

    public Order(WebDriver driver) {
        this.driver = driver;
    }

    public By cookiesAcceptButton = By.id("rcc-confirm-button");
    public By orderButtons = By.xpath(".//button[text()='Заказать']");
    public By inputName = By.xpath(".//input[@placeholder='* Имя']");
    public By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    public By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    public By inputTube = By.xpath(".//input[@placeholder='* Станция метро']");
    public By inputPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    public By inputDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    public By inputAmount = By.xpath(".//div[@class='Dropdown-arrow-wrapper']/span");
    public By inputAmounts = By.xpath(".//div[@class='Dropdown-menu']/div");
    public By buttonProceed = By.xpath(".//button[text()='Далее']");
    public By colourCheckboxes = By.xpath(".//input[@type='checkbox']");
    public By inputComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    public By finishOrderButton = By.xpath(".//div[contains(@class, 'Order_Buttons')]/button[text()='Заказать']");

    public By modalYesButton = By.xpath(".//div[contains(@class, 'Order_Modal')]/div/button[text()='Да']");
    public By confirmationText = By.xpath(".//div[contains(@class, 'Order_Modal')]/div[contains(text(),'Заказ оформлен')]");

    public void clickOrderButton(int i) {
        List<WebElement> buttonsList = driver.findElements(orderButtons);
        buttonsList.get(i).click();
    }

    public void chooseColour(int i) {
        List<WebElement> coloursList = driver.findElements(colourCheckboxes);
        coloursList.get(i).click();
    }

    public void chooseAmount(int i) {
        driver.findElement(inputAmount).click();
        List<WebElement> daysList = driver.findElements(inputAmounts);
        daysList.get(i).click();
    }

    public void fillName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    public void fillSurname(String surname) {
        driver.findElement(inputSurname).sendKeys(surname);
    }

    public void fillAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
    }

    public void fillTube(String tube) {
        driver.findElement(inputTube).sendKeys(tube);
        driver.findElement(By.xpath(".//ul[@class='select-search__options']/li/button/div[text()='" + tube + "']")).click();
    }

    public void fillPhone(String phone) {
        driver.findElement(inputPhone).sendKeys(phone);
    }

    public void fillDate(String date) {
        driver.findElement(inputDate).sendKeys(date);
    }

    public void fillComment(String comment) {
        driver.findElement(inputComment).sendKeys(comment);
    }

    public void clickProceedButton() {
        WebElement element = driver.findElement(buttonProceed);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(buttonProceed).click();
    }

    public void acceptCookies() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(cookiesAcceptButton)).click();
    }

    public void finishOrder() {
        WebElement element = driver.findElement(finishOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(finishOrderButton).click();
    }

    public void confirmOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(modalYesButton)).click();
    }

    public boolean isConfirmationTextVisible() {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(confirmationText)).isDisplayed();
    }
}
