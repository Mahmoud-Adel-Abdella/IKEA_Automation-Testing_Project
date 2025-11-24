package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private final By productPriceLocator = By.cssSelector("[class=\"pip-price-module__primary-currency-price-energy-class\"] [class=\"pip-price__integer\"]");
    private final By productNameLocator = By.cssSelector("[class=\"pip-price-module__name-decorator notranslate\"]");

    public String getProductName() {
        return read(productNameLocator);
    }

    public double getProductPrice() {
        return readDigits(read(productPriceLocator));
    }
}
