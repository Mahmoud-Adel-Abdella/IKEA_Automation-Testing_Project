package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ClickUtils;

public class FavoritePage extends BasePage{
    public FavoritePage(WebDriver driver) {
        super(driver);
    }

    private final By randomProductFavLocator = By.xpath("//button[@aria-label='Save to shopping list, MJUKPLISTER, bedspread, dark grey']");
    private final By favoritePageLocator = By.xpath("//button[@class='hnf-btn hnf-btn--small hnf-btn--plain hnf-toast__action-message']//span[@class='hnf-typography-label-s hnf-btn__inner']");
    private final By productFavFullPageLocator = By.xpath("//img[@alt='MJUKPLISTER Bedspread, dark grey, 260x250 cm']");
    private final By favPageHeadBtnLocator = By.xpath("//span[@class='hnf-btn__inner js-shopping-list-icon']");
    private final By productFavoritePageLocator = By.xpath("(//a[@class='_imageContainerLarge_15zjt_48 link'])[1]");

    private final By miniOptionsLocator = By.xpath("(//span[@class='fav-typography-label-s fav-btn__inner'])[2]");
    private final By removeBtnLocator = By.cssSelector("li[id='fav-listview-3'] button[class='fav-list-view-item__action']");
    private final By finalRemoveBtnLocator = By.xpath("(//span[@class='fav-typography-label-m fav-btn__inner'])[4]");
    private final By removeMSGLocator = By.xpath("//div[@class='hnf-toast-container skapa-focus-portal']");


    public void addProductToFav(){
        ClickUtils.guaranteedClick(randomProductFavLocator);
    }

    public void goToFavPage(){
        ClickUtils.guaranteedClick(favPageHeadBtnLocator);
    }

    public boolean checkProductPresence(){
        boolean check =  driver.findElement(productFavoritePageLocator).isDisplayed();
        ClickUtils.guaranteedClick(productFavoritePageLocator);

        return check;
    }

    public void deleteFavList(){
        ClickUtils.guaranteedClick(miniOptionsLocator);
        ClickUtils.guaranteedClick(removeBtnLocator);
        ClickUtils.guaranteedClick(finalRemoveBtnLocator);
    }

    public boolean checkRemoveMSG(){
        return driver.findElement(removeMSGLocator).isDisplayed();
    }
}
