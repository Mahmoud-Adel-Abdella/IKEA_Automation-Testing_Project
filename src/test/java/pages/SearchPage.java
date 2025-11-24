package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private final By cookiesLocator = By.cssSelector("button[id=\"onetrust-accept-btn-handler\"]");
    private final By searchBarLocator = By.xpath("//input[@id='ikea-search-input']");
    private final By searchBtnLocator = By.xpath("(//span[@class='search-box-typography-label-s search-box-btn__inner'])[2]");

    private final By productsTitleLocator = By.cssSelector("[class=\"plp-product-list__products  \"] [class=\"plp-fragment-wrapper plp-fragment-wrapper--grid\"] [class=\"plp-text plp-typography-label-m plp-typography-regular plp-price-module__description\"]");


    public void openHomePage(){
        driver.get("https://www.ikea.com/eg/en/");
        checkCookies(cookiesLocator);
    }

    public void fillSearch(String title){
        write(searchBarLocator, title);
        click(searchBtnLocator);
    }

    public Boolean checkResultsRatio(String title){
        return ratioAssert(productsTitleLocator , title);
    }
}
