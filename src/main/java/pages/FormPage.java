package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormPage {
    private final WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(String username, String email, String password, String confirmPassword, String birthDate, String languageLevel) {
        WebElement userInput = driver.findElement(By.name("username"));
        userInput.sendKeys(username);

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);

        WebElement confirmPasswordInput = driver.findElement(By.name("confirm_password"));
        confirmPasswordInput.sendKeys(confirmPassword);

        WebElement birthDateInput = driver.findElement(By.name("birth_date"));
        birthDateInput.sendKeys(birthDate);

        WebElement languageLevelSelect = driver.findElement(By.name("language_level"));
        languageLevelSelect.sendKeys(languageLevel);
    }

    public boolean isPasswordsMatch(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public void submitForm() {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
    }
}
