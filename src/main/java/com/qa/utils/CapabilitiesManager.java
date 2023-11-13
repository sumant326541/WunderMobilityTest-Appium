package com.qa.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {
    TestUtils utils = new TestUtils();

    public DesiredCapabilities getCaps() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        try {
            utils.log().info("getting capabilities");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", params.getPlatformName());
            caps.setCapability("udid", params.getUDID());
            caps.setCapability("deviceName", params.getDeviceName());

            switch (params.getPlatformName()) {
                case "Android":
                    caps.setCapability("automationName", props.getProperty("androidAutomationName"));
                    caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
                    caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
                    caps.setCapability("systemPort", params.getSystemPort());
                    caps.setCapability("chromeDriverPort", params.getChromeDriverPort());
                    String AppUrl = props.getProperty("androidAppLocation");
                    String androidAppUrl = System.getProperty("user.dir") + AppUrl;
                    utils.log().info("appUrl is" + androidAppUrl);
                    caps.setCapability("app", androidAppUrl);
                    break;
                case "iOS":
                    caps.setCapability("automationName", props.getProperty("iOSAutomationName"));
                    String Url = props.getProperty("iOSAppLocation");
                    String iOSAppUrl = System.getProperty("user.dir") + Url;
                    caps.setCapability("bundleId", props.getProperty("iOSBundleId"));
                    caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
                    caps.setCapability("webkitDebugProxyPort", params.getWebkitDebugProxyPort());
                    caps.setCapability("app", iOSAppUrl);
                    break;
            }
            return caps;
        } catch (Exception e) {
            e.printStackTrace();
            utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
            throw e;
        }
    }
}
