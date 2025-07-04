package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AmazonHomePage {
    WebDriver driver;

    @FindBy(id = "twotabsearchtextbox") WebElement searchBox;
    @FindBy(id = "nav-search-submit-button") WebElement searchButton;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String product) {
        searchBox.sendKeys(product);
        System.out.println("For Github Learning");
        
        System.out.println("For Github Learning - from the place where");
        
        System.out.println("changed for auto execution");
        
        searchButton.click();
    }
}