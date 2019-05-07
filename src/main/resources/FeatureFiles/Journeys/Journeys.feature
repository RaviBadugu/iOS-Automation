@Journeys
Feature: Checking functionalities related to Journeys

  Scenario Outline: Living with Diabetes - onboarding
    Given I am on 'Signup' page
    And I register with the following settings:
      | username                           | password    | motivation   | medication | gender | firstname | lastname | dataPreferencesHeight | dataPreferencesWeight | dataPreferencesDist |
      | radoslaw+not_onboarded@tictrac.com | password123 | <motivation> | break      | Female | none      | none     | none                  | none                  | none                |
    Then I am on '<additional_page>' page
    When I set following values on journey onboarding <additional_page> page:
      | medication      | type              |
      | <is_medication> | <type_medication> |
    And I tap on the 'Done button'
    Then I am on 'Your data preferences' page

    @C17620
    Examples: Manage my diabetes
      | motivation         | additional_page | is_medication | type_medication |
      | Manage my diabetes | Your medication | Yes           | Insulin         |
      | Manage my diabetes | Your medication | Yes           | Oral medication |
      | Manage my diabetes | Your medication | Yes           | all             |
      | Manage my diabetes | Your medication | No            | disabled        |

  Scenario Outline: Plan empty state - assessment not started
    Given I am logged in with email: 'radoslaw+lesscontent@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Profile Settings' page
    Then I am on 'Profile' page
    When I ensure Motivation is not <motivation>
    Then I am on 'Edit settings' page
    When I edit profile
    Then I am on 'Profile' page
    When I set Motivation to <motivation>
    And I tap on the 'Close navigation button'
    And I enter 'Plan' page
    Then I see following labels on page:
      | Answer our questions about your lifestyle |
    And I see following elements on page:
      | Get started button      |
      | Set up your plan header |

    @C17603
    Examples: Manage my diabetes
      | motivation         |
      | Manage my diabetes |

    @C17647
    Examples: Diabetes Prevention
      | motivation          |
      | Diabetes Prevention |

  Scenario Outline: Assessment basic functionality
    Given I am logged in with email: 'radoslaw+lesscontent@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Profile Settings' page
    And I ensure Motivation is not <motivation>
    And I edit profile
    And I set Motivation to <motivation>
    And I tap on the 'Close navigation button'
    And I enter 'Plan' page
    Then I am on 'Set up your plan' page
    When I tap on the 'Get started button'
    Then I am on '<motivationPage>' page
    When I select areas to focus if applicable:
      | <areaToFocus> |
    And I go through assessment with following answers:
      | <answer1>  |
      | <answer2>  |
      | <answer3>  |
      | <answer4>  |
      | <answer5>  |
      | <answer6>  |
      | <answer7>  |
      | <answer8>  |
      | <answer9>  |
      | <answer10> |
      | <answer11> |
      | <answer12> |
      | <answer13> |
      | <answer14> |
      | <answer15> |
      | <answer16> |
      | <answer17> |
    Then I am on 'Personalized habits' page
    And I see following labels on page:
      | This selection of habits is based on your answers |
      | Scroll down to see the full list                  |
      | <Habit1>                                          |
      | <Habit2>                                          |
      | <Habit3>                                          |

    @C17605
    Examples: Manage my diabetes
      | motivation         | motivationPage     | areaToFocus | answer1       | answer2             | answer3 | answer4 | answer5    | answer6 | answer7 | answer8 | answer9 | answer10 | answer11 | answer12 | answer13 | answer14 | answer15 | answer16 | answer17 | Habit1            | Habit2        | Habit3        |
      | Manage my diabetes | Manage My Diabetes | Cut sugar;  | Fizzy drinks; | Biscuits; Pastries; | Sweets; | None;   | Lethargic; | break   | break   | break   | break   | break    | break    | break    | break    | break    | break    | break    | break    | Swap fizzy drinks | Swap biscuits | Swap pastries |
      | Manage my diabetes | Manage My Diabetes |Cut sugar; Reduce fats; | Hot drinks;   | Ice cream;          | Dried fruit; | 1-5;    | Fatty red meats; | Fast food; | Lethargic; | break   | break   | break    | break    | break    | break    | break    | break    | break    | break    | Swap dried fruit snacks | Swap red meat | Swap sugar in hot drinks |
