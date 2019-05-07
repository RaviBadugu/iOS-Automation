@Settings
Feature: Checking the Settings main page functionality

  Background: 
    Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Settings' page

  @P1 @C16941
  Scenario: Settings page GUI
    Then I see following elements on page:
      | Account header              |
      #| user avatar               |
      #| user name                 |
      #| user motivation           |
      | Connected trackers button   |
      | Friends button              |
      | Help and Support button     |
      | Close navigation button     |
      | Security and Privacy button |
      | Notifications button        |
      | Account Edit button         |
      | Profile Edit button         |
