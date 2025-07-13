package stepDefinition;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonHomePage;
import pages.ProductPage;
import utils.DriverFactory;
import utils.ExcelReader;
import utils.TestDataProvider;


public class SearchSteps {
    WebDriver driver;
    AmazonHomePage amazonHomePage;
    ProductPage productPage;
    static List<String[]> testData;

    public String website;
    public String product;
    public String condition;


    public SearchSteps() {
        if (testData == null) {
            testData = ExcelReader.getExcelData(
                "G:\\VSCode\\AutomationFramework\\Shopping\\src\\test\\resources\\features\\data\\testData.xlsx",
                "TestData"
            );
        }

        

    }

   @Before 
   public void setUpTestData() {
        String[] testRow = TestDataProvider.getNextTestData();
        if (testRow != null && testRow.length == 3 ) {
            website = testRow[0];
            product = testRow[1];
            condition = testRow[2];
        } else {
            throw new RuntimeException("No more test data available!");
        }
    }


   @Given("User is on Amazon {string}")
    public void user_is_on_amazon(String site) throws InterruptedException {
        
        if (site.equalsIgnoreCase("fromExcel")) {
        site = website;
        }

        driver = DriverFactory.getDriver();
        driver.get(site);
        amazonHomePage = new AmazonHomePage(driver);

        Thread.sleep(4000);

        amazonHomePage.continueShopping();


    }

   @When("User searches for {string}")
        public void user_searches_for(String item) {

        if (item.equalsIgnoreCase("fromExcel")) {
        item = product;
        }    
        amazonHomePage.searchProduct(item);
    }

    @Then("Results for {string} are displayed")
    public void results_for_are_displayed(String item) {
         
        if (item.equalsIgnoreCase("fromExcel")) {
        item = product;
        }

        Assert.assertTrue(driver.getTitle().toLowerCase().contains(item.toLowerCase()));
    }


    @And("User Clicks on Add to Cart button")
    public void user_clicks_on_add_to_cart_button() {

        driver = DriverFactory.getDriver();
        productPage = new ProductPage(driver);
        productPage.addTocart();
    }

    @Then("{string} is added to cart")
    public void product_is_added_to_cart(String item) {

        if (item.equalsIgnoreCase("fromExcel")) {
        item = product;
        }

        productPage.clickOnCartIcon();

        productPage.proceedtoCheckout();
   
    } 
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
}  
    }

    
