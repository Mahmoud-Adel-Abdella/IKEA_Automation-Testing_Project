package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ClickUtils;

public class CategoryPage extends BasePage {
    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    private final By materialSubfilterLocator = By.xpath("//div[contains(@class,'plp-filter plp-clearfix')]//label[1]");
    private final By materialFilterLocator = By.xpath("(//button[@class='plp-pill plp-pill--small plp-pill--trailing-icon'])[7]");
    private final By priceFilterLocator = By.cssSelector("[class=\"plp-filter-bar__options\"] li:nth-child(6)");
    private final By priceSubfilterLocator = By.cssSelector("[class=\"plp-drop-down\"] label:nth-child(3)");

    private final By productsLocator = By.cssSelector("[class=\"plp-price-module__price\"] [class=\"plp-price__sr-text\"]");

    public void applyMaterialFilter() {
        ClickUtils.guaranteedClick(materialFilterLocator);
        ClickUtils.guaranteedClick(materialSubfilterLocator);
    }

    public void applyPriceFilter() {
        ClickUtils.guaranteedClick(priceFilterLocator);
        ClickUtils.guaranteedClick(priceSubfilterLocator);
        ClickUtils.guaranteedClick(priceFilterLocator);
    }

    public boolean verifyApplyingPrice(String minPrice, String maxPrice) {
        return verifyRange(productsLocator, minPrice , maxPrice);
    }
}
