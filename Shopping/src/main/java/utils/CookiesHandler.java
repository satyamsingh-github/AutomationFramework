package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookiesHandler {
    public static void handleCookiesPopup(WebDriver driver, WebElement element) {
    try {
            if (element.isDisplayed()) {
            element.click();

            System.out.println("Cookies popup handled.");
        }
        else {
            System.out.println("Cookies popup is not displayed.");
            return;
        }
        } catch (Exception e) {
            System.out.println("Cookies popup is not displayed.");
        }
}

}