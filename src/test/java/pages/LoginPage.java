package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    String userName = "Admin";
    String password = "admin123";
    String loginPageURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    private final By usernameLocator = By.cssSelector("input[placeholder='Username']");
    private final By passwordLocator = By.cssSelector("input[placeholder='Password']");
    private final By loginBtnLocator = By.cssSelector("button[type='submit']");


    public void navigateToLoginPage(){
        navigateTo(loginPageURL);
    }

    public void fillCredentials (){
        write(usernameLocator , userName);
        write(passwordLocator , password);
    }

    public void submitLogin(){
        myClick(loginBtnLocator);
    }
}
