package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonHomePage;
import utils.DriverFactory;


public class SearchSteps {
    WebDriver driver;
    AmazonHomePage amazonHomePage;

    @Given("User is on Amazon homepage")
    public void user_is_on_amazon_homepage() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.amazon.in");
        amazonHomePage = new AmazonHomePage(driver);
    }

    @When("User searches for Apple MacBook")
    public void user_searches_for_apple_mac_book() {
        amazonHomePage.searchProduct("Apple MacBook");
    }

    @Then("Results for Apple MacBook are displayed")
    public void results_for_apple_mac_book_are_displayed() {
        Assert.assertTrue(driver.getTitle().contains("Apple MacBook"));
        driver.quit();
    }
}
