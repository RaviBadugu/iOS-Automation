@Login
Feature: Checking the Login functionality
  As a user I want to check the login feature

  @C16847
  Scenario: Login as registered user
    Given I am logged in with email: 'radoslaw+nochallengesjoined@tictrac.com' and password: 'lakshmi9298'
    Then I am on 'Home' page

  Scenario Outline: As a user I want to validate login functionality
    Given I am on 'Start Login' page
    When I attempt to login as <username> with password <password>
    Then I am on 'Login' page

    @C16857
    Examples: 
      | username              | password    |
      | ravvi+061@tictrac.com | lakshmi9298 |

    @C16858
    Examples: 
      | username             | password    |
      | ravi+061@tictrac.com | lakshmi9290 |

  @C16867
  Scenario: Retrieve forgotten password
    Given I am on 'Start Login' page
    When I tap on the 'Forgotten password link'
    Then I am on 'Forgot Password' page
    And I see following labels on page:
      | Enter your email to find your account |
    When I type in the following string into Email input field: 'radoslaw+337@tictrac.com'
    And I tap on the 'Continue button'
    Then I see following labels on page:
      | Email Sent                                                      |
      | Please check your email for instructions to reset your password |
    When I tap on the 'OK button'
    Then I am on 'Preonboarding' page
