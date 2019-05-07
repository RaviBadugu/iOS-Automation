@Timeline
Feature: Checking Timeline feature
  
  Background:
  	Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Home' page
    Then I am on 'Home' page
    When I scroll page 1 time down

  @Library @16827 @P1
  Scenario: Timeline page GUI
    Then I see following elements on page:
      | Account icon       |
      | Notification icon  |
    Then I see at least 1 instance of 'Timeline card' element on page

# Xpath used for these tests use a lot of computing power and tend to fail
# Ids needed in the future
  #@Library @16832 @P1
  #Scenario: Timeline card GUI
    #Then I see the Timeline card with all the GUI elements
#
  #@Library @16832 @P2
  #Scenario: Share personal card with followers
    #Then I can share Timeline card with followers

  	  
