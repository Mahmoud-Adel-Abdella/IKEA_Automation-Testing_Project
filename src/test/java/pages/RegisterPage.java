package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ClickUtils;

public class RegisterPage extends pages.BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    private final By cookiesLocator = By.cssSelector("button[id=\"onetrust-accept-btn-handler\"]");
    private final By firstNameLocator = By.cssSelector("[data-testid=\"first-name\"]");
    private final By lastNameLocator = By.cssSelector("[data-testid=\"last-name\"]");
    private final By emailLocator = By.cssSelector("[data-testid=\"email\"]");
    private final By passwordLocator = By.cssSelector("[data-testid=\"password\"]");
    private final By acceptPolicyCheckbox = By.xpath("//label[@for='privacy-policy-checkbox']");
    private final By createAccountBtn = By.cssSelector("[data-testid=\"sign-up-create-account\"]");


    public void openHomePage() {
        driver.get("https://www.ikea.com/eg/en/");
        checkCookies(cookiesLocator);
    }

    public void NavigateToCreateAccountPage() {
        navigateToAndVerify("https://www.ikea.com/eg/en/profile/sign-up/?openedBy=https%3A%2F%2Fwww.ikea.com%2Feg%2Fen%2F");
    }

    public void fillCredentials(String fName, String lName, String email, String password) {
        write(firstNameLocator, fName);
        write(lastNameLocator, lName);
        write(emailLocator, email);
        write(passwordLocator, password);
        ClickUtils.guaranteedClick(acceptPolicyCheckbox);
    }

    public void submitAccount() {
        ClickUtils.guaranteedClick(createAccountBtn);
    }

}
