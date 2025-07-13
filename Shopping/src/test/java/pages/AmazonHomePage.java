package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonHomePage {
    WebDriver driver;
     @FindBy(xpath = "//button") WebElement continueButton;

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(product);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
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
}