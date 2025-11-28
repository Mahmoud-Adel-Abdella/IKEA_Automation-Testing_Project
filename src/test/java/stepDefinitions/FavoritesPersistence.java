package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.FavoritePage;
import pages.HomePage;

import static hooks.Hooks.driver;

public class FavoritesPersistence {
    HomePage homePage = new HomePage(driver);
    FavoritePage favoritePage = new FavoritePage(driver);


    @When("User adds product to cart")
    public void userAddsProductToCart() {
        homePage.addProductToFav();
    }

    @And("User navigates to any category or page")
    public void userNavigatesToAnyCategoryOrPage() {
        homePage.navigateToAnotherPage();
    }

    @And("Returns to favorites page")
    public void returnsToFavoritesPage() {
        favoritePage.goToFavPage();
    }

    @Then("Verify that the product is displayed")
    public void verifyThatTheProductIsDisplayed() {
        Assert.assertTrue(favoritePage.checkProductPresence());
    }

    @When("Deletes the products")
    public void deletesTheProducts() {
        favoritePage.deleteFavList();
    }

    @Then("Verify that the remove message is displayed")
    public void verifyThatTheRemoveMessageIsDisplayed() {
        Assert.assertTrue(favoritePage.checkRemoveMSG());
    }
}
