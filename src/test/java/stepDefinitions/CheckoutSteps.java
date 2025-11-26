package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CheckoutPage;

import static hooks.Hooks.driver;

public class CheckoutSteps {
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @Given("User should be on home page")
    public void userShouldBeOnHomePage() {
        checkoutPage.openHomePage();
    }

    @When("User search for random product like {string} and click add to bag")
    public void userSearchForRandomProductLikeAndClickAddToBag(String arg0) {
        checkoutPage.searchForItem(arg0);
        checkoutPage.addProductToCart();
    }

    @And("User navigates to bag page")
    public void userNavigatesToBagPage() throws InterruptedException {
        checkoutPage.openBagPage();
    }

    @And("clicks on Checkout button")
    public void clicksOnCheckoutButton() {
        checkoutPage.clickCheckout();
    }

    @And("fills billing address with valid data")
    public void fillsBillingAddressWithValidData() {
        checkoutPage.fillBillingAddressInfo();
    }

    @And("User continue to pay")
    public void userContinueToPay() {
        checkoutPage.continueCheckingOut();
    }

    @And("User selects payment method without fill and click Pay")
    public void userSelectsPaymentMethodWithoutFillAndClickPay() {
        checkoutPage.submitPay();
    }

    @Then("Payment is failed and error message appears {string}")
    public void paymentIsFailedAndErrorMessageAppears(String arg0) {
        Assert.assertTrue(checkoutPage.getPaymentErrorMSG().contains(arg0));
    }
}
