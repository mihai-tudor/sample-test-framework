package williamhill.sports.pageobjects.centermain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import williamhill.sports.utils.ActionDriverUtils;

import java.util.List;

/**
 * This page object is for interacting with the coupons area
 */
public class Coupons {
    private WebDriver driver;
    private ActionDriverUtils driverUtils;

    private static final By COUPONS_LIST = By.cssSelector("#highlights-coupons .sportmenu__link");

    public Coupons(WebDriver _driver) {
        this.driver = _driver;
        this.driverUtils = new ActionDriverUtils(driver);
    }

    /**
     * Gets a list of all displayed coupons
     *
     * @return A list of WebElements with all the coupons items
     */
    public List<WebElement> getAllCouponsItemsList() {
        return driver.findElements(COUPONS_LIST);
    }

    /**
     * Gets a coupon item from the list by index
     *
     * @param index The index of the coupon
     * @return The WebElement corresponding with the index
     */
    public WebElement getCouponItemFromListByIndex(int index) {
        return this.getAllCouponsItemsList().get(index);
    }

    /**
     * Opens a coupon item based on the index and waits for the spinner to disappear
     *
     * @param index The index of the coupon
     * @return Returns a new Event object
     */
    public Events openCouponItemFromListByIndex(int index) {
        WebElement couponItemElement = this.getCouponItemFromListByIndex(index);
        //driverUtils.moveToElement(couponItemElement);
        couponItemElement.click();
        driverUtils.waitUntilSpinnerIsHidden();
        return new Events(driver);
    }
}
