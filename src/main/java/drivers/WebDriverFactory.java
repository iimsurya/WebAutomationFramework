package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    public static WebDriver createDriver(String browser){

        WebDriver driver = null;

        try{
            URL gridUrl = new URL("http://localhost:4444");

            if (browser.equalsIgnoreCase("chrome")){
                ChromeOptions options = new ChromeOptions();
                driver = new RemoteWebDriver(gridUrl, options);
            } else if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                driver = new RemoteWebDriver(gridUrl, options);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        DriverManager.setDriver(driver);
        return  DriverManager.getDriver();

    }
}
