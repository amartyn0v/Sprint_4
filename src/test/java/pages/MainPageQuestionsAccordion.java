package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class MainPageQuestionsAccordion {
    private WebDriver driver;

    public By cookiesAcceptButton = By.id("rcc-confirm-button");
    public By questionsButtons = By.xpath(".//div[contains(@id, 'accordion__heading')]");
    public By questionsTexts = By.xpath(".//div[contains(@id, 'accordion__panel')]/p");

    public MainPageQuestionsAccordion(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get("https://qa-scooter.praktikum-services.ru");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(cookiesAcceptButton));
    }

    public void questionClick(int i) {
        List<WebElement> listOfButtons = driver.findElements(questionsButtons);
        List<WebElement> listOfTexts = driver.findElements(questionsTexts);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", listOfButtons.get(i));
        listOfButtons.get(i).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(listOfTexts.get(i)));
    }

    public String questionGetText(int i) {
        List<WebElement> listOfTexts = driver.findElements(questionsTexts);
        return listOfTexts.get(i).getText();
    }

    public boolean isQuestionTextVisible(int i) {
        List<WebElement> listOfTexts = driver.findElements(questionsTexts);
        return listOfTexts.get(i).isDisplayed();
    }

    public void acceptCookies() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(cookiesAcceptButton)).click();
    }
}
