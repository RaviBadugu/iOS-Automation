@ProfileSettings
Feature: Checking the Profile settings functionality
  As a user I want to check the profile settings feature

  Background: Login to the app and navigate to Account Settings
    Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Profile Settings' page
    Then I am on 'Profile' page

  @C17143
  Scenario: Profile page GUI
    When I scroll page to the bottom
    Then I see following labels on page:
      | Email        |
      | First name   |
      | Last name    |
      | Display name |
      | Birthday     |
      | Gender       |
      | Height       |
      | Location     |
      | Motivation   |
    Then I see following elements on page:
      | Email input field        |
      | First name input field   |
      | Last name input field    |
      | Display name input field |
      | Change photo button      |
      | Save navigation button   |

  @C17145
  Scenario: As a user I want to edit email in profile screen
    When I type in the following string into Email input field: 'ravi+061@tictrac.com'
    And I tap on the 'Save button'
    Then I am on 'Edit settings' page

  @C17146
  Scenario: As a user I want to see validation for email in profile screen
    When I type in the following string into Email input field: 'wrongemail'
    And I tap on the 'Save button'
    Then I see the following text on page: 'Enter a valid email address'
    And I am on 'Profile' page

  @C17147
  Scenario: As a user I want to edit First Name in profile screen
    When I type in the following string into First name input field: 'NewName'
    And I tap on the 'Save button'
    Then I am on 'Edit settings' page

  @C17148
  Scenario: As a user I want to see validation for First Name in profile screen
    When I type in the following string into First name input field: ''
    And I tap on the 'Save button'
    Then I see the following text on page: 'This field may not be blank'
    And I am on 'Profile' page

  @C17149
  Scenario: As a user I want to edit Last Name in profile screen
    When I type in the following string into Last name input field: 'NewLastName'
    And I tap on the 'Save button'
    Then I am on 'Edit settings' page

  @C17150
  Scenario: As a user I want to see validation for Last Name in profile screen
    When I type in the following string into Last name input field: ''
    And I tap on the 'Save button'
    Then I see the following text on page: 'This field may not be blank'
    And I am on 'Profile' page

  @C17151
  Scenario: As a user I want to edit Display Name in profile screen
    When I type in the following string into Display name input field: 'NewDisplayName'
    And I tap on the 'Save button'
    Then I am on 'Edit settings' page

  @C17152
  Scenario: As a user I want to see validation for Display Name in profile screen
    When I type in the following string into Display name input field: ''
    And I tap on the 'Save button'
    Then I see the following text on page: 'This field may not be blank'
    And I am on 'Profile' page

  @C17153
  Scenario: As a user I want to edit Date Of Birth in profile screen
    When I update Date Of Birth on profile page
    And I tap on the 'Save button'
    Then I am on 'Edit settings' page

  @C17155
  Scenario: As a user I want to edit Gender in profile screen
    When I update Gender on profile page
    And I tap on the 'Save button'
    Then I am on 'Edit settings' page

  @C17159
  Scenario: As a user I want to edit Height in profile screen
  	When I scroll page 1 time down
    And I update Height on profile page
    And I tap on the 'Save button'
    Then I am on 'Edit settings' page

  @C17156
  Scenario: As a user I want to edit Location in profile screen
  	When I scroll page 1 time down
    And I update Location on profile page
    And I tap on the 'Save button'
    Then I am on 'Edit settings' page

  @C16942
  Scenario Outline: As a user I want to edit Motivation in profile screen
    When I set Motivation to <motivation>
    Then I am on 'Edit settings' page
    And I see the following text on page: '<motivation>'

    Examples: 
      | motivation   |
      | Get Fit      |
      | Live Healthy |
      | Sleep Better |
      | Lose Weight  |

    @C17645
    Examples: Diabetes Prevention
      | motivation          |
      | Diabetes Prevention |

    @C17621
    Examples: Manage my Diabetes
      | motivation         |
      | Manage my diabetes |
