package tests;

import driver.BrowserType;
import driver.WebDriverFactory;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.FormPage;
import util.User;

import static org.junit.Assert.assertTrue;

public class FormPageTest extends BasePage {
    protected WebDriver driver;
    private FormPage formPage;
    private User user;

    @BeforeEach
    public void setUp(BrowserType browserType) {
        driver = WebDriverFactory.createDriver(browserType);
        formPage = new FormPage(driver);
        user = new User("test_user", "test@test.com", "password", "password", "1990-01-01", "Beginner");
        driver.get("https://otus.home.kartushin.su");
    }

    @Test
    public void testFillForm() {
        formPage.fillForm(user);
        assertTrue(formPage.isPasswordsMatch(user.getPassword(), user.getConfirmPassword()));
    }


    @Test
    public void testSubmitForm() {
        formPage.fillForm(user);
        formPage.submitForm();
        assertTrue(formPage.submitForm());
    }

    @AfterEach
    public void afterEach() {
        if (driver != null) {
            driver.quit();


        }
    }
}
