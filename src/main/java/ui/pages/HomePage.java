package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By acceptCookie = By.xpath("//button[@id='onetrust-accept-btn-handler']");

    By loginButton = By.xpath("//a[@id='login-button']//span");

    public void acceptCookie() {
        WebElement element = driver.findElement(By.xpath("//iframe[@class='permission-core-iframe']"));
        driver.switchTo().frame(element);
        driver.switchTo().frame(0);
        driver.findElement(acceptCookie).click();
    }

    public void clickLoginButton() {
        WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        login.click();
    }


}
