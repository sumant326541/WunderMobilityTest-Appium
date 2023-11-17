@map @test
Feature: Map scenarios

  Scenario: Verify six vehicales, maplocator and near By vehicales button displayed on Map
    Given I'm logged in to App
    Then I should see six vehicales on map
    Then I should see vehicle map locator on map
    Then I should see near By vehicales button on map

  Scenario: Verify map locator functionality
    Given I'm logged in to App
    Then I should see vehicle map locator button is disabled
    Then I Tap on a vehicle displayed on map
    Then I scroll up map
    Then I should not see vehicle displayed on map
    Then I tap on map locator button
    Then I can see vehicle displayed back on map

  Scenario: Rent a Vehicle
    Given I'm logged in to App
    Then I Tap on a vehicle displayed on map
    Then I Tap on RENT VEHICLE
    Then I tap on END RENT
    Then I should see Rides Count 1
    Then I Tap on RENT VEHICLE
    Then I tap on END RENT
    Then I should see Rides Count 2
    Then I Tap on close vehicle button
    Then I Tap on a vehicle displayed on map
    Then I should see Rides Count 2
    Then I Tap on RENT VEHICLE
    Then I Tap on close vehicle button
    Then I scroll digonal up map
    Then I Tap on new vehicle displayed on map
    Then I Tap on go to rented vehicle button
    Then I should see current rented vehicle












