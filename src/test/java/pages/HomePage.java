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
    private final By arabicSelectBtnLocator= By.xpath("//span[contains(text(),'العربية')]");
    private final By languageLabelLocator = By.cssSelector("div[class='hnf-utilities__localisation-button'] a");
    private final By welcomeMSGLocator= By.cssSelector("[class=\"_titleContainer_185nw_73\"] h1");

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
    public void scrollToFooter(){
        actions.moveToElement(getWebElement(footerLocator));
    }

    public void navigateToTermsAndConditionPage(){
        ClickUtils.guaranteedClick(termsAndConditionsLinkLocator);
    }

    public String[] verifyExistingPage(){
        return new String[]{
                read(termsAndConditionsHeaderLocator),
                driver.getTitle()
        };
    }

    //Change Language Feature
    public void locateLanguageSelector(){
        ClickUtils.guaranteedClick(languageSelectBtnLocator);
    }

    public void setArabicLanguage(){
        ClickUtils.guaranteedClick(arabicSelectBtnLocator);
    }

    public String[] verifySwitchLanguage(){
        return new String[] {
               read(languageLabelLocator),
               read(welcomeMSGLocator)
        };
    }
}
