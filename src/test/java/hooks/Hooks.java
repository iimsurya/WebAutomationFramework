package hooks;

import config.ConfigManager;
import drivers.DriverManager;
import drivers.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setup(){

        System.out.println("HOOK SETUP STARTED");
        String browser = ConfigManager.getInstance().getBrowser();
        WebDriver driver = WebDriverFactory.createDriver(browser);
        DriverManager.setDriver(driver);

    }

    @After
    public void tearDown(){

        DriverManager.quitDriver();
    }
}
