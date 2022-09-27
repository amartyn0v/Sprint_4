import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPageQuestionsAccordion;


@RunWith(Parameterized.class)
public class MainPageQuestionsAccordionText {
    private WebDriver driver;
    private int question;
    private String expectedText;

    public MainPageQuestionsAccordionText(int question, String expectedText) {
        this.question = question;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] formData() {
        return new Object[][]{
                {0, PRICE_TEXT},
                {1, FEW_TEXT},
                {2, TIME_TEXT},
                {3, TODAY_TEXT},
                {4, PROLONG_TEXT},
                {5, CHARGER_TEXT},
                {6, CANCEL_TEXT},
                {7, MCAD_TEXT},
        };
    }

    private static final String PRICE_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String FEW_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String TIME_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String TODAY_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static final String PROLONG_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String CHARGER_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String CANCEL_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String MCAD_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


    @Before
    public void tearUp() {
        ChromeOptions options = new ChromeOptions(); //Драйвер для браузера
        options.addArguments("start-maximized", "headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void questionHasTheText() {
        MainPageQuestionsAccordion questions = new MainPageQuestionsAccordion(driver);
        questions.openHomePage();
        questions.acceptCookies();
        questions.questionClick(question);
        Assert.assertTrue(questions.isQuestionTextVisible(question));
        Assert.assertEquals(expectedText, questions.questionGetText(question));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
