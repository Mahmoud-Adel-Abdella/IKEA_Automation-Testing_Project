package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;

import static hooks.Hooks.driver;

public class VerifyCategorySteps {
    HomePage homePage = new HomePage(driver);
    String productName , productPrice;

    @When("User navigates to any category")
    public void userNavigatesToAnyCategory() {
        homePage.navigateToSubCategory();
    }

    @And("Selects any product from the list")
    public void selectsAnyProductFromTheList() {
        productName = homePage.getCategoryProductDetails()[0];
        productPrice = homePage.getCategoryProductDetails()[1];
    }

    @And("Clicks on this products")
    public void clicksOnThisProducts() {
        homePage.navigateToProductPage();
    }

    @Then("The product details in category list should matches the products details in product page")
    public void theProductDetailsInCategoryListShouldMatchesTheProductsDetailsInProductPage() {
        Assert.assertEquals(productName, homePage.getProductPageDetails()[0]);
        Assert.assertEquals(productPrice , homePage.getProductPageDetails()[1]);
    }
}
