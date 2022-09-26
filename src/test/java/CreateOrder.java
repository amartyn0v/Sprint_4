
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Order;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CreateOrder {
    private WebDriver driver;
    private String name;
    private String surname;
    private String address;
    private String tube;
    private String phone;
    private String date;
    private int days;
    private String colour;
    private String comment;

    public CreateOrder(String name, String surname, String address, String tube, String phone, String date, int days, String colour, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.tube = tube;
        this.phone = phone;
        this.date = date;
        this.days = days;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] formData() {
        return new Object[][]{
                {"Пабло", "Пикассо", "г. Москва, ул. Красных Коммунаров, д9, кв 97", "Южная", "+79277777777", "30.10.2022", 5, "Black", "Короткий комментарий"},
                {"Ян", "Ли", "г. Москва", "Черкизовская", "89277777777", "02.11.2045", 1, "Gray", "Короткий комментарий"},
        };
    }

    @Before
    public void tearUp() {
        ChromeOptions options = new ChromeOptions(); //Драйвер для браузера
        options.addArguments("start-maximized", "headless");
        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown() {
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.quit();
    }

    @Test
    public void makeOrderFromHeader() {
        Order order = new Order(driver);
        driver.get("https://qa-scooter.praktikum-services.ru");
        order.acceptCookies();
        order.clickHeaderOrderButton();
        order.fillName(name);
        order.fillSurname(surname);
        order.fillAddress(address);
        order.fillTube(tube);
        order.fillPhone(phone);
        order.clickProceedButton();
        order.fillDate(date);
        order.chooseAmount(days);
        if (colour == "Black") {
            order.chooseBlackColour();
        } else {
            order.chooseGrayColour();
        }
        order.fillComment(comment);
        order.finishOrder();
        order.confirmOrder();
        assertTrue(order.isConfirmationTextVisible());
    }

    @Test
    public void makeOrderFromMiddle() {
        Order order = new Order(driver);
        driver.get("https://qa-scooter.praktikum-services.ru");
        order.acceptCookies();
        order.clickMiddleOrderButton();
        order.fillName(name);
        order.fillSurname(surname);
        order.fillAddress(address);
        order.fillTube(tube);
        order.fillPhone(phone);
        order.clickProceedButton();
        order.fillDate(date);
        order.chooseAmount(days);
        if (colour == "Black") {
            order.chooseBlackColour();
        } else {
            order.chooseGrayColour();
        }
        order.fillComment(comment);
        order.finishOrder();
        order.confirmOrder();
        assertTrue(order.isConfirmationTextVisible());
    }
}
