package mail.com;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import ui.pages.AccountPage;
import ui.pages.HomePage;
import ui.pages.LoginPage;
import ui.pages.PersonalDataPage;
import utils.TestSetup;

import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Update profile name in mail.com")
@TmsLink("TC01")
@Severity(SeverityLevel.CRITICAL)
@Tag("E2ETest")
public class ProfileUpdateTest extends TestSetup {

    private HomePage homePage;

    private AccountPage accountPage;

    private LoginPage loginPage;

    private PersonalDataPage personalDataPage;

    private final String profileName = "Automation Task";

    @Test
    @Description("Verify if user can update profile name in mail account")
    void updateProfileInformation() {

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        personalDataPage = new PersonalDataPage(driver);

        step("User launched 1and1 home page and accept cookie", () -> {
            homePage.acceptCookie();
        });

        step("Click Login button", () -> {
            homePage.clickLoginButton();
        });

        step("Enter username and password, then click Login button", () -> {
            loginPage.login1and1(username, password);
        });

        step("Click on the link My account", () -> {
            loginPage.clickMyAccount();
        });

        step("Click on the link Personal Data", () -> {
            accountPage.clickPersonalData();
            addAttachment("account page",accountPage.getScreenshot());
        });

        step("Open the profile edit page", () -> {
            personalDataPage.editProfileInformation();
        });

        step("Update the User firstName and lastName, then save information", () -> {
            personalDataPage.updateFirstName(profileName.split(" ")[0]);
            personalDataPage.updateLastName(profileName.split(" ")[1]);
            personalDataPage.enterPassword(password);
            personalDataPage.clickSaveChanges();
        });

        step("Verify if username is updated", () -> {
            assertThat(personalDataPage.getSuccessMessage())
                    .isEqualTo("Personal data successfully changed");
            assertThat(personalDataPage.getProfileName())
                    .withFailMessage("Profile name not matches with expected -" + profileName)
                    .isEqualTo(profileName);
        });
    }


}
