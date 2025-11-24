package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ClickUtils;

public class CategoryPage extends BasePage{
    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    private final By addToCartBtnLocator = By.xpath("(//span[@class='plp-typography-label-s plp-btn__inner'])[3]");
    private final By cartQuantityLocator = By.xpath("//span[@class='hnf-header__cart-counter']");
    private final By cookiesLocator = By.cssSelector("button[id=\"onetrust-accept-btn-handler\"]");

    public void addToCartTwice() throws InterruptedException {
        ClickUtils.guaranteedClick(addToCartBtnLocator);
        Thread.sleep(4000);
        ClickUtils.guaranteedClick(addToCartBtnLocator);
        Thread.sleep(4000);
    }

    public String getCartQuantity(){
        return read(cartQuantityLocator);
    }
}
