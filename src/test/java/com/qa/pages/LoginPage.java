package com.qa.pages;

import com.qa.utils.TestUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(id = "com.wundermobility.qatest:id/edtLoginEmail")
    private WebElement usernameTxtFld;

    @AndroidFindBy(id = "com.wundermobility.qatest:id/edtLoginPassword")
    private WebElement passwordTxtFld;

    @AndroidFindBy(id = "com.wundermobility.qatest:id/btnLogin")
    private WebElement loginBtn;

    @AndroidFindBy(id = "com.wundermobility.qatest:id/txtLoginError")
    private WebElement errTxt;

    public LoginPage() {
    }

    public LoginPage enterUserName(String username) throws InterruptedException {
        clear(usernameTxtFld);
        sendKeys(usernameTxtFld, username, "login with " + username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        clear(passwordTxtFld);
        sendKeys(passwordTxtFld, password, "password is " + password);
        return this;
    }

    public MapPage pressLoginBtn() {
        click(loginBtn, "press login button");
        return new MapPage();
    }

    public MapPage login(String username, String password) throws InterruptedException {
        enterUserName(username);
        enterPassword(password);
        return pressLoginBtn();
    }

    public String getErrTxt() {
        String err = getText(errTxt, "error text is - ");
        return err;
    }

}
