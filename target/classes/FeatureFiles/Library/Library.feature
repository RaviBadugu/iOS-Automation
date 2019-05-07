@Library
Feature: Checking Library feature
  
  Background:
  	Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Library' page

  @Library @16827 @P1
  Scenario: As a user I want to see Recommended and Topics sections in Library Screen
    Then I Should see Recommended and Topics sections in the screen
    When I tap on the 'Recommended button'
    Then I see at least 1 instance of 'item tile' element on page
    When I tap on the 'Topics button'
    Then I see at least 1 instance of 'item tile' element on page

  @Library @16832 @P1
  Scenario: As a user I want to go to Recommended section and click on article
  	When I tap on the 'Recommended button'
  	And I open an article
    Then I see the article with all the GUI elements

  @Library @16832 @P2
  Scenario: As a user I want to go to Topics section and select a topic and click on article
    When I tap on the 'Topics button'
    And I tap on random topic tile
    Then I see a relevant Topic header on page
    And I see at least 1 instance of 'item tile' element on page
    When I open an article from the Topic list
    Then I see the article with all the GUI elements

  	  
