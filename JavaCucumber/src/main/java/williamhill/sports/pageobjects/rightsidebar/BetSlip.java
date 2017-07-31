package williamhill.sports.pageobjects.rightsidebar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import williamhill.sports.utils.ActionDriverUtils;

import java.text.ParseException;
import java.util.List;

/**
 * This page object is for interacting with the Bet Slip
 */
public class BetSlip {
    private WebDriver driver;
    private ActionDriverUtils driverUtils;

    private static final By BET_SLIP_EMPTY_MESSAGE = By.id("betslip-message-empty");
    private static final By BET_SLIP_OVERLAY = By.id("wh-betslip-overlay");
    private static final By ALL_BETS_IN_BET_SLIP = By.cssSelector("#bets-container-singles .betslip-selection");
    private static final By BET_STAKE_INPUT = By.cssSelector(".betslip-selection__stake-input");
    private static final By TOTAL_TO_RETURN = By.id("total-to-return-price");
    private static final By TOTAL_STAKE = By.id("total-stake-price");

    public BetSlip(WebDriver _driver) {
        this.driver = _driver;
        this.driverUtils = new ActionDriverUtils(driver);
    }

    /**
     * Gets all the bets elements displayed in the bet slip
     *
     * @return A list of elements
     */
    public List<WebElement> getAllBetsInBetSlip() {
        return driver.findElements(ALL_BETS_IN_BET_SLIP);
    }

    /**
     * Gets the number of bets displayed in the bet slip
     *
     * @return The number of bets
     */
    public int getNumberOfBetsInBetSlip() {
        return this.getAllBetsInBetSlip().size();
    }

    /**
     * Gets a bet item from the bet slip list by its index
     *
     * @param index The index of the bet
     * @return The item element corresponding with the index
     */
    public WebElement getBetInBetSlipByIndex(int index) {
        return this.getAllBetsInBetSlip().get(index);
    }

    /**
     * Gets the input WebElement for the chosen bet item in bet slip by index
     *
     * @param index The index for the bet item
     * @return The WebElement corresponding to the chosen bet item
     */
    public WebElement getBetInputByIndex(int index) {
        return this.getBetInBetSlipByIndex(index).findElement(BET_STAKE_INPUT);
    }

    /**
     * Gets the text attribute value
     *
     * @param index The index for the bet item
     * @return String of the input value
     */
    public String getBetValueByIndex(int index) {
        return this.getBetInputByIndex(index).getAttribute("value");
    }

    /**
     * Types a value in the bet input for a bet item chosen by index
     *
     * @param value The bet value
     * @param index The index for the bet item
     */
    public void typeBetValueByIndex(String value, int index) {
        this.getBetInputByIndex(index).sendKeys(value);
    }

    /**
     * Gets the displayed "To return" value in Double format
     *
     * @return The Double value or null if the element is empty
     * @throws ParseException When pareDouble is unable to parse the string.
     */
    public Double getToReturnValue() throws ParseException {
        String toReturnText = driver.findElement(TOTAL_TO_RETURN).getText();
        if (toReturnText.length() > 0) {
            return driverUtils.convertCurrencyUiFormatToDouble(toReturnText);
        } else {
            return null;
        }
    }

    /**
     * Gets the displayed "Total stake" value in Double format
     *
     * @return The Double value or null if the element is empty
     * @throws ParseException When pareDouble is unable to parse the string.
     */
    public Double getTotalStakeValue() throws ParseException {
        String totalStakeText = driver.findElement(TOTAL_STAKE).getText();
        if (totalStakeText.length() > 0) {
            return driverUtils.convertCurrencyUiFormatToDouble(totalStakeText);
        } else {
            return null;
        }
    }

    /**
     * Waits for the bet slip items to reach a certain number. E.g. On adding a selection to the bet slip, the number should increase by 1.
     *
     * @param numberOfBets The required number of bet items.
     */
    public void waitForNumberOfBetsInBetSlip(int numberOfBets) {
        driverUtils.waitForNumberOfElements(ALL_BETS_IN_BET_SLIP, numberOfBets, 5);
    }
}
