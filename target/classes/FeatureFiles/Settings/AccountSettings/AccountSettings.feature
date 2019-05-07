@AccountSettings
Feature: Checking the AccountSettings functionality
  As a user I want to check the AccountSettings feature

  Background: Login to the app and navigate to Account Settings
    Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Account Settings' page

  @C17169
  Scenario: Account Settings GUI
    Then I see following elements on page:
      | Account header          |
      | Data preferences title  |
      | Height label            |
      | Height units switcher   |
      | Weight label            |
      | Weight units switcher  |
      | Distance label          |
      | Distance units switcher |
      | Export data button      |
      | Log out button          |
      | Close account button    |
      | Save navigation button  |

  @C17171
  Scenario: As a user I want to Export Data in the app
    When I tap on the 'Export Data button'
    Then I see the following text on page: 'Your data is being prepared. We\'ll notify you when it\'s ready.'
    When I tap on the 'Ok button'
    Then the Export data PopUp disappeared

  @C16943
  Scenario: As a user I want to LogOut of the app
    When I tap on the 'Log out button'
    Then I am on 'Login' page

  #This to be excluded until we'll be able to create users automatically
  #@C17172
  #Scenario: As a user I want to CloseAccount in the app
  #When I tap on the 'Close Account button'
  #Then I see the following text on page: 'Are you sure you want to permanently close your account'
  #And I tap on the 'Close Account button'
  #Then I am on 'Login' page
  
  @C17170
  Scenario: As a user I want to change units in the app
    Then I can change my units settings
      | ft |
      | cm |
      | st |
      | kg |
      | lb |
      | mi |
      | km |

  @AccountSettings5
  Scenario: As a user I want to Save the settings of the app
    When I tap on the 'Save button'
    Then I am on 'Edit settings' page
