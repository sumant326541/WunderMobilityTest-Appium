package com.qa.stepdef;

import com.qa.pages.BasePage;
import com.qa.pages.LoginPage;
import com.qa.pages.MapPage;
import com.qa.utils.TestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MapStepDef {
    TestUtils utils = new TestUtils();
    static String vehicaleName;

    @Given("I'm logged in to App")
    public void iMLoggedIn() throws InterruptedException {
        new LoginPage().login("qatest@wundermobility.com", "12345678");
        new BasePage().wait(5000);
    }

    @Then("I should see vehicle map locator on map")
    public void iShouldSeeVehicleMapLocatorOnMapOnMap() throws Exception {
        Assert.assertTrue(new MapPage().verifyVehicleMapLocatorButtonDisplayed());
    }

    @Then("I should see near By vehicales button on map")
    public void iShouldSeeNearByVehicalesOnMap() throws Exception {
        Assert.assertTrue(new MapPage().verifyNearByVehicleListButtonDisplayed());
    }

    @Then("I Tap on near by vehicle List button")
    public void iTapOnNearByVehicaleListButton() throws Exception {
        new MapPage().tapOnNearByVehicaleListButton();
    }

    @Then("I should see vehicle map locator button is disabled")
    public void iShouldSeeVehicleMapLocatorButtonIsDisabled() throws Exception {
        Assert.assertFalse(new MapPage().getVehicleMapLocatorButton().isEnabled());
    }

    @Then("I should see six vehicales on map")
    public void iShouldSeeSixVehicalesOnMap() throws Exception {
        Assert.assertEquals(new MapPage().getNoOfVehicleDisplayed(), 6);
    }

    @When("I Tap on a vehicle displayed on map")
    public void iTapOnAVehicleDisplayedOnMap() throws InterruptedException {
        new MapPage().tapOnVehicle();
        new BasePage().wait(2000);
    }

    @When("I Tap on new vehicle displayed on map")
    public void iTapOnNewVehicleDisplayedOnMap() throws InterruptedException {
        new MapPage().tapOnNewVehicle();
        new BasePage().wait(2000);
    }

    @When("I Tap on RENT VEHICLE")
    public void iTapOnRentVehicle() {
        new MapPage().tapOnRentVehcle();
        vehicaleName = new MapPage().getVehicleName();
    }

    @When("I tap on END RENT")
    public void iTapOnEndRent() throws InterruptedException {
        new MapPage().tapOnEndRent();
        new BasePage().wait(2000);
    }

    @When("I Tap on go to rented vehicle button")
    public void iTapOnGoToRentedVehicle() throws InterruptedException {
        new MapPage().tapOnGoToRentedVehicale();
    }

    @Then("I should see current rented vehicle")
    public void iShouldSeeCurrentRentedVehicle() {
        Assert.assertEquals(new MapPage().getVehicleName(), vehicaleName);
    }

    @Then("I should see Rides Count 1")
    public void iShouldSeeRidesCount1() {
        Assert.assertEquals(new MapPage().getRidesCounts(), "Rides: 1");
    }

    @Then("I should see Rides Count 2")
    public void iShouldSeeRidesCount2() {
        Assert.assertEquals(new MapPage().getRidesCounts(), "Rides: 2");
    }

    @When("I Tap on close vehicle button")
    public void iTapOnCloseVehicleButton() throws InterruptedException {
        new MapPage().tapOnCloseVehicle();
        new BasePage().wait(2000);
    }

    @When("I scroll up map")
    public void iScrollUpMap() {
        new BasePage().swipe("up", 3);
    }

    @When("I scroll digonal up map")
    public void iScrolldigonalUpMap() {
        new BasePage().swipe("dignolup", 3);
    }

    @Then("I should not see vehicle displayed on map")
    public void iShouldNotSeeVehicaledisplayedOnMap() throws Exception {
        Assert.assertFalse(new MapPage().verifyVehicaleNotDisplayed());
    }

    @When("I tap on map locator button")
    public void iTapOnMapLocatorButton() throws InterruptedException {
        new MapPage().tapOnMapLocatorButton();
        new BasePage().wait(2000);
    }

    @Then("I can see vehicle displayed back on map")
    public void iShoulSeeVehicaledisplayedOnMap() throws Exception {
        Assert.assertTrue(new MapPage().verifyVehicaleNotDisplayed());
    }

}
