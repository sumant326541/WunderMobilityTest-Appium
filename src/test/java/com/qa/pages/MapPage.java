package com.qa.pages;

import com.qa.utils.TestUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MapPage extends BasePage {
    TestUtils utils = new TestUtils();
    @AndroidFindBy(className = "android.widget.TextView")
    private WebElement titleTxt;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/btnMapLocateVehicle")
    private WebElement VehicleMapLocatorButton;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/btnMapNearbyVehicles")
    private WebElement nearByVehicleListButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Google Map\"]/android.view.View")
    private List<WebElement> vehicle;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Google Map\"]/android.view.View[1]")
    private WebElement vehicle1;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Google Map\"]/android.view.View[2]")
    private WebElement vehicle2;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Google Map\"]/android.view.View[3]")
    private WebElement vehicle3;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Google Map\"]/android.view.View[4]")
    private WebElement vehicle4;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Google Map\"]/android.view.View[5]")
    private WebElement vehicle5;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Google Map\"]/android.view.View[6]")
    private WebElement vehicle6;

    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtCardVehicleType")
    private WebElement vehicleType;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtCardVehicleFuelLevel")
    private WebElement vehicleFuelLevel;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtCardVehicleName")
    private WebElement vehicleName;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtCardVehicleDescription")
    private WebElement vehicleDescription;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtCardVehiclePrice")
    private WebElement vehiclePrice;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/btnCardVehicleRentVehicle")
    private WebElement rentVehicleButton;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/btnCardVehicleEndRent")
    private WebElement endRentButton;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/btnCardVehicleClose")
    private WebElement vehicleCloseButton;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtCardVehicleRides")
    private WebElement ridesCounts;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/btnCardVehicleGoToRentedVehicle")
    private WebElement gotoRentedVehicleButton;

    public String getTitle() {
        return getText(titleTxt, "product page title is - ");
    }

    public WebElement getVehicleMapLocatorButton() {
        return VehicleMapLocatorButton;
    }

    public WebElement getNearByVehicleListButton() {
        return nearByVehicleListButton;
    }

    public WebElement getVehicleOnMap() {
        return vehicle1;
    }

    public boolean verifyVehicleMapLocatorButtonDisplayed() {
        return isElementVisible(VehicleMapLocatorButton, "Vehicle MapLocator Button: ");
    }

    public boolean verifyNearByVehicleListButtonDisplayed() {
        return isElementVisible(nearByVehicleListButton, "Near By Vehicle List Button: ");
    }

    public boolean verifyVehicaleNotDisplayed() {
        return isElementVisible(vehicle1, "vehicle 1 :");
    }

    public int getNoOfVehicleDisplayed() {
        waitForVisibility(vehicle1);
        List<WebElement> vehicleList = vehicle;
        return vehicleList.size();
    }

    public void tapOnVehicle() {
        click(vehicle1, "Tap on vehicle1");
    }

    public void tapOnNewVehicle() {
        new BasePage().swipeTillElementVisible(vehicle1, "up", 15);
        click(vehicle1, "Tap on vehicle1");
    }

    public void tapOnRentVehcle() {
        click(rentVehicleButton, "Tap on RENT VEHICLE button");
    }

    public String getVehicleName() {
        return getText(vehicleName, "vehicale is - ");
    }

    public void tapOnEndRent() {
        click(endRentButton, "Tap on END RENT button");
    }

    public String getRidesCounts() {
        String count = getText(ridesCounts, "Rides Count is - ");
        return count;
    }

    public void tapOnCloseVehicle() {
        click(vehicleCloseButton, "Tap on Close vehicle button");
    }

    public void tapOnGoToRentedVehicale() {
        click(gotoRentedVehicleButton, "Tap on GO TO RENTED VEHICLE Button");
    }

    public NearByVehicleListPage tapOnNearByVehicaleListButton() {
        click(nearByVehicleListButton, "Tap on near by Vehicale list button");
        return new NearByVehicleListPage();
    }

    public void tapOnMapLocatorButton() {
        click(VehicleMapLocatorButton, "Tap on vehicale map locator button");
    }

    public void waitUntilVisible() {
        isElementVisible(nearByVehicleListButton, "Map Page loaded:");
    }
}
