package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ClickUtils;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By cookiesLocator = By.cssSelector("button[id=\"onetrust-accept-btn-handler\"]");

    private final By lightingCategoryLinkLocator = By.cssSelector("[class=\"hnf-carousel-slide\"] [href=\"https://www.ikea.com/eg/en/cat/lighting-li001/\"]");
    private final By lampsSubCategoryLinkLocator = By.cssSelector("[href=\"https://www.ikea.com/eg/en/cat/lamps-li002/\"]");

    private final By footerLocator = By.xpath("//footer[@role='contentinfo']");
    private final By termsAndConditionsLinkLocator = By.cssSelector("div[class='hnf-flex-row hnf-flex-row--nowrap'] li:nth-child(4) a:nth-child(1)");
    private final By termsAndConditionsHeaderLocator = By.xpath("(//h1[normalize-space()='Terms and conditions'])[1]");

    private final By languageSelectBtnLocator = By.cssSelector("[class=\"hnf-utilities__localisation-button\"] a");
    private final By arabicSelectBtnLocator = By.xpath("//span[contains(text(),'العربية')]");
    private final By languageLabelLocator = By.cssSelector("div[class='hnf-utilities__localisation-button'] a");
    private final By welcomeMSGLocator = By.cssSelector("[class=\"_titleContainer_185nw_73\"] h1");

    private final By storeSelectLocator = By.cssSelector("[class=\"hnf-link hnf-link--white hnf-link--subtle hnf-utilities__storepicker-button\"]");
    private final By differentStoreLocator = By.cssSelector("div[id='choice-631'] button[type='button']");
    private final By newStoreLabelLocator = By.xpath("//span[@class='hnf-utilities__value']");

    private final By categoryProductLocator = By.xpath("(//div[@class='plp-fragment-wrapper plp-fragment-wrapper--grid'])[4]//div[@data-currency=\"EGP\"]");
    private final By productPageNameLocator = By.cssSelector("h1[class='pipcom-text pipcom-typography-heading-s'] span[class='pipcom-price-module__name-decorator notranslate']");
    private final By productPagePriceLocator = By.cssSelector("span[class='pipcom-price pipcom-price--leading pipcom-price--leading pipcom-price--medium pipcom-price--currency-super-aligned pipcom-price--decimal-super-aligned pipcom-price-module__current-price'] span[class='pipcom-price__integer']");


    private final By bedsCategoryLinkLocator = By.xpath("//div[@id='hnf-carousel__tabs-navigation-products']//div[10]//a");
    private final By bedsSubcategoryLinkLocator = By.xpath("//a[@class='hnf-link hnf-link--subtle'][normalize-space()='Beds']");

    private final By productHomeFavBtnLocator = By.xpath("//button[@aria-label='Save to shopping list, BERGVATTNET, bath mat, blue']");

    public void openHomePage() {
        driver.get("https://www.ikea.com/eg/en/");
        checkCookies(cookiesLocator);
    }


    //Add To Favorite Feature
    public void navigateToLamps() {
        click(lightingCategoryLinkLocator);
        click(lampsSubCategoryLinkLocator);
    }


    //Footer Links Feature
    public void scrollToFooter() {
        actions.moveToElement(getWebElement(footerLocator));
    }

    public void navigateToTermsAndConditionPage() {
        ClickUtils.guaranteedClick(termsAndConditionsLinkLocator);
    }

    public String[] verifyExistingPage() {
        return new String[]{
                read(termsAndConditionsHeaderLocator),
                driver.getTitle()
        };
    }


    //Change Language Feature
    public void locateLanguageSelector() {
        ClickUtils.guaranteedClick(languageSelectBtnLocator);
    }

    public void setArabicLanguage() {
        ClickUtils.guaranteedClick(arabicSelectBtnLocator);
    }

    public String[] verifySwitchLanguage() {
        return new String[]{
                read(languageLabelLocator),
                read(welcomeMSGLocator)
        };
    }


    //Change Store Feature
    public void chooseDifferentStore() {
        ClickUtils.guaranteedClick(storeSelectLocator);
    }

    public String clickAndReadStoreInfo() throws InterruptedException {
        ClickUtils.guaranteedClick(differentStoreLocator);
        return read(newStoreLabelLocator);
    }


    //Verify category page feature
    public void navigateToSubCategory() {
        navigateToLamps();
    }

    public String[] getCategoryProductDetails() {
        return new String[]{
                readByAttribute(categoryProductLocator, "data-product-name"),
                String.valueOf(readDigits(readByAttribute(categoryProductLocator, "data-price")))
        };
    }

    public void navigateToProductPage() {
        ClickUtils.guaranteedClick(categoryProductLocator);
    }

    public String[] getProductPageDetails() {
        return new String[]{
                read(productPageNameLocator),
                String.valueOf(readDigits(read(productPagePriceLocator)))
        };
    }

    //Multiple Filter Feature
    public void navigateToBedsCategory(){
        ClickUtils.guaranteedClick(bedsCategoryLinkLocator);
        ClickUtils.guaranteedClick(bedsSubcategoryLinkLocator);
    }

    //Favorite Persistence in Session
    public void addProductToFav(){
        ClickUtils.guaranteedClick(productHomeFavBtnLocator);
    }

    public void navigateToAnotherPage(){
        navigateToSubCategory();
    }
}
