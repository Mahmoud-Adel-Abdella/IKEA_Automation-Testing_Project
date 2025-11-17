package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;

import static hooks.Hooks.driver;

public class AddToCartSteps {
    HomePage home = new HomePage(driver);
    String alertText ;

    @Given("User is on home page")
    public void userIsOnHomePage(){
        home.openHomePage();
    }

    @When("User clicks on the product {string}")
    public void userClickOnTheProduct(String productName){
        home.openProduct();
    }

    @And("User clicks on Add to cart button")
    public void userClicksOnAddToCartButton() {
        home.clickAddToCart();
        alertText = home.getAlertText();
    }

    @Then("Alert message should be {string}")
    public void alertMessageShouldBe(String message) {
        //Assertion and only assertions
        Assert.assertEquals(alertText , message , "Alert message mismatch!");
    }
}
