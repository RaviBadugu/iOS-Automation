@Progress
Feature: Checking the Progress functionality End to End
  As a user I want to Check and veify the progress functioanlity end to end

  @Progress1 @C16951 @P1
  Scenario: As a user I want to verify a empty state screen in Progress Page
    Given I am logged in with email: 'radoslaw+emptystates1@tictrac.com' and password: 'password123'
    When I enter 'Progress' page
    Then I see the following text on page: 'Tailor this page to show the progress towards the goals that matter the most to you now'
    And I should see the following element on page: 'Add Goal button'

  @Progress2 @P1 @C16952
  Scenario: As a user I want to verify the progress screen with widgets
    Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Progress' page
    Then I should see the following element on page: 'Progress header'
    And I should see the following element on page: 'Add Goal button'
    And I see at least 1 instance of 'Progress Widget' element on page
    And every widget has all expected elements

  #Progress3 covered in this scenario
  @C16980 @C16954 @C17423 @Progress4 @Progress5 @Progress6 @P1 @C16997
  Scenario Outline: Add <WidgetType> Widget - set a goal
    Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Progress' page
    And I tap on the 'Add Goal button'
    And I select '<WidgetType>' widget
    And I set the '<WidgetType>' goal to achieve and tap on Set Goal
    Then I should see the '<WidgetType>' widget in Progress Page with Target Goal and Latest data in the widget

    Examples: 
      | WidgetType      |
      #| Weight          |
      #| Sleep           |
      #| Calories Intake |
      | Steps						|

  @Progress18 @C16983 @C17426 @C16957 @P2
  Scenario Outline: Update Goal from a <WidgetType> Widget Contextual Menu
    Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Progress' page
    And I ensure the <WidgetType> widget is visible
    And I open Contextual menu of a '<WidgetType>' widget
    And I see the Edit Goal Option in the list and tap on it
    And I set the '<WidgetType>' goal to achieve and tap on Set Goal
    Then I should see the '<WidgetType>' widget in Progress Page with Target Goal and Latest data in the widget

    Examples: 
      | WidgetType      |
      | Weight          |
      | Sleep           |
      | Calories Intake |

  @C16958 @C16984 @C17427 @P1
  Scenario Outline: Log <WidgetType> datapoint
    Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Progress' page
    And I ensure the <WidgetType> widget is visible
    And I open Contextual menu of a '<WidgetType>' widget
    And I see the Log Data Option in the list and tap on it
    And I log the default value for the '<WidgetType>'
    Then I should see the '<WidgetType>' widget in Progress Page and the value in the widget is changed

    Examples: 
      | WidgetType      |
      | Weight          |
      | Sleep           |
      | Calories Intake |
      | Steps						|

	@P2 @C16985 @C16959 @C17428
	Scenario Outline: Log <WidgetType> datapoint in the past
    Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Progress' page
    And I ensure the <WidgetType> widget is visible
    And I open Contextual menu of a '<WidgetType>' widget
    And I see the Log Data Option in the list and tap on it
    And I log the default value in the past for the '<WidgetType>'
    Then I should see the '<WidgetType>' widget in Progress Page and the value in the widget is NOT changed	
    
    Examples: 
      | WidgetType      |
      | Weight          |
      | Sleep           |
      | Calories Intake |
      
  @P2 @C16989 @C16963 @C17432
  Scenario Outline: Edit and Update <WidgetType> datapoint
  	Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Progress' page
    And I ensure the <WidgetType> widget is visible
    And I open <WidgetType> widget detail page
    And I open Contextual menu on current page
    And I see the View all data Option in the list and tap on it
    Then I see at least 1 instance of 'Single datapoint with edit' element on page
    When I tap on the 'First Edit button'
    And I log the default value for the '<WidgetType>'
    Then I see the following text on page: 'Data edited successfully'    
    
    Examples: 
      | WidgetType      |
      | Weight          |
      | Sleep           |
      | Calories Intake |
      
  @P2 @C16964 @C16990 @C17433
  Scenario Outline: Remove <WidgetType> datapoint
    Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Progress' page
    And I ensure the <WidgetType> widget is visible
    And I open <WidgetType> widget detail page
    And I open Contextual menu on current page
    And I see the View all data Option in the list and tap on it
    Then I see at least 1 instance of 'Single datapoint with edit' element on page
    When I tap on the 'First Edit button'
    And I tap on the 'Delete button'
    Then I am on 'My data' page
    And I see 1 less editable datapoints
    
    Examples: 
      | WidgetType      |
      | Weight          |
      | Sleep           |
      | Calories Intake |
	
  @P1 @C16961
  Scenario: Remove a widget
    Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Progress' page
    # And I ensure there is a Progress Widget on the page
    And I open Contextual menu of a widget
    And I see the Remove Option in the list and tap on it
    Then the widget is removed from Progress Page

  #@Progress7
  #Scenario: As a user I want to add a Activity based widget on to Progress Page
    #Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    #When I enter 'Progress' page
    #And I tap on the 'Add Goal button'
    #And I see the Activity Option in Select a widget screen
    #And I tap on Activity Option
    #And I navigate to Select a widget in activity options to choose
    #And I should see Steps, Swimming, Workout, Cycling and Running options
    #And I select one among them
    #And I set goal to achieve and tap on Set Goal
    #Then I should navigate to Progress with the selected widget added in the screen

  #@Progress8
  #Scenario: As a user I want to add Steps widget to Progress Page
    #Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    #When I enter 'Progress' page
    #And I tap on Add Goal and select Steps from Activity list
    #Then I should see the Steps widget added in the Progress Page with Target Goal and Today Data if any

  #@Progress9
  #Scenario: As a user I want to add Workout widget to Progress Page
    #Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    #When I enter 'Progress' page
    #And I tap on Add Goal and select Workout from Activity list
    #Then I should see the Workout widget added in the Progress Page with Target Goal and This Week Data if any

  #@Progress10
  #Scenario: As a user I want to add Swimming Duration widget to Progress Page
    #Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    #When I enter 'Progress' page
    #And I tap on Add Goal and select Swimming Duration from Activity list
    #Then I should see the Swimming Duration widget added in the Progress Page with Target Goal and This Week Data if any
#
  #@Progress11
  #Scenario: As a user I want to add Swimming Distance widget to Progress Page
    #Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    #And I enter 'Progress' page
    #When I tap on Add Goal and select Swimming Distance from Activity list
    #Then I should see the Swimming Distance widget added in the Progress Page with Target Goal and This Week Data if any
#
  #@Progress12
  #Scenario: As a user I want to add Cycling Duration widget to Progress Page
    #Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    #When I enter 'Progress' page
    #And I tap on Add Goal and select Cycling Duration from Activity list
    #Then I should see the Cycling Duration widget added in the Progress Page with Target Goal and This Week Data if any
#
  #@Progress13
  #Scenario: As a user I want to add Cycling Distance widget to Progress Page
    #Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    #When I enter 'Progress' page
    #And I tap on Add Goal and select Cycling Distance from Activity list
    #Then I should see the Cycling Distance widget added in the Progress Page with Target Goal and This Week Data if any
#
  #@Progress14
  #Scenario: As a user I want to add Running Duration widget to Progress Page
    #Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    #When I enter 'Progress' page
    #And I tap on Add Goal and select Running Duration from Activity list
    #Then I should see the Running Duration widget added in the Progress Page with Target Goal and This Week Data if any
#
  #@Progress15
  #Scenario: As a user I want to add Running Distance widget to Progress Page
    #Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    #When I enter 'Progress' page
    #And I tap on Add Goal and select Running Distance from Activity list
    #Then I should see the Running Distance widget added in the Progress Page with Target Goal and This Week Data if any

  @Progress19 @C16956 @P2 @C17425 @C16982
  Scenario Outline: Connect Tracker from a <WidgetType> Widget Contextual Menu
    Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Progress' page
    And I ensure the <WidgetType> widget is visible
    And I open Contextual menu of a '<WidgetType>' widget
    And I see the Connect Tracker Option in the list and tap on it
    Then I see at least 1 instance of 'Tracker name' element on page
    When I connect <tracker> tracker
    Then the <tracker> tracker is connected

    Examples: 
      | WidgetType      | tracker |
      | Weight          | Fitbit  |
      | Sleep           | Fitbit  |
      | Calories Intake | Fitbit  |

	@C16962 @P2 @C16988 @C17431
	Scenario Outline: View all data in <WidgetType> widget detail page
		Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Progress' page
    And I ensure the <WidgetType> widget is visible
    And I open <WidgetType> widget detail page
    And I open Contextual menu on current page
    And I see the View all data Option in the list and tap on it
    Then I see at least 1 instance of 'Single datapoint' element on page
    
    Examples: 
      | WidgetType      |
      | Weight          |
      | Sleep           |
      | Calories Intake |

	@C16970 @C16996 @C17439 @P2
	Scenario Outline: Detail page <WidgetType> empty states
		Given I am logged in with email: 'radoslaw+emptygraphs@tictrac.com' and password: 'password123'
    When I enter 'Progress' page
    And I ensure the <WidgetType> widget is visible
    And I open <WidgetType> widget detail page
    Then I see the following text on page: 'No data to show'
    And I see the following text on page: 'Try to log data, connect a tracker or change the timeframe'
    And I should see the following element on page: 'Fact section'
    When I switch the timeframe tab to '2 months'
    Then I see the following text on page: 'No data to show'
    And I see the following text on page: 'Try to log data, connect a tracker or change the timeframe'
    And I should see the following element on page: 'Fact section'
    
    Examples: 
      | WidgetType      |
      | Weight          |
      | Sleep           |
      | Calories Intake |

  #@Progress21
  #Scenario: As a user I want to Log Data through Widget Detail screen
    #Given As a user I am in Widget Detail Screen
    #When I tap on Log Data button
    #And I navigate to widget specific data logging screen
    #And I add data and tap on Save button
    #Then I should see the data appear in the graph

  #@Progress22
  #Scenario: As a user I want to Connect Tracker through Widget Detail screen
    #Given As a user I am in Widget Detail Screen
    #When I tap on Connect Tracker button
    #Then I should navigate to Trackers screen to connect

  #@Progress24
  #Scenario: As a user I want to Edit Goal through contextual Menu in Widget Detail Screen
    #Given As a user I am in Widget Detail Screen
    #When I tap on Contextual Menu
    #And I tap on Edit Goal
    #And I see the Widget Specific Edit Goal Screen
    #And I Edit the goal to achieve and save
    #Then I should see the goal updated in graph
#
  #@Progress25
  #Scenario: As a new user I want to see the Empty State My Data Screen
    #Given As a new user I am in Widget Detail Screen
    #When I tap on View all Data in Contextual Menu list
    #Then I should see the Empty State My Data Screen
