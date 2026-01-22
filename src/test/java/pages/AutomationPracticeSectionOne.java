package pages;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.Utilities;

import java.time.Duration;

public class AutomationPracticeSectionOne {

    private final WebDriver driver;

    //locators
    private final By radioBtn = By.xpath("//input[@value='radio1']");
    private final By countryInputBox = By.xpath("//input[@placeholder='Type to Select Countries']");
    private final By dropDown = By.cssSelector("#dropdown-class-example");
    private final By dropDownAutoComplete = By.cssSelector("ul.ui-autocomplete li");
    private final By checkBox = By.xpath("//div[@id='checkbox-example']//input[@value= 'option1']");

    SoftAssert softAssert = new SoftAssert();

    public AutomationPracticeSectionOne(){
        this.driver = DriverManager.getDriver();
    }

    public void openPracticeWebsite(){
        driver.get(Utilities.getValueofProperty("url"));
    }

    public void selectRadioButton(){
        WebElement radioButton = driver.findElement(radioBtn);
        radioButton.click();

        boolean radioBtnEnabled = radioButton.isEnabled();
        boolean radioBtnEnabledSelected = radioButton.isSelected();


        softAssert.assertTrue(radioBtnEnabledSelected);
    }
    public void chooseCountry(){
        WebElement CountryInput = driver.findElement((countryInputBox));
        CountryInput.sendKeys(Utilities.getValueofProperty("country"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                dropDownAutoComplete , 0));

        CountryInput.sendKeys(Keys.ARROW_DOWN);
        CountryInput.sendKeys(Keys.ENTER);
    }
    public void selectOptionFromDropdown(){
        Select selectDropDown = new Select(driver.findElement(dropDown));
        selectDropDown.selectByVisibleText("Option3");
    }
    public void selectCheckBox(){
        WebElement option1 = driver.findElement(checkBox);
        option1.click();
        option1.getText();
    }

    public void quitBrowser() throws InterruptedException {
        Thread.sleep(Duration.ofMillis(6000));

    }
}
