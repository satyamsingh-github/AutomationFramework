package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.WaitUtils;



public class ProductPage {
    WebDriver driver;

    // ISSUE 1: Locators are brittle and may not work for all products or page states.
    // Suggestion: Use more generic or parameterized locators if possible.
    @FindBy(xpath = "//span[contains(text(),'New')]")
    private WebElement newCondition;
    @FindBy(xpath = "//span[contains(text(),'Used')]")
    private WebElement usedCondition;
    @FindBy(xpath = " (//h2/span)[4]")
    private WebElement productDescription;
 

    @FindBy(name = "submit.addToCart")
    private WebElement addToCartButton;
    @FindBy(xpath = "//a[@href='/cart?ref_=ewc_gtc']")
    private WebElement GoToCart;

     @FindBy(xpath = "//span[@class='a-truncate-cut")
     private WebElement productinCart;

    @FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
     private WebElement proceedToRetailCheckout;


    public ProductPage(WebDriver driver) {
        // ISSUE 2: Assumes driver is properly initialized.
        // Suggestion: Add a null check and throw a clear error if driver is null.
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance is null. Make sure to initialize the driver before creating ProductPage.");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void productCondition(String condition) {
        if ("New".equalsIgnoreCase(condition)) {
            newCondition.click();
        } else if ("Used".equalsIgnoreCase(condition)) {
            usedCondition.click();
        } else {
            throw new IllegalArgumentException("Invalid product condition: " + condition);
        }
    }

    public void verifyProductDisplayed(String product) {

        WaitUtils.waitForVisibility(driver, productDescription);
        Assert.assertTrue(productDescription.getText().contains(product), "Product description does not contain expected text: " + product);
    }

    public void addTocart() {
        addToCartButton.click();
    }

    
    public void clickOnCartIcon() {
        WaitUtils.waitForVisibility(driver, GoToCart);
        GoToCart.click();
    }

    public void proceedtoCheckout( ) {

        WaitUtils.waitForVisibility(driver, proceedToRetailCheckout);
        proceedToRetailCheckout.click();

    }

	
	
}