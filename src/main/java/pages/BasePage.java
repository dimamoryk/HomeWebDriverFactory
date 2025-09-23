package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }


    private static String getBaseUrl() {

        return System.getProperty("host", "baseUrl");
    } // Получение базовой URL из системных свойств

    // Метод для открытия страницы по указанному пути
    public void open(String relativePath) {
        String baseUrl = getBaseUrl();
        driver.get(baseUrl + relativePath); // Добавляем относительный путь к основному адресу
    }

    public WebElement waitForElement(WebElement element) {
        return wait.until((d) -> element.isDisplayed());
    }

    public void navigateToFormPage() {
        driver.get("baseUrl");
    }
}
