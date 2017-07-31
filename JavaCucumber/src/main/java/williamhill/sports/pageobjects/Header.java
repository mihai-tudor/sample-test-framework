package williamhill.sports.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import williamhill.sports.pageobjects.modals.LoginModal;
import williamhill.sports.utils.ActionDriverUtils;

import java.text.ParseException;

/**
 * This page object is for interacting with the website header (logo, menu options, login button, join button, user balance)
 */
public class Header {
    private WebDriver driver;
    private ActionDriverUtils driverUtils;

    private static final By LOGIN_BUTTON = By.cssSelector("#accountTabButton .-login");
    private static final By ACCOUNT_BUTTON = By.id("accountTabButton");
    private static final By LOGGED_USER_BALANCE = By.cssSelector("#accountTabButton .-account");

    public Header(WebDriver _driver) {
        this.driver = _driver;
        this.driverUtils = new ActionDriverUtils(driver);
    }

    /**
     * Opens the login modal.
     *
     * @return A new LoginModal object.
     */
    public LoginModal openLoginModal() {
        driver.findElement(LOGIN_BUTTON).click();
        return new LoginModal(driver);
    }

    /**
     * Gets the user balance as is displayed in UI.
     *
     * @return String of the displayed balance.
     */
    public String getUserBalance() {
        return driver.findElement(LOGGED_USER_BALANCE).getText();
    }

    /**
     * Gets the user balance converted in Double.
     *
     * @return Double - numeric value of the user balance (without currency symbol)
     * @throws ParseException When pareDouble is unable to parse the string.
     */
    public Double getUserBalanceDouble() throws ParseException {
        return driverUtils.convertCurrencyUiFormatToDouble(this.getUserBalance());
    }

    /**
     * It calculates the difference between the initial balance and the stake. If less then 0 it return 0.
     *
     * @param initialBalance The initial balance (before betting)
     * @param stake          The bet stake
     * @return The difference between the initial balance and the stake but never less then 0.
     */
    public Double getUserBalanceMinusStake(Double initialBalance, Double stake) {
        Double remainingFounds = initialBalance - stake;
        if (remainingFounds < 0) {
            remainingFounds = 0.0;
        }
        return remainingFounds;
    }

    /**
     * Wrapper method for login. It also waits for the use balance to be populated.
     *
     * @param username The username that will be used for login.
     * @param password The password that will be used for login.
     */
    public void loginWithUserAndPass(String username, String password) {
        LoginModal loginModal = this.openLoginModal();
        loginModal.typeUsername(username);
        loginModal.typePassword(password);
        loginModal.pressLogin();
        // wait up to 120 seconds for the user balance to be populated, proxy is slow :(
        driverUtils.waitForTextNotEmpty(LOGGED_USER_BALANCE, 120);
    }

    /**
     * Checks if the user is logged in or not.
     *
     * @return boolean - true if the user is logged in
     */
    public boolean isLoggedIn() {
        return driver.findElement(LOGGED_USER_BALANCE).isDisplayed();
    }
}
