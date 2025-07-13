package stepDefinition;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import Common.BrokenLinks;


public class verifications {
    WebDriver driver;
    BrokenLinks brokenlinks;

    @Given("All links on the result page are valid")
    public void all_links_on_the_result_page_are_valid() {
     
       BrokenLinks.checkBrokenLinks();   

    }
}
