package tests;

import driver.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.FormPage;
import util.User;

import static org.junit.Assert.assertTrue;

public class FormPageTest {
    private WebDriver driver;
    private FormPage formPage;
    private User user;

    @Before
    public void setUp() {
        driver = WebDriverFactory.createDriver("chrome");
        formPage = new FormPage(driver);
        user = new User("test_user", "test@test.com", "password", "password", "1990-01-01", "Beginner");
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

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
