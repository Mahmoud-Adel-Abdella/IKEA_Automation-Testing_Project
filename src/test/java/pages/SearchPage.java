package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ClickUtils;

import javax.swing.event.CaretListener;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    HomePage homePage = new HomePage(driver);

    private final By searchBarLocator = By.xpath("//input[@id='ikea-search-input']");
    private final By searchBtnLocator = By.xpath("(//span[@class='search-box-typography-label-s search-box-btn__inner'])[2]");
    private final By productsTitleLocator = By.cssSelector("[class=\"plp-product-list__products  \"] [class=\"plp-fragment-wrapper plp-fragment-wrapper--grid\"] [class=\"plp-price__integer\"]");

    private final By sortListBtn = By.xpath("//span[normalize-space()='Sort']");
    private final By lowToHighSortBtn = By.xpath("(//label[contains(@class,'plp-radio-button')])[2]");



    public void openHomePage() {
        homePage.openHomePage();
    }

    public void fillSearch(String title) {
        write(searchBarLocator, title);
        click(searchBtnLocator);
    }

    public Boolean checkResultsRatio(String title) {
        return ratioAssert(productsTitleLocator, title);
    }

    public void selectLowToHighPriceSort() throws InterruptedException {
        ClickUtils.guaranteedClick(sortListBtn);
        ClickUtils.guaranteedClick(lowToHighSortBtn);
        ClickUtils.guaranteedClick(sortListBtn);
    }

    public boolean checkLowToHighPriceSort() {
        return verifySort(productsTitleLocator);
    }
}