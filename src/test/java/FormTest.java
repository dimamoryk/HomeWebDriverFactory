import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.FormPage;

public class FormTest {
    private static WebDriver driver;
    private static FormPage formPage;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup(); // Подготовка драйвера Chrome
        driver = new ChromeDriver();
        formPage = new FormPage(driver);
        driver.get("https://otus.home.kartushin.su/form.html"); // Переход на страницу
    }

    @Test
    public void testFillAndSubmitForm() throws Exception {
        formPage.fillForm(
                "Иван Иванов",
                "ivan@example.com",
                "secretPass123",
                "secretPass123",
                "1990-01-01",
                "Intermediate"
        );

        Assert.assertTrue(formPage.isPasswordsMatch("secretPass123", "secretPass123"), "Пароли не совпадают!");
        formPage.submitForm();
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}