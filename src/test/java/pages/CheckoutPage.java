package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ClickUtils;
import utilities.DataFactory;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    HomePage homePage = new HomePage(driver);
    SearchPage searchPage = new SearchPage(driver);


    private final By productsResultLocator = By.cssSelector("[class=\"plp-product-list__products  \"] [class=\"plp-fragment-wrapper plp-fragment-wrapper--grid\"] [class=\"plp-productcard-button-row\"] button:nth-child(1)");
    private final By cartBtnLocator = By.xpath("//span[@class='hnf-btn__inner js-shopping-cart-icon']");
    private final By checkoutBtnLocator = By.xpath("//button[contains(@class,'cart-noOutline')]//span[contains(@class,'cart-btn__inner')]");

    private final By fullNameLocator = By.xpath("(//input[@id='NewAddress_FirstName'])[1]");
    private final By governorateSelectLocator = By.xpath("//select[@id='NewAddress_AreaId']");
    private final By areaSelectLocator = By.xpath("//select[@id='NewAddress_CityAreaId']");
    private final By emailLocator = By.xpath("(//input[@id='NewAddress_Email'])[1]");
    private final By phoneNumberLocator = By.xpath("(//input[@id='NewAddress_PhoneNumber'])[1]");
    private final By addressLocator = By.xpath("(//input[@id='NewAddress_Address1'])[1]");
    private final By buildingInfoLocator = By.xpath("(//input[@id='NewAddress_Address2'])[1]");
    private final By continueBtn1Locator = By.xpath("//button[@id='billingSubmitButton']");
    private final By continueBtn2Locator = By.xpath("//button[@id='deliveryAndAssemblyContinue']");

    private final By paymentMethodRadioLocator = By.xpath("(//span[@class='checkmark'])[5]");
    private final By finalPayBtnLocator = By.xpath("//button[normalize-space()='Pay']");
    private final By paymentErrorMSGLocator = By.xpath("//span[@class='canceled']");


    public void openHomePage(){
        homePage.openHomePage();
    }

    public void searchForItem(String title){
        searchPage.fillSearch(title);
    }

    public void addProductToCart(){
        randomClick(productsResultLocator);
    }

    public void openBagPage() throws InterruptedException {
        Thread.sleep(1000);
        ClickUtils.guaranteedClick(cartBtnLocator);
    }

    public void clickCheckout(){
        ClickUtils.guaranteedClick(checkoutBtnLocator);
    }

    public void fillBillingAddressInfo(){
        write(fullNameLocator , DataFactory.getFullName());
        dropdownRandomSelect(governorateSelectLocator);
        dropdownRandomSelect(areaSelectLocator);
        write(emailLocator , DataFactory.getEmail());
        write(phoneNumberLocator , DataFactory.getPhoneNumber());
        write(addressLocator, DataFactory.getAddress());
        write(buildingInfoLocator , DataFactory.getExtraAddress());
    }

    public void continueCheckingOut(){
        ClickUtils.guaranteedClick(continueBtn1Locator);
        ClickUtils.guaranteedClick(continueBtn2Locator);
    }

    public void submitPay(){
        ClickUtils.guaranteedClick(paymentMethodRadioLocator);
        ClickUtils.guaranteedClick(finalPayBtnLocator);
    }

    public String getPaymentErrorMSG(){
        return read(paymentErrorMSGLocator);
    }
}
