package pages;

import io.cucumber.java.cs.Ale;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {
    //Globals
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Alert alert;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver , Duration.ofSeconds(10));
    }

    public void write(By locator , String item){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(item);
    }

    public void myClick(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }


    public void radioRandomSelect(By locator){
        List<WebElement> radios = driver.findElements(locator);

        Random random = new Random();
        int randomIndex = random.nextInt(radios.size());

        WebElement selector = radios.get(randomIndex);
        selector.click();
    }

    public void dropdownRandomSelect(By locator){
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select selects = new Select(element);

        List<WebElement> options = selects.getOptions();

        Random random = new Random();
        int randomIndex = random.nextInt(options.size());

        selects.selectByIndex(randomIndex);
    }
    
    public void navigateTo(String url){
        driver.get(url);
    }

    public String getAlertText(){
        wait.until(ExpectedConditions.alertIsPresent());

        alert = driver.switchTo().alert();

        String text = alert.getText();
        alert.accept();

        return text;
    }
}
