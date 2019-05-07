@Challenges
Feature: Checking the Individual and Team Challenges functionality
  As a user I want to check the Challenges feature

  @C16973
  Scenario: Challenges page GUI - no challenges joined
    Given I am logged in with email: 'radoslaw+nochallengesjoined@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Challenges' page
    Then I am on 'Challenges' page
    When I scroll page to the bottom
    Then I see following labels on page:
      | Team vs team competition                                                 |
      | Join a team and compete against other teams to see who performs the best |
      | Global leaderboard competition                                           |
      | Compete against other users in a global competition.                     |
    And I see at least 1 instance of 'Challenge tile' element on page
    And all Challenge tiles have their GUI elements displayed

  @C16974
  Scenario: Challenges page GUI - challenges joined
    Given I am logged in with email: 'radoslaw+challengesjoined@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Challenges' page
    Then I am on 'Challenges' page
    Then I see following labels on page:
      | My joined challenges                                 |
      | Global leaderboard competition                       |
      | Compete against other users in a global competition. |
    When I scroll page to the bottom
    Then I see following labels on page:
      | Team vs team competition                                                  |
      | Join a team and compete against other teams to see who performs the best. |
    And I see at least 1 instance of 'Challenge tile' element on page
    And all Challenge tiles have their GUI elements displayed

  @C17511
  Scenario: As a user I want to Join an Individual Challenge
    Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Challenges' page
    Then I am on 'Challenges' page
    When I join QA Ind Reg challenge
    Then I am on 'QA Ind Reg' page
    When I scroll page to the top
    And I see following labels on page:
      | Ends in     |
      | place       |
      | steps       |
      | Leaderboard |
    When I enter 'Challenges' page
    Then I see the QA Ind Reg in My Challenges

  @C16823
  Scenario: As a user I want to Join an upcoming Individual Challenge
    Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Challenges' page
    Then I am on 'Challenges' page
    When I join QA Ind Up Reg challenge
    Then I am on 'QA Ind Up Reg' page
    And I see following labels on page:
      | Challenge starts in |
      | Need to know        |
      | DAYS                |
      | HOURS               |
      | MINS                |
    When I enter 'Challenges' page
    Then I see the QA Ind Up Reg in My Challenges

  @C16975
  Scenario: As a user I want to Join a Team Challenge
    Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Challenges' page
    Then I am on 'Challenges' page
    When I join QA Team Reg challenge
    Then I am on 'QA Team Reg' page
    And I see following labels on page:
      | Ends in |
      | teams   |
      | members |
      | steps   |
    And I see following elements on page:
      | View team members link |
      | View Leaderboard link  |
      | All posts tab          |
      | Team posts tab         |
    When I enter 'Challenges' page
    Then I see the QA Team Reg in My Challenges

  @C16823
  Scenario: As a user I want to Join an upcoming Team Challenge
    Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Challenges' page
    Then I am on 'Challenges' page
    When I join QA Team Up Reg challenge
    Then I am on 'QA Team Up Reg' page
    And I see following labels on page:
      | Challenge starts in        |
      | Need to know               |
      | DAYS                       |
      | HOURS                      |
      | MINS                       |
      | Come back soon to find out |
    When I enter 'Challenges' page
    Then I see the QA Team Up Reg in My Challenges

  @C16976
  Scenario Outline: As a user I want to connect a tracker from challenge
    Given I am logged in with email: 'radoslaw+challengesjoined@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Challenges' page
    Then I am on 'Challenges' page
    When I join <challenge> challenge
    And I opt to connect tracker
    Then I am on 'Trackers' page

    Examples: 
      | challenge   |
      | QA Ind Reg  |
      | QA Team Reg |

  @C17510
  Scenario Outline: As a user I want to leave a challenge
    Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Challenges' page
    Then I am on 'Challenges' page
    When I join <challenge> challenge
    And I opt to leave challenge
    And I enter 'Challenges' page
    Then I do not see the <challenges> in My Challenges

    Examples: 
      | challenge      |
      | QA Ind Reg     |
      | QA Team Reg    |
      | QA Ind Up Reg  |
      | QA Team Up Reg |
