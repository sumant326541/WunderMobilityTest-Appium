package com.qa.pages;

import com.qa.utils.DriverManager;
import com.qa.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.appium.java_client.touch.offset.PointOption.point;


public class BasePage {
    private AppiumDriver driver;
    TestUtils utils = new TestUtils();

    public BasePage() {
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void wait(int t) throws InterruptedException {
        Thread.sleep(t);
    }

    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForVisibility(By e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.WAIT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
    }

    public boolean isElementVisible(WebElement e, String msg) {
        try {
            boolean b = e.isDisplayed();
            utils.log().info(msg + "element displayed");
            return b;
        } catch (Exception ex) {
            utils.log().info(msg + "element not displayed");
            return false;
        }
    }

    public boolean isElementNotVisible(WebElement e, String msg) {
        try {
            e.isDisplayed();
            return true; // Element is not visible
        } catch (Exception ei) {
            return false; // Element is still visible or not found
        }
    }

    public void clear(WebElement e) {
        waitForVisibility(e);
        e.clear();
    }

    public void click(WebElement e) {
        waitForVisibility(e);
        e.click();
    }

    public void click(WebElement e, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.click();
    }

    public void click(By e, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        driver.findElement(e).click();
    }

    public void sendKeys(WebElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public void sendKeys(WebElement e, String txt, String msg) {
        waitForVisibility(e);
        utils.log().info(msg);
        e.sendKeys(txt);
    }

    public String getAttribute(WebElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public String getAttribute(By e, String attribute) {
        waitForVisibility(e);
        return driver.findElement(e).getAttribute(attribute);
    }

    public String getText(WebElement e, String msg) {
        String txt = getAttribute(e, "text");
        utils.log().info(msg + txt);
        return txt;
    }

    public String getText(By e, String msg) {
        String txt = getAttribute(e, "text");
        utils.log().info(msg + txt);
        return txt;
    }

    public void closeApp() {
        ((InteractsWithApps) driver).terminateApp(driver.getCapabilities().
                getCapability("appPackage").toString());
    }

    public void launchApp() {

        ((InteractsWithApps) driver).activateApp(driver.getCapabilities().
                getCapability("appPackage").toString());
    }

    public void swipe(String direction, int count) {
        Dimension size = driver.manage().window().getSize();
        int startX = 0;
        int endX = 0;
        int startY = 0;
        int endY = 0;

        switch (direction) {
            case "up":
                startX = (int) (size.width * 0.5);
                endX = (int) (size.width * 0.5);
                startY = (int) (size.height * 0.6);
                endY = (int) (size.height * 0.4);
                break;

            case "down":
                startX = (int) (size.width * 0.5);
                endX = (int) (size.width * 0.5);
                startY = (int) (size.height * 0.4);
                endY = (int) (size.height * 0.6);

                break;
            case "left":
                startX = (int) (size.width * 0.6);
                endX = (int) (size.width * 0.4);
                startY = (int) (size.height * 0.5);
                endY = (int) (size.height * 0.5);

                break;

            case "right":
                startX = (int) (size.width * 0.4);
                endX = (int) (size.width * 0.6);
                startY = (int) (size.height * 0.5);
                endY = (int) (size.height * 0.5);

                break;
            case "dignolup":
                startX = (int) (size.width * 0.6);
                endX = (int) (size.width * 0.4);
                startY = (int) (size.height * 0.6);
                endY = (int) (size.height * 0.4);

                break;
        }

        for (int i = 0; i < count; i++) {

            new TouchAction((PerformsTouchActions) driver)
                    .longPress(point(startX, startY))
                    .moveTo(point(endX, endY))
                    .release()
                    .perform();
        }

    }

    public void swipeTillElementVisible(WebElement e, String direction, int count) {

        for (int i = 0; i < count; i++) {
            if (isElementVisible(e, "ele visible in swipe " + (i + 1))) {
                break;
            } else {
                swipe(direction, 1);
            }
        }
    }


}

