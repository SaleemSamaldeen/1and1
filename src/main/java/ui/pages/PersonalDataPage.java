package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalDataPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PersonalDataPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By editName = By.xpath("//div[contains(@onclick,'birthData')]");
    By firstNameField = By.xpath("//input[contains(@id,'editBirthDataPanel:form:firstNamePanel')]");
    By lastNameField = By.xpath("//input[contains(@id,'editBirthDataPanel:form:lastNamePanel')]");
    By passwordField = By.xpath("//input[@type='password']");
    By saveChanges = By.xpath("//button[@type='button']");
    By thirdPartyFrame = By.xpath("//iframe[@id='thirdPartyFrame_ciss']");
    By profileName = By.xpath("//div[contains(@onclick,'birthData')]//div[contains(@class,'link-body')]//div//div[1]");
    By successMessage = By.xpath("//span[@class='hint-headline']");


    public void editProfileInformation() {
        WebElement element = driver.findElement(thirdPartyFrame);
        driver.switchTo().frame(element);
        driver.findElement(editName).click();
    }

    public void updateFirstName(String firstName) {
        WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        firstname.clear();
        firstname.sendKeys(firstName);
    }

    public void updateLastName(String lastName) {
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSaveChanges() {
        driver.findElement(saveChanges).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText().trim();
    }

    public String getProfileName() {
        return driver.findElement(profileName).getText().trim();
    }


}
