@Registration&Onboarding
Feature: Checking the Registration&Onboarding functionality
  As a user I want to check the Registration&Onboarding feature

  Background: Navigate to Signup page
    Given I am on 'Signup' page

  @C16846
  Scenario Outline: Signup and onboarding - happy path
    Given I register with the following settings:
      | username   | password   | motivation   | medication   | gender   | firstname   | lastname   | dataPreferencesHeight   | dataPreferencesWeight   | dataPreferencesDist   |
      | <username> | <password> | <motivation> | <medication> | <gender> | <firstname> | <lastname> | <dataPreferencesHeight> | <dataPreferencesWeight> | <dataPreferencesDist> |

    #Disabled to avoid completing the registration
    #Then I am on 'Home' page
    Examples: 
      | username    | password    | motivation   | medication | gender | firstname | lastname | dataPreferencesHeight | dataPreferencesWeight | dataPreferencesDist |
      | radoslaw+tr | password123 | Sleep Better | none       | Male   | TestFirst | TestLast | cm                    | kg                    | km                  |

    @C17644
    Examples: 
      | username    | password    | motivation          | medication | gender | firstname | lastname | dataPreferencesHeight | dataPreferencesWeight | dataPreferencesDist |
      | radoslaw+tr | password123 | Diabetes Prevention | unchanged  | Male   | TestFirst | TestLast | cm                    | kg                    | km                  |

  # ToDo P3
  #@C16861
  #Scenario Outline: Onboarding - break onboarding
  #Given I intend to register with the following settings:
  #| username   | password   | motivation   | medication   | gender   | firstname   | lastname   | dataPreferencesHeight | dataPreferencesWeight | dataPreferencesDist |
  #| <username> | <password> | <motivation> | <medication> | <gender> | <firstname> | <lastname> | <dataPreferencesHeight> | <dataPreferencesWeight> | <dataPreferencesDist> |
  #Then I go through the onboarding
  #And I restart the app
  #Then I am on '{any-text}' page
  #
  #Examples:
  #| username    | password    | motivation | medication | gender | firstname | lastname | dataPreferencesHeight | dataPreferencesWeight | dataPreferencesDist |
  # the 'closeapp' tells the test to close the app at this point
  #| radoslaw+tr | password123 | closeapp   | none       | none   | none      | none     | none   | none      | none     |
  # Keeps failing - tapping the T&C link seems not responding (could be real issue, needs investigation)
  @C17484
  Scenario: Navigate to T&Cs screen when onboarding
    Given I enter login details as radoslaw+showTC@tictrac.com / password123 and stop at TandC page
    Then I am on 'Terms and Conditions view' page
    And I tap on the 'TandC link'
    Then I am on 'Terms and Conditions webview' page

  @C17485
  Scenario: Navigate to Data Policy screen when onboarding
    Given I enter login details as radoslaw+showDP@tictrac.com / password123 and stop at Data Privacy page
    Then I am on 'Data Privacy' page
    When I tap on the 'Data Privacy link'
    Then I am on 'Data Privacy webview' page
