import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPageQuestionsAccordion;
import org.junit.Test;
import org.junit.Before;


public class MainPageQuestionsAccordionText {
    private WebDriver driver;
    private final String PRICE_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private final String FEW_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private final String TIME_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private final String TODAY_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private final String PROLONG_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private final String CHARGER_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private final String CANCEL_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private final String MCAD_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


    @Before
    public void tearUp() {
        ChromeOptions options = new ChromeOptions(); //Драйвер для браузера
        options.addArguments("start-maximized", "headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void questionPriceHasTheText() {
        MainPageQuestionsAccordion questions = new MainPageQuestionsAccordion(driver);
        questions.openHomePage();
        questions.acceptCookies();
        questions.priceClick();
        Assert.assertTrue(driver.findElement(questions.priceText).isDisplayed());
        Assert.assertEquals(PRICE_TEXT, questions.priceGetText());
    }

    @Test
    public void questionFewHasTheText() {
        MainPageQuestionsAccordion questions = new MainPageQuestionsAccordion(driver);
        questions.openHomePage();
        questions.acceptCookies();
        questions.fewClick();
        Assert.assertTrue(driver.findElement(questions.fewText).isDisplayed());
        Assert.assertEquals(FEW_TEXT, questions.fewGetText());
    }

    @Test
    public void questionTimeHasTheText() {
        MainPageQuestionsAccordion questions = new MainPageQuestionsAccordion(driver);
        questions.openHomePage();
        questions.acceptCookies();
        questions.timeClick();
        Assert.assertTrue(driver.findElement(questions.timeText).isDisplayed());
        Assert.assertEquals(TIME_TEXT, questions.timeGetText());
    }

    @Test
    public void questionOrderTodayHasTheText() {
        MainPageQuestionsAccordion questions = new MainPageQuestionsAccordion(driver);
        questions.openHomePage();
        questions.acceptCookies();
        questions.orderTodayClick();
        Assert.assertTrue(driver.findElement(questions.orderTodayText).isDisplayed());
        Assert.assertEquals(TODAY_TEXT, questions.orderTodayGetText());
    }

    @Test
    public void questionProlongHasTheText() {
        MainPageQuestionsAccordion questions = new MainPageQuestionsAccordion(driver);
        questions.openHomePage();
        questions.acceptCookies();
        questions.prolongClick();
        Assert.assertTrue(driver.findElement(questions.prolongText).isDisplayed());
        Assert.assertEquals(PROLONG_TEXT, questions.prolongGetText());
    }

    @Test
    public void questionChargerHasTheText() {
        MainPageQuestionsAccordion questions = new MainPageQuestionsAccordion(driver);
        questions.openHomePage();
        questions.acceptCookies();
        questions.chargerClick();
        Assert.assertTrue(driver.findElement(questions.chargerText).isDisplayed());
        Assert.assertEquals(CHARGER_TEXT, questions.chargerGetText());
    }

    @Test
    public void questionCancelHasTheText() {
        MainPageQuestionsAccordion questions = new MainPageQuestionsAccordion(driver);
        questions.openHomePage();
        questions.acceptCookies();
        questions.cancelClick();
        Assert.assertTrue(driver.findElement(questions.cancelText).isDisplayed());
        Assert.assertEquals(CANCEL_TEXT, questions.cancelGetText());
    }

    @Test
    public void questionMcadHasTheText() {
        MainPageQuestionsAccordion questions = new MainPageQuestionsAccordion(driver);
        questions.openHomePage();
        questions.acceptCookies();
        questions.mcadClick();
        Assert.assertTrue(driver.findElement(questions.mcadText).isDisplayed());
        Assert.assertEquals(MCAD_TEXT, questions.mcadGetText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
