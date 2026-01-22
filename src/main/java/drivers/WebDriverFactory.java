package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    public static WebDriver createDriver(String browser){

        if(browser.equalsIgnoreCase("chrome")){
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            return new SafariDriver();
        }

        throw new RuntimeException ("Browser not Supported");
    }
}
