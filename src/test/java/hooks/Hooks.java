package hooks;

import drivers.DriverManager;
import drivers.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static drivers.DriverManager.driver;

public class Hooks {

    @Before
    public void setup(){

        System.out.println("HOOK SETUP STARTED");
        String browser = System.getProperty("browser","chrome");
        WebDriver driver = WebDriverFactory.createDriver(browser);
        DriverManager.getDriver();

    }

    @After
    public void tearDown(){

        DriverManager.quitDriver();
    }

    @After
    public void screenshotOnFailure(Scenario scenario){

        if(scenario.isFailed()){
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(src, new File(scenario.getName() + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
