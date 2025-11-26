package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.FavoritePage;
import pages.HomePage;

import static hooks.Hooks.driver;

public class addToFavoriteSteps {
    HomePage homePage = new HomePage(driver);
    FavoritePage favoritePage = new FavoritePage(driver);

    @Given("User should be on Home page")
    public void userShouldBeOnHomePage() {
        homePage.openHomePage();
    }

    @When("User add a random product to favorite")
    public void userAddARandomProductToFavorite() {
        favoritePage.addProductToFav();
    }

    @And("Clicks View to open favorite page")
    public void clicksViewToOpenFavoritePage() {
        favoritePage.goToFavPage();
    }

    @Then("The product should be displayed before removing")
    public void theProductShouldBeDisplayedBeforeRemoving() {
        Assert.assertTrue(favoritePage.checkProductPresence());
    }

    @And("Removes product form favorites")
    public void removesProductFormFavorites() {
        favoritePage.deleteFavList();
    }
}
