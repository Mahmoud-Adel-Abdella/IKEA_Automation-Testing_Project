package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.PIM_Page;

import static hooks.Hooks.driver;

public class AddEmployeeSteps {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    PIM_Page pimPage = new PIM_Page(driver);

    @Given("User should be logged In")
    public void userShouldBeLoggedIn (){
        loginPage.navigateToLoginPage();
        loginPage.fillCredentials();
        loginPage.submitLogin();
    }

    @When("User navigate to the PIM module")
    public void userNavigateToThePIMModule() {

    }

    @And("User fills the Employee name field with {string}")
    public void userFillsTheEmployeeNameFieldWith(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("User clicks on Search Button")
    public void userClicksOnSearchButton() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("Row of Employee details should be displayed")
    public void rowOfEmployeeDetailsShouldBeDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("The cell First Name content should matches the name field")
    public void theCellFirstNameContentShouldMatchesTheNameField() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
