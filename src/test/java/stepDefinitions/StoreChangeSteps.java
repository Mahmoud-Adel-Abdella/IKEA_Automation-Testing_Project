package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;

import static hooks.Hooks.driver;

public class StoreChangeSteps {
    HomePage homePage = new HomePage(driver);

    @Given("User is on home page")
    public void userIsOnHomePage() {
        homePage.openHomePage();
    }

    @When("User clicks on Stores from top menu")
    public void userClicksOnStoresFromTopMenu() {
        homePage.chooseDifferentStore();
    }

    @And("Selects any Store from list")
    public void selectsAnyStoreFromList() {}

    @Then("The Store details should be displayed and matches Store details")
    public void theStoreDetailsShouldBeDisplayedAndMatchesStoreDetails() throws InterruptedException {
        Assert.assertEquals(homePage.clickAndReadStoreInfo() , "Mall of Arabia");
    }
}
