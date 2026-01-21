package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationPracticeSectionOne {

    public static WebDriver driver;
    public void openPracticeWebsite(){
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    public void selectRadioButton(){
        WebElement radioBtn = driver.findElement(By.xpath("//input[@value='radio1']"));
        radioBtn.click();
        System.out.println(radioBtn.isEnabled());
        System.out.println(radioBtn.isSelected());
    }
    public void chooseCountry(){
        WebElement input = driver.findElement((By.xpath("//input[@placeholder='Type to Select Countries']")));
        input.sendKeys("Ind");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.cssSelector("ul.ui-autocomplete li"), 0));

        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.ENTER);
    }
    public void selectOptionFromDropdown(){
        Select dropDown = new Select(driver.findElement(By.cssSelector("#dropdown-class-example")));
        dropDown.selectByVisibleText("Option3");
    }
    public void selectCheckBox(){
        WebElement option1 = driver.findElement(By.xpath("//div[@id='checkbox-example']//input[@value= 'option1']"));
        option1.click();
        option1.getText();
    }

    public void quitBrowser() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(6));
        driver.quit();
    }
}
