package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.SearchPage;

import static hooks.Hooks.driver;

public class SearchBarSteps {
    SearchPage search = new SearchPage(driver);

    @Given("User should be on home page")
    public void openHomePage(){
        search.openHomePage();
    }

    @When("User enters a product keyword like {string} in search bar")
    public void fillSearchBar(String arg0) {
        search.fillSearch(arg0);
    }

    @And("click the search icon")
    public void clickTheSearchIcon() {}

    @Then("The product displayed should be related to the keyword {string}")
    public void theProductDisplayedShouldBeRelatedToTheKeyword(String arg0) {
        Assert.assertTrue(search.checkResultsRatio(arg0));
    }
}
