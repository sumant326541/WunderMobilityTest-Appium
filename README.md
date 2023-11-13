<img width="100" alt="Screenshot 2021-06-29 at 8 12 27 AM" src="https://user-images.githubusercontent.com/39675511/123728969-d2a87b00-d8b1-11eb-9ece-558d4021f816.png">

# WunderMobilityTest-Appium
Appium Mobile Automation with Appium, BDD cucumber,Maven, java and Junit

Technologies/Tools used in building the framework
=================================================
- IntelliJ - IDE
- Appium - Mobile Automation library
- Maven - Build automation tool
- Java - Programming language
- Cucumber - BDD
- Gherkin - DSL
- JUnit - Unit testing framework
- Log4J - Logging framework
- Extent Reports - Reporting framework

## Configuration
# Install Appium:
```sh
npm i appium
```
# Install Appium driver for Android:
```sh
appium driver install uiautomator2
```
- make sure android sdk path, maven path and java path has been updated
- set path of .apk in config.properties inside resourse folder
- also update Appium capabilities in config.propertie, GlobalParams and CapabilitiesManager as per device used


## Test Execution
- No need to start  appim server - it will start automatically while running test
- make sure Android Emulator is open
- Run test by below command
```sh
mvn clean install
```

## Report
### html report generated

- html report > /target/cucumber/report.html 

### Log
- Appliaction Log and Service Log inside Android_emulator folder after execution
- 
### Screen Recording
- For each test case video will generate inside Android_emulator/videos folder after execution

