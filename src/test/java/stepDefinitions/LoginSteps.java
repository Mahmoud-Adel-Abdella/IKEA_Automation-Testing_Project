package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;

import static hooks.Hooks.driver;

public class LoginSteps {
    LoginPage login = new LoginPage(driver);

    @Given("The user should be registered before")
    public void Register() {
    }


    @When("User Click on login button")
    public void clickOnLoginLink() {
        login.openLoginPage();
    }

    @And("Enters Valid email and password")
    public void entersValidEmailAndPassword() {
        login.fillCredentials();
    }

    @And("Click on Login button")
    public void clickOnLoginButton() {

    }

    @Then("User must be redirected to profile page")
    public void userMustBeRedirectedToProfilePage() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.ikea.com/eg/en/profile/");
    }
}
