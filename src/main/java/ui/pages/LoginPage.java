package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By emailAddressField = By.xpath("//input[@id='login-email']");

    By passwordField = By.xpath("//input[@id='login-password']");

    By loginButton = By.xpath("//button[contains(@class,'login-submit')]");

    By myAccount = By.xpath("//a[@class='iac account']");

    public void login1and1(String username, String password) {
        driver.findElement(emailAddressField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void clickMyAccount() {
        WebElement element = driver.findElement(By.xpath("//iframe[@id='thirdPartyFrame_home']"));
        driver.switchTo().frame(element);
        driver.findElement(myAccount).click();
        driver.switchTo().defaultContent();
    }
}
