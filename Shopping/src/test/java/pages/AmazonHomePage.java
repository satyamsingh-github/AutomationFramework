package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class AmazonHomePage {
    WebDriver driver;
    @FindBy(xpath = "//button") WebElement continueButton;
    @FindBy(id = "sp-cc-accept") WebElement cookiesPreference;

    @FindBy(id = "twotabsearchtextbox") WebElement searchBox;
    @FindBy(id = "nav-search-submit-button") WebElement searchButton;

   

    public AmazonHomePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance is null. Make sure to initialize the driver before creating AmazonHomePage.");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String product) {

        WaitUtils.waitForVisibility(driver, searchBox);
        searchBox.sendKeys(product);

        WaitUtils.waitForVisibility(driver, searchButton);
        searchButton.click();

     
    }

    public void continueShopping() {

        if (continueButton.isDisplayed()) {
            continueButton.click();
        }
    
        else {
            System.out.println("Continue button is not displayed.");
            return;
        }
    }



    public void acceptCookies() {
        try {
            if (cookiesPreference.isDisplayed()) {
            cookiesPreference.click();
            System.out.println("Cookies popup handled.");
        }
        else {
            System.out.println("Cookies popup not displayed.");
            return;
        }
        } catch (Exception e) {
            System.out.println("Cookies popup not displayed.");
        }
        
        
        
    }


}