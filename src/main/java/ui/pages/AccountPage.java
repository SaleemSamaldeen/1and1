package ui.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;

public class AccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AccountPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By personalData = By.xpath("//span[text()='Personal Data']");

    By thirdPartyFrame = By.xpath("//iframe[@id='thirdPartyFrame_ciss']");

    public void clickPersonalData() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(thirdPartyFrame));
        driver.switchTo().frame(element);
        driver.findElement(personalData).click();
        driver.switchTo().defaultContent();
    }

    public FileInputStream getScreenshot() throws IOException {
        File takesScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        return FileUtils.openInputStream(takesScreenshot);
    }



}
