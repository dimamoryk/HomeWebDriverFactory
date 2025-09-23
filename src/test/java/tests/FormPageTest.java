package tests;

import driver.BrowserType;
import driver.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.FormPage;
import util.User;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormPageTest extends BasePage {
    private WebDriver driver;
    private FormPage formPage;
    private User user;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.createDriver(BrowserType.CHROME);
        formPage = new FormPage(driver);
        user = new User("test_user", "test@test.com", "password", "password", "1990-01-01", "Beginner");
        driver.get("baseUrl");
    }

    @Test
    @DisplayName("Заполнение формы и проверка совпадения паролей")
    public void testFillForm() {
        formPage.fillForm(user);
        assertTrue(formPage.isPasswordsMatch(user.getPassword(), user.getConfirmPassword()), "Пароли совпадают.");
    }


    @Test
    @DisplayName("Отправка заполненной формы")
    public void testSubmitForm() {
        formPage.fillForm(user);
        assertTrue(formPage.submitForm(), "Форма отправлена успешно.");
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
