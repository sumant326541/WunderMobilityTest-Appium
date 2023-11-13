package com.qa.pages;

import com.qa.utils.TestUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class NearByVehicleListPage extends BasePage {
    TestUtils utils = new TestUtils();
    static List<String> kikScooterD1;
    @AndroidFindBy(xpath = "//*[@text='KickScooter D1']")
    private WebElement KickScooterD1;
    @AndroidFindBy(xpath = "//*[@text='Electric Bike B1']")
    private WebElement ElectricBikeB1;
    @AndroidFindBy(xpath = "//*[@text='Electric Car C1']")
    private WebElement ElectricCarC1;
    @AndroidFindBy(xpath = "//*[@text='Electric Bike B4']")
    private WebElement ElectricBikeB4;
    @AndroidFindBy(xpath = "//*[@text='Electric Car C5 SPORT']")
    private WebElement ElectricCarC5SPORT;
    @AndroidFindBy(xpath = "//*[@text='KickScooter D6']")
    private WebElement KickScooterD6;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtNearbyVehicleListItemType")
    private List<WebElement> vehicleType;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtNearbyVehicleListItemName")
    private List<WebElement> vehicleName;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtNearbyVehicleListItemDescription")
    private List<WebElement> vehicleDiscription;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtNearbyVehicleListItemFuelLevel")
    private List<WebElement> vehicleFuelLevel;
    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtNearbyVehicleListItemPrice")
    private List<WebElement> vehiclePrice;

    public void verifyAllVehicleDisplayInList() {
        Assert.assertTrue(KickScooterD1.isDisplayed());
        Assert.assertTrue(ElectricBikeB1.isDisplayed());
        Assert.assertTrue(ElectricCarC1.isDisplayed());
        Assert.assertTrue(ElectricBikeB4.isDisplayed());
        Assert.assertTrue(ElectricCarC5SPORT.isDisplayed());
        swipeTillElementVisible(KickScooterD6, "up", 2);
        Assert.assertTrue(KickScooterD6.isDisplayed());
    }

    public void getKikScooterD1Details() {
        kikScooterD1 = new ArrayList<>();
        kikScooterD1.add(vehicleType.get(0).getText());
        kikScooterD1.add(vehicleName.get(0).getText());
        kikScooterD1.add(vehicleDiscription.get(0).getText());
        kikScooterD1.add(vehicleFuelLevel.get(0).getText());
        kikScooterD1.add(vehiclePrice.get(0).getText());
    }

    public void tapOnScooterD1() {
        click(KickScooterD1, "Tap on KickScooter D1");

    }

    public void verifyKickScooterD1detail() {
        List<String> sccoterD1 = new ArrayList<>();
        sccoterD1.add(vehicleType.get(0).getText());
        sccoterD1.add(vehicleName.get(0).getText());
        sccoterD1.add(vehicleDiscription.get(0).getText());
        sccoterD1.add(vehicleFuelLevel.get(0).getText());
        sccoterD1.add(vehiclePrice.get(0).getText());

        Assert.assertTrue("kikScooterD1 details not same in dialog box", kikScooterD1.equals(sccoterD1));
    }

    public void waitUntilVisible() {
        isElementVisible(KickScooterD1, "Near By Vehicle List loaded:");
    }

}
