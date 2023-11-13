package com.qa.stepdef;

import com.qa.pages.LoginPage;
import com.qa.pages.MapPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {

    @When("I enter username as {string}")
    public void iEnterUsernameAs(String username) throws InterruptedException {
        new LoginPage().enterUserName(username);
    }

    @When("I enter password as {string}")
    public void iEnterPasswordAs(String password) {
        new LoginPage().enterPassword(password);
    }

    @When("I Tap on login Button")
    public void iLogin() {
        new LoginPage().pressLoginBtn();
    }

    @Then("login should fail with an error {string}")
    public void loginShouldFailWithAnError(String err) {
        Assert.assertEquals(new LoginPage().getErrTxt(), err.trim());
    }

    @Then("I should see Map page title")
    public void iShouldSeeMapPageWithTitle() {
        Assert.assertEquals(new MapPage().getTitle(), "QA Test");
    }
}
