package drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager (){

    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void setDriver(WebDriver driverRef){
        driver.set(driverRef);
    }

    public static void quitDriver(){
        if(driver.get() != null){
            driver.get().quit();
            driver.remove();
        }
    }
}
