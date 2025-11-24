package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By cookiesLocator = By.cssSelector("button[id=\"onetrust-accept-btn-handler\"]");
    private final By productHomeLocator = By.xpath("(//div[@class='pip-product-compact prod_under_offer Online_Only_wow_offer lang_en'])[3]");
    private final By productPageLocator = By.cssSelector("[href=\"https://www.ikea.com/eg/en/p/dvala-fitted-sheet-light-grey-80482453/\"]");

    private final By lightingCategoryLinkLocator = By.cssSelector("[class=\"hnf-carousel-slide\"] [href=\"https://www.ikea.com/eg/en/cat/lighting-li001/\"]");
    private final By lampsSubCategoryLinkLocator = By.cssSelector("[href=\"https://www.ikea.com/eg/en/cat/lamps-li002/\"]");

    public void openHomePage(){
        driver.get("https://www.ikea.com/eg/en/");
        checkCookies(cookiesLocator);
        click(By.xpath("(//button[normalize-space()='Recommended for you'])[1]"));
    }

    public String getProductName(){
        return readByAttribute(productHomeLocator , "data-product-name");
    }

    public double getProductPrice(){
        return readDigits(readByAttribute(productHomeLocator , "data-price"));
    }

    public void navigateToProductPage(){
        click(productPageLocator);
    }


    public void navigateToLamps (){
        click(lightingCategoryLinkLocator);
        click(lampsSubCategoryLinkLocator);
    }
}
