package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    public static WebDriver createDriver(String browser){

        if(browser.equalsIgnoreCase("chrome")){
            return new ChromeDriver();
        }

        throw new RuntimeException ("Browser not Supported");
    }
}
