@SecurityAndPrivacy
Feature: Checking Security and Privacy Settings feature

  Background: Login to the app and navigate to Security and Settings
    Given I am logged in with email: 'radoslaw+337@tictrac.com' and password: 'password123'
    When I enter 'Security and Privacy Settings' page
    Then I am on 'Security and privacy' page

  @C17710
  Scenario: Security and Privacy page GUI
    Then I see following labels on page:
      | Security         |
      | Current password |
      | New password     |
      | Confirm password |
      | Privacy          |
    And I see the following text on page: 'Do not allow others to search for me'
    And I see following elements on page:
      | Save navigation button |
      | Privacy switcher       |

  #This can be used once we find a way to register new user
  #@C17167
  #Scenario: As a user I want to Change Password
  #When I type in the following string into Current password input field: 'lakshmi9298'
  #And I type in the following string into New password input field: 'newPassword123'
  #And I type in the following string into Confirm password input field: 'newPassword123'
  #And I tap on the 'Save button'
  #Then I am on 'Edit settings' page
  
  @C17168
  Scenario: As a user I want to see the validations in Change Password Page
    Then I see the relevant validation message when enter incorrect password details
      | Current password | New password  | Confirm password | Validation                                          |
      | wrongpassword    | password1234  | password1234     | Current password was invalid                        |
      | password123      | password1234  | wrongpassword    | New passwords do not match                          |
      | password123      | wrongpassword | password1234     | New passwords do not match                          |
      | password123      | a             | a                | The new password must be at least 8 characters long |
      | password123      | a1b2c3d       | a1b2c3d          | The new password must be at least 8 characters long |
      | password123      | password123   | password123      | New password cannot be equal to current password    |

  @C17158
  Scenario: Update privacy settings
  	When I update privacy settings
    And I tap on the 'Save button'
    Then I am on 'Edit settings' page
