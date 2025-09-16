package pages;

import lombok.Value;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.User;

import java.time.Duration;

public class FormPage extends BasePage {
    public WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(User user) {
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.clear();
        usernameInput.sendKeys(user.getUsername());

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.clear();
        emailInput.sendKeys(user.getEmail());

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.clear();
        passwordInput.sendKeys(user.getPassword());

        WebElement confirmPasswordInput = driver.findElement(By.name("confirmPassword"));
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(user.getConfirmPassword());

        WebElement birthDateInput = driver.findElement(By.name("birthDate"));
        birthDateInput.clear();
        birthDateInput.sendKeys(user.getBirthDate());

        WebElement languageLevelInput = driver.findElement(By.name("languageLevel"));
        languageLevelInput.clear();
        languageLevelInput.sendKeys(user.getLanguageLevel());

        WebElement baseUrlLevelInput = driver.findElement(By.name("baseUrl"));
        languageLevelInput.clear();
        languageLevelInput.sendKeys(user.getLanguageLevel());
    }

    public boolean isPasswordsMatch(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public void submitForm() {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
    }

    public WebElement waitForElement(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));


    }
}
}
