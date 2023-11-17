@vehicleList @test
Feature: Near By vehicle list scenarios

  Scenario: Verify near by vehicle list
    Given I'm logged in to App
    Then I Tap on near by vehicle List button
    Then I see all six vehicale display in list

  Scenario: Verify vehicle details in dialog box
    Given I'm logged in to App
    Then I Tap on near by vehicle List button
    Then I get KickScooter D1 details
    Then I Tap on KickScooter D1
    Then I see KickScooter D1 details in dilogbox

  Scenario: Verify vehicle price unit
    Given I'm logged in to App
    Then I Tap on near by vehicle List button
    Then I see price unit for vehicle
