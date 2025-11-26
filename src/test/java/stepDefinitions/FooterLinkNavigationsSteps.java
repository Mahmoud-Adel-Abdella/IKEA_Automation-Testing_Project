package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;

import static hooks.Hooks.driver;

public class FooterLinkNavigationsSteps {
    HomePage homePage = new HomePage(driver);

    @When("User scrolls to footer")
    public void userScrollsToFooter() {
        homePage.scrollToFooter();
    }

    @And("Click on footer link \\(Terms and Conditions)")
    public void clickOnFooterLinkTermsAndConditions() {
        homePage.navigateToTermsAndConditionPage();
    }

    @Then("The user should be redirected to \\(Terms and Conditions) Page")
    public void theUserShouldBeRedirectedToTermsAndConditionsPage() {
        Assert.assertTrue(homePage.verifyExistingPage()[0].contains("Terms and conditions"));
        Assert.assertTrue(homePage.verifyExistingPage()[1].contains("Terms and conditions"));
    }
}
