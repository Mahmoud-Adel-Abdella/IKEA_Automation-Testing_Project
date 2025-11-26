package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilities.ClickUtils;

public class FavoritePage extends BasePage{
    public FavoritePage(WebDriver driver) {
        super(driver);
    }

    private final By randomProductFavLocator = By.xpath("//button[@aria-label='Save to shopping list, MJUKPLISTER, bedspread, dark grey']");
    private final By favoritePageLocator = By.xpath("//button[@class='hnf-btn hnf-btn--small hnf-btn--plain hnf-toast__action-message']//span[@class='hnf-typography-label-s hnf-btn__inner']");
    private final By productFavPageLocator = By.xpath("//img[@alt='MJUKPLISTER Bedspread, dark grey, 260x250 cm']");

    private final By miniOptionsLocator = By.xpath("(//span[@class='fav-typography-label-s fav-btn__inner'])[2]");
    private final By removeBtnLocator = By.cssSelector("li[id='fav-listview-3'] button[class='fav-list-view-item__action']");
    private final By finalRemoveBtn = By.xpath("(//span[@class='fav-typography-label-m fav-btn__inner'])[4]");

    public void addProductToFav(){
        ClickUtils.guaranteedClick(randomProductFavLocator);
    }

    public void goToFavPage(){
        ClickUtils.guaranteedClick(favoritePageLocator);
    }

    public boolean checkProductPresence(){
        return driver.findElement(productFavPageLocator).isDisplayed();
    }

    public void deleteFavList(){
        ClickUtils.guaranteedClick(miniOptionsLocator);
        ClickUtils.guaranteedClick(removeBtnLocator);
        ClickUtils.guaranteedClick(finalRemoveBtn);
    }
}
