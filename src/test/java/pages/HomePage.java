package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By productLocator = By.xpath("//div[@id='tbodyid']//div[1]//div[1]//a[1]//img[1]");
    private final By addToCartBtn = By.cssSelector(".btn.btn-success.btn-lg");

    public void openHomePage(){
        navigateTo("https://demoblaze.com/index.html");
    }

    public void openProduct(){
        myClick(productLocator);
    }

    public void clickAddToCart(){
        myClick(addToCartBtn);
    }
}
