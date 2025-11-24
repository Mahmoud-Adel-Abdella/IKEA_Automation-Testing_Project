package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ClickUtils;
import utilities.DataFactory;

import static hooks.Hooks.driver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    private final By usernameLocator = By.cssSelector("[data-testid=\"email\"]");
    private final By passwordLocator = By.cssSelector("[data-testid=\"password\"]");
    private final By loginBtnLocator = By.cssSelector("[data-testid=\"login\"]");
    private final By cookiesLocator = By.cssSelector("button[id=\"onetrust-accept-btn-handler\"]");

    public void openLoginPage(){
        driver.get("https://www.ikea.com/eg/en/profile/login/");
        checkCookies(cookiesLocator);
    }

    public void fillCredentials(){
        write(usernameLocator , DataFactory.getEmail());
        write(passwordLocator, DataFactory.getPassword());
        ClickUtils.guaranteedClick(loginBtnLocator);
    }
}
