package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {
    //Globals
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected Actions actions;
    protected Faker faker;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        faker = new Faker();
//        PageFactory.initElements(driver, this);
    }

    public void write(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public String read(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        return element.getText();
    }

    public String readByAttribute(By locator , String attribute){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        return element.getAttribute(attribute);
    }

    public double readDigits(By locator) {
        return Double.parseDouble(read(locator).replaceAll("[^0-9]", ""));
    }

    public double readDigits(String text) {
        return Double.parseDouble(text.replaceAll("[^0-9]", ""));
    }

    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.moveToElement(element).perform();

        wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.scrollToElement(element).perform();
        element.click();
    }

    public void checkCookies(By locator){
        WebElement element = driver.findElement(locator);
        if (element.isDisplayed()) click(locator);
    }

    public void radioRandomSelect(By locator) {
        List<WebElement> radios = driver.findElements(locator);

        Random random = new Random();
        int randomIndex = random.nextInt(radios.size());

        WebElement selector = radios.get(randomIndex);
        selector.click();
    }

    public void dropdownRandomSelect(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select selects = new Select(element);

        List<WebElement> options = selects.getOptions();

        Random random = new Random();
        int randomIndex = random.nextInt(options.size());

        selects.selectByIndex(randomIndex);
    }

    public String getAttribute(By locator, String attribute) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getAttribute(attribute);
    }

    public void navigateToAndVerify(String url) {
        driver.navigate().to(url);

        String currentURL = driver.getCurrentUrl();

        assert currentURL != null;
        if (currentURL.equals(url)) {
            System.out.println("Navigated Successfully to : " + url);
        } else {
            System.out.println("URL mismatch!...");
        }
    }

    public boolean ratioAssert(By locator, String title) {
        List<WebElement> elements = driver.findElements(locator);

        int found = 0;
        int size = elements.size();

        for (WebElement element : elements) {
            String productTitle = element.getText().toLowerCase();

            if (productTitle.contains(title)) {
                found++;
            }
        }

        return size / 4 < found;
    }
}
