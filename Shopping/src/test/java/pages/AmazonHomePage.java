package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CookiesHandler;
import utils.WaitUtils;

public class AmazonHomePage {
    WebDriver driver;

    // FIXED: Use a more specific locator for the continue button (example: by text)
    @FindBy(xpath = "//button[contains(text(),'Continue shopping')]")
    private WebElement continueButton;

    @FindBy(id = "sp-cc-accept")
    private WebElement cookiesPreference;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    public AmazonHomePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance is null. Make sure to initialize the driver before creating AmazonHomePage.");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String product) {
        // FIXED: Validate input
        if (product == null || product.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        WaitUtils.waitForVisibility(driver, searchBox);
        searchBox.clear();
        searchBox.sendKeys(product);

        WaitUtils.waitForVisibility(driver, searchButton);
        searchButton.click();
    }

    public void continueShopping() {
        
        try {
            WaitUtils.waitForVisibility(driver, continueButton);
            if (continueButton.isDisplayed()) {
                continueButton.click();
            } else {
                System.out.println("Continue button is not displayed.");
            }
        } catch (Exception e) {
            System.out.println("Continue button is not present or not clickable: " + e.getMessage());
        }
    }

    public void acceptCookies() {
        
       
            CookiesHandler.handleCookiesPopup(driver, cookiesPreference);
        
    }
}