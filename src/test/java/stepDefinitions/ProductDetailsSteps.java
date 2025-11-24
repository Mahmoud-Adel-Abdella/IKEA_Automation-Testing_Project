package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductPage;

import static hooks.Hooks.driver;

public class ProductDetailsSteps {
    HomePage home = new HomePage(driver);
    ProductPage productPage = new ProductPage(driver);

    String productName , productPrice;

    @Given("User should be on home page.")
    public void userShouldBeOnHomePage() {
        home.openHomePage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.ikea.com/eg/en/");
    }

    @When("User clicks on a random product on the home page")
    public void selectRandomProduct(){
        productName = home.getProductName();
        productPrice = String.valueOf(home.getProductPrice());
        home.navigateToProductPage();
    }

    @Then("The product details page should be opened")
    public void theProductDetailsPageShouldBeOpened() {
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.ikea.com/eg/en/p/"));
    }

    @And("The product details in the home page matches the details in the product page")
    public void theProductDetailsInTheHomePageMatchesTheDetailsInTheProductPage() {
        Assert.assertEquals(productName , productPage.getProductName());
        Assert.assertEquals(productPrice , String.valueOf(productPage.getProductPrice()));
    }


}
