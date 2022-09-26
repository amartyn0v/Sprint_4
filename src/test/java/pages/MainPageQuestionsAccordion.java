package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPageQuestionsAccordion {
    private WebDriver driver;

    public By cookiesAcceptButton = By.id("rcc-confirm-button");
    public By priceButton = By.id("accordion__heading-0");
    public By priceText = By.xpath(".//div[@id='accordion__panel-0']/p");
    public By fewButton = By.id("accordion__heading-1");
    public By fewText = By.xpath(".//div[@id='accordion__panel-1']/p");
    public By timeButton = By.id("accordion__heading-2");
    public By timeText = By.xpath(".//div[@id='accordion__panel-2']/p");
    public By orderTodayButton = By.id("accordion__heading-3");
    public By orderTodayText = By.xpath(".//div[@id='accordion__panel-3']/p");
    public By prolongButton = By.id("accordion__heading-4");
    public By prolongText = By.xpath(".//div[@id='accordion__panel-4']/p");
    public By chargerButton = By.id("accordion__heading-5");
    public By chargerText = By.xpath(".//div[@id='accordion__panel-5']/p");
    public By cancelButton = By.id("accordion__heading-6");
    public By cancelText = By.xpath(".//div[@id='accordion__panel-6']/p");
    public By mcadButton = By.id("accordion__heading-7");
    public By mcadText = By.xpath(".//div[@id='accordion__panel-7']/p");

    public MainPageQuestionsAccordion(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage(){
        driver.get("https://qa-scooter.praktikum-services.ru");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(cookiesAcceptButton));
    }

    public void priceClick() {
        WebElement element = driver.findElement(priceButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(priceButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(priceText));
    }

    public void fewClick() {
        WebElement element = driver.findElement(fewButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(fewButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(fewText));
    }

    public void timeClick() {
        WebElement element = driver.findElement(timeButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(timeButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(timeText));
    }

    public void orderTodayClick() {
        WebElement element = driver.findElement(orderTodayButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderTodayButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(orderTodayText));
    }

    public void prolongClick() {
        WebElement element = driver.findElement(prolongButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(prolongButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(prolongText));
    }

    public void chargerClick() {
        WebElement element = driver.findElement(chargerButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(chargerButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(chargerText));
    }

    public void cancelClick() {
        WebElement element = driver.findElement(cancelButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(cancelButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(cancelText));
    }

    public void mcadClick() {
        WebElement element = driver.findElement(mcadButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(mcadButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(mcadText));
    }

    public String priceGetText() {
        return driver.findElement(priceText).getText();
    }

    public String fewGetText() {
        return driver.findElement(fewText).getText();
    }

    public String timeGetText() {
        return driver.findElement(timeText).getText();
    }

    public String orderTodayGetText() {
        return driver.findElement(orderTodayText).getText();
    }

    public String prolongGetText() {
        return driver.findElement(prolongText).getText();
    }

    public String chargerGetText() {
        return driver.findElement(chargerText).getText();
    }

    public String cancelGetText() {
        return driver.findElement(cancelText).getText();
    }

    public String mcadGetText() {
        return driver.findElement(mcadText).getText();
    }

    public void acceptCookies() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(cookiesAcceptButton)).click();
    }
}
