package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CategoryPage;
import pages.HomePage;

import static hooks.Hooks.driver;
public class AddToCartSteps {
    HomePage homePage = new HomePage(driver);
    CategoryPage categoryPage = new CategoryPage(driver);

    @When("User clicks on lighting category on home page")
    public void navigateToLightingPage(){
        homePage.navigateToLamps();
    }

    @And("clicks on lamps subcategory")
    public void clicksOnLampsSubcategory() {
    }

    @And("selects a random products and click add to cart twice")
    public void selectsARandomProductsAndClickAddToCartTwice() throws InterruptedException {
        categoryPage.addToCartTwice();
    }

    @Then("the cart quantity should be {int}")
    public void theCartQuantityShouldBe(int arg0) {
        Assert.assertEquals(categoryPage.getCartQuantity(), String.valueOf(arg0));
    }
}
