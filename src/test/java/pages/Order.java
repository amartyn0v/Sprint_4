package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.time.Duration;


public class Order {
    private WebDriver driver;

    public Order(WebDriver driver) {
        this.driver = driver;
    }

    public By cookiesAcceptButton = By.id("rcc-confirm-button");
    public static By headerOrderButton = By.xpath(".//div[contains(@class, 'Header_Nav')]/button[text()='Заказать']");
    public static By middleOrderButton = By.xpath(".//div[contains(@class, 'Home_RoadMap')]/div/button[text()='Заказать']");
    public By inputName = By.xpath(".//input[@placeholder='* Имя']");
    public By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    public By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    public By inputTube = By.xpath(".//input[@placeholder='* Станция метро']");
    public By inputPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    public By inputDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    public By inputAmount = By.xpath(".//div[@class='Dropdown-arrow-wrapper']/span");
    public By inputAmountDropdown1 = By.xpath(".//div[@class='Dropdown-menu']/div[1]");
    public By inputAmountDropdown2 = By.xpath(".//div[@class='Dropdown-menu']/div[2]");
    public By inputAmountDropdown3 = By.xpath(".//div[@class='Dropdown-menu']/div[3]");
    public By inputAmountDropdown4 = By.xpath(".//div[@class='Dropdown-menu']/div[4]");
    public By inputAmountDropdown5 = By.xpath(".//div[@class='Dropdown-menu']/div[5]");
    public By inputAmountDropdown6 = By.xpath(".//div[@class='Dropdown-menu']/div[6]");
    public By inputAmountDropdown7 = By.xpath(".//div[@class='Dropdown-menu']/div[7]");
    public By buttonProceed = By.xpath(".//button[text()='Далее']");
    public By checkboxColourBlack = By.id("black");
    public By checkboxColourGray = By.id("grey");
    public By inputComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    public By finishOrderButton = By.xpath(".//div[contains(@class, 'Order_Buttons')]/button[text()='Заказать']");

    public By modalYesButton = By.xpath(".//div[contains(@class, 'Order_Modal')]/div/button[text()='Да']");
    public By confirmationText = By.xpath(".//div[contains(@class, 'Order_Modal')]/div[contains(text(),'Заказ оформлен')]");

    public void clickOrderButton(By button){
        driver.findElement(button).click();
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

    public void chooseAmount(int amount) {
        driver.findElement(inputAmount).click();
        switch (amount) {
            case 1:
                driver.findElement(inputAmountDropdown1).click();
                break;
            case 2:
                driver.findElement(inputAmountDropdown2).click();
                break;
            case 3:
                driver.findElement(inputAmountDropdown3).click();
                break;
            case 4:
                driver.findElement(inputAmountDropdown4).click();
                break;
            case 5:
                driver.findElement(inputAmountDropdown5).click();
                break;
            case 6:
                driver.findElement(inputAmountDropdown6).click();
                break;
            case 7:
                driver.findElement(inputAmountDropdown7).click();
                break;
        }
    }

    public void chooseBlackColour() {
        driver.findElement(checkboxColourBlack).click();
    }

    public void chooseGrayColour() {
        driver.findElement(checkboxColourGray).click();
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
