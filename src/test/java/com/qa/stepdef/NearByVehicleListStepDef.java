package com.qa.stepdef;

import com.qa.pages.NearByVehicleListPage;
import com.qa.utils.TestUtils;
import io.cucumber.java.en.Given;

public class NearByVehicleListStepDef {
    TestUtils utils = new TestUtils();

    @Given("I see all six vehicale display in list")
    public void iSeeAllSixVehicleInList() {
        new NearByVehicleListPage().verifyAllVehicleDisplayInList();
    }

    @Given("I get KickScooter D1 details")
    public void igetKicScooterD1Details() {
        new NearByVehicleListPage().getKikScooterD1Details();
    }

    @Given("I Tap on KickScooter D1")
    public void iTapOnKikScooterD1() {
        new NearByVehicleListPage().tapOnScooterD1();
    }

    @Given("I see KickScooter D1 details in dilogbox")
    public void iSeeKickScooterD1DetailsInDialogbox() {
        new NearByVehicleListPage().verifyKickScooterD1detail();
    }

}
