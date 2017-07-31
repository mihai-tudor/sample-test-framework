package williamhill.sports.pageobjects.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import williamhill.sports.utils.ActionDriverUtils;

/**
 * This page object is for interacting with the login modal
 */
public class LoginModal {
    private WebDriver driver;
    private ActionDriverUtils driverUtils;

    private static final By MODAL_CONTAINER = By.id("account-section");
    private static final By OPENED_MODAL = By.cssSelector("#account-section section.-expanded");
    private static final By USERNAME_INPUT = By.id("loginUsernameInput");
    private static final By PASSWORD_INPUT = By.id("loginPasswordInput");
    private static final By SAVE_USERNAME_CHECKBOX = By.id("rememberMe");
    private static final By LOGIN_BUTTON = By.id("loginButton");
    private static final By PASSWORD_RECOVER_LINK = By.id("passwordRecoveryLink");

    public LoginModal(WebDriver _driver) {
        this.driver = _driver;
        this.driverUtils = new ActionDriverUtils(driver);
        // check if the element that makes the modal visible is present
        if (!driverUtils.isPresent(OPENED_MODAL)) {
            throw new IllegalStateException("The login modal is not opened!");
        }
    }

    /**
     * Types the username for login
     *
     * @param username The chosen username
     */
    public void typeUsername(String username) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
    }

    /**
     * Types the password for login
     *
     * @param password The chosen password
     */
    public void typePassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    /**
     * Presses the login button
     */
    public void pressLogin() {
        this.driver.findElement(LOGIN_BUTTON).click();
    }
}
