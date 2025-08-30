package driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {

    public static WebDriver create(String webDriverName, Object... options) {
        switch(webDriverName.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // путь к драйверу хрома
                if(options.length > 0 && options[0] instanceof org.openqa.selenium.chrome.ChromeOptions) {
                    return new ChromeDriver((org.openqa.selenium.chrome.ChromeOptions) options[0]);
                } else {
                    return new ChromeDriver();
                }

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver"); // путь к драйверу firefox
                if(options.length > 0 && options[0] instanceof org.openqa.selenium.firefox.FirefoxOptions) {
                    return new FirefoxDriver((org.openqa.selenium.firefox.FirefoxOptions) options[0]);
                } else {
                    return new FirefoxDriver();
                }

            default:
                throw new IllegalArgumentException("Unsupported browser type: " + webDriverName);
        }
    }
}
