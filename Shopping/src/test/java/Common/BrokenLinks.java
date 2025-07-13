package Common;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import utils.DriverFactory;

public class BrokenLinks {

    public static void checkBrokenLinks() {
         WebDriver driver = DriverFactory.getDriver();
         List<WebElement> allLinks = driver.findElements(By.tagName("a"));
         System.out.println("Total links found: " + allLinks.size());

       for (WebElement link : allLinks) {
        String url = link.getAttribute("href");

        if (url == null || url.isEmpty()) {
            System.out.println("Empty or missing href for element: " + link.getText());
            continue;
        }

        try {
            HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode = connection.getResponseCode();

            if (responseCode >= 400) {
                System.out.println("❌ Broken link: " + url + " - Response Code: " + responseCode);
            } else {
                System.out.println("✅ Valid link: " + url + " - Response Code: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("⚠️ Error validating link: " + url + " - " + e.getMessage());
        }
    }
}




}