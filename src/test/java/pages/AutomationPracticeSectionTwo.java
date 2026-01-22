package pages;

import drivers.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static drivers.DriverManager.driver;

public class AutomationPracticeSectionTwo {

    public WebDriver driver;

    public AutomationPracticeSectionTwo(){
        this.driver = DriverManager.getDriver();
    }

    public void switchWindow() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("openwindow")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "QAClick Academy - A Testing Academy to Learn, Earn and Shine");
        driver.close();
        Thread.sleep(Duration.ofMillis(3000));
        driver.switchTo().window(parentWindow);

        //switch Tab
        driver.findElement(By.id("opentab")).click();
        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> tabIterator = tabs.iterator();
        String parentTab = tabIterator.next();
        String childTab = tabIterator.next();

        driver.switchTo().window(childTab);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "QAClick Academy - A Testing Academy to Learn, Earn and Shine");
        driver.close();
        Thread.sleep(Duration.ofMillis(3000));
        driver.switchTo().window(parentTab);

        //Alert
        driver.findElement(By.name("enter-name")).sendKeys("Surya");
        driver.findElement(By.id("alertbtn")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        driver.findElement(By.id("confirmbtn")).click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        alert2.dismiss();





    }

}
