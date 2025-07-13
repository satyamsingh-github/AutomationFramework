package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsClickHelper {

    
    public JsClickHelper(WebDriver driver) {
        //TODO Auto-generated constructor stub
    }

    public static void clickIfValueIsSame(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String value = (String) js.executeScript("return arguments[0].value;", element);

        if ("1".equals(value)) {
            js.executeScript("arguments[0].click();", element);
            System.out.println("Element clicked because value is 1");
        } else {
            System.out.println("Element not clicked; value is: " + value);
        }
    }
}
