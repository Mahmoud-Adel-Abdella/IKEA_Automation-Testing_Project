package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;

import static hooks.Hooks.driver;

public class ChangeLanguageSteps {
    HomePage homePage = new HomePage(driver);

    @When("User click on language select button")
    public void userClickOnLanguageSelectButton() {
        homePage.locateLanguageSelector();
    }

    @And("Selects Arabic language")
    public void selectsArabicLanguage() {
        homePage.setArabicLanguage();
    }

    @Then("The page content should be is in Arabic")
    public void thePageContentShouldBeIsInArabic() {
        Assert.assertEquals(driver.getCurrentUrl() , "https://www.ikea.com/eg/ar/");
        Assert.assertEquals(homePage.verifySwitchLanguage()[0] , "EGالعربية");
        Assert.assertEquals(homePage.verifySwitchLanguage()[1] , "مرحباً في ايكيا مصر!");
    }
}
