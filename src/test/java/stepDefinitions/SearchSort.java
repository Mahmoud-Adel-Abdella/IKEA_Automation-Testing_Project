package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.SearchPage;

import static hooks.Hooks.driver;

public class SearchSort {
    SearchPage searchPage = new SearchPage(driver);

    @Given("User is on the home page")
    public void userIsOnTheHomePage() {
        searchPage.openHomePage();
    }

    @When("User Search for {string}")
    public void userSearchFor(String arg0) {
        searchPage.fillSearch(arg0);
    }

    @And("Apply filter Price: Low to High")
    public void applyFilterPriceLowToHigh() throws InterruptedException {
        searchPage.selectLowToHighPriceSort();
    }

    @Then("The results must be sorted correctly")
    public void theResultsMustBeSortedCorrectly() {
        Assert.assertTrue(searchPage.checkLowToHighPriceSort());
    }
}
