package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CategoryPage;
import pages.HomePage;

import static hooks.Hooks.driver;

public class MultipleFilterSteps {
    HomePage homePage = new HomePage(driver);
    CategoryPage categoryPage = new CategoryPage(driver);

    @When("User navigates to beds category")
    public void userNavigatesToBedsCategory() {
        homePage.navigateToBedsCategory();
    }

    @And("Applys material filter")
    public void applysMaterialFilter() {
        categoryPage.applyMaterialFilter();
    }

    @And("Applys price filter")
    public void applysPriceFilter() {
        categoryPage.applyPriceFilter();
    }

    @Then("The result should match both filters")
    public void theResultShouldMatchBothFilters() {
        Assert.assertTrue(categoryPage.verifyApplyingPrice("10000", "19999"));
    }
}
