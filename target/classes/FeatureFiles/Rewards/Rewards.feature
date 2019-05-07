@Rewards
Feature: Checking Rewards Functionality
  As a user I want to check how to claim and few reward status in Rewards page

  Background: 
    Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'

  @C17346
  Scenario: Access to Rewards page
    Then I see following elements on page:
      | Reward Points label |
    When I tap on the 'Reward entry header'
    Then I am on 'Reward Points' page

  @C17354
  Scenario: Rewards listing screen
    When I tap on the 'Reward entry header'
    Then I am on 'Reward Points' page
    And I see following labels on page:
      | Earn a maximum                   |
      | Check off a habit                |
      | Setup a new goal                 |
      | Log data towards a goal          |
    When I tap on the 'How to earn points Expander'
    Then I do not see the following text on page: 'Earn a maximum'
    And I see following labels on page:
      | FEATURED     |
    When I scroll page 1 time down
    Then I see following labels on page:
      | MORE REWARDS     |
    And I see at least 1 instance of 'Rewards tile' element on page

  @C17355
  Scenario: As a user I want to verify Reward Detail screen
    When I tap on the 'Reward entry header'
    Then I am on 'Reward Points' page
    When I open 'Save £10000 on QA Test' reward
    Then I am on 'Home' page
    And I see following labels on page:
      | Save £10000 on QA Test |
      | months |
      | 20 Reward Points |
      | Terms and conditions |
    And I see following elements on page:
      | Get this reward button |
    And I see the following text on page: 'This is the description of the Test Reward to support QA test cycles'
    And I see the following text on page: 'Offer is valid until told otherwise'

  # To be enabled once we're able to register new user each time
  #@C17356
  #Scenario: As a user I want to Claim a Reward
    #When I tap on the 'Reward entry header'
    #Then I am on 'Reward Points' page
    #When I scroll page 1 time down
    #And I open 'Save £100 on DNAFit\'s Fitness Diet' reward
    #Then I am on 'Home' page
    #When I tap on the 'Get this reward button'
    #Then I see following labels on page:
      #| Are you sure?  |
      #| We will deduct |
    #When I tap on the 'Claim now button'
    #Then I see following labels on page:
      #| email you with further information |
      #| claimed this reward                |
    #And I do not see the following text on page: 'Get this reward'

  @C17581
  Scenario: As a user I want to see you dont have enough points to claim in Reward Detail Screen
    When I tap on the 'Reward entry header'
    Then I am on 'Reward Points' page
    When I open 'Pay £10k more than usually' reward
    Then I am on 'Home' page
    And I do not see the following text on page: 'Get this reward'
    And I should see the following element on page: 'Not enough points button'
    When I tap on the 'Not enough points button'
    Then I am on 'Home' page
    And I should see the following element on page: 'Not enough points button'
