package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage {

    public String getText(WebDriver driver, By locator) {
        return driver.findElement(locator).getText().trim();
    }
}
