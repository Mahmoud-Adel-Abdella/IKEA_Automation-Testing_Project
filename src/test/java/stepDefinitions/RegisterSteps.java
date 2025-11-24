package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.RegisterPage;
import utilities.DataFactory;

import static hooks.Hooks.driver;

public class RegisterSteps {
    RegisterPage accountPage = new RegisterPage(driver);

    //Steps
    @Given("User is on Home Page")
    public void openHomePage(){
        accountPage.openHomePage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.ikea.com/eg/en/");
    }

    @When("User navigates to create account page")
    public void navigateToCreateAccountPage() {
        accountPage.NavigateToCreateAccountPage();
    }

    @And("User enters valid credentials and accepts policy")
    public void enterValidCredentials() {
        accountPage.fillCredentials(DataFactory.getFirstName() , DataFactory.getLastName(), DataFactory.getEmail(), DataFactory.getPassword());
    }

    @And("User enters Create Account Button")
    public void clickCreateAccountButton() {
        accountPage.submitAccount();
    }

    @Then("User should be redirected to profile page")
    public void userShouldBeRedirectedToProfilePage() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl() , "https://www.ikea.com/eg/en/profile/");
    }


}
