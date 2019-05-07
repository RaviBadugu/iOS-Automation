@Trackers
Feature: Checking Connecting Trackers feature
  As a user I want to Connect and Diconnect Trackers in Trackers screen

  @Trackers1
  Scenario: As a user I want to Verify Trackers screen
    Given As a user I am in Account Screen
    When I tap on Connected Trackers option
    Then I Should navigate to Trackers Screen
    And I Should see list of trackers in Recommended and More Trackers section with Connected trackers section if any connected

  @Trackers4
  Scenario: As a user I want to view the connect tracker page
    Given As a user I am in trackers screen
    When I go the trackers page and click the more info link
    Then I should be taken to the tracker information page

  @P1 @C16937
  Scenario Outline: Connect <tracker> tracker
  	Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Connected trackers' page
    And I connect <tracker> tracker
    Then the <tracker> tracker is connected
    
    Examples:
    |tracker			|
    |Fitbit				|
   	|Apple Health	|
