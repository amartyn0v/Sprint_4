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
    public static By priceButton = By.id("accordion__heading-0");
    public static By priceText = By.xpath(".//div[@id='accordion__panel-0']/p");
    public static By fewButton = By.id("accordion__heading-1");
    public static By fewText = By.xpath(".//div[@id='accordion__panel-1']/p");
    public static By timeButton = By.id("accordion__heading-2");
    public static By timeText = By.xpath(".//div[@id='accordion__panel-2']/p");
    public static By orderTodayButton = By.id("accordion__heading-3");
    public static By orderTodayText = By.xpath(".//div[@id='accordion__panel-3']/p");
    public static By prolongButton = By.id("accordion__heading-4");
    public static By prolongText = By.xpath(".//div[@id='accordion__panel-4']/p");
    public static By chargerButton = By.id("accordion__heading-5");
    public static By chargerText = By.xpath(".//div[@id='accordion__panel-5']/p");
    public static By cancelButton = By.id("accordion__heading-6");
    public static By cancelText = By.xpath(".//div[@id='accordion__panel-6']/p");
    public static By mcadButton = By.id("accordion__heading-7");
    public static By mcadText = By.xpath(".//div[@id='accordion__panel-7']/p");

    public MainPageQuestionsAccordion(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage(){
        driver.get("https://qa-scooter.praktikum-services.ru");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(cookiesAcceptButton));
    }

    public void questionClick(By button, By text){
        WebElement element = driver.findElement(button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(button).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(text));
    }

    public String questionGetText(By question){
        return driver.findElement(question).getText();
    }

    public void acceptCookies() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(cookiesAcceptButton)).click();
    }
}
