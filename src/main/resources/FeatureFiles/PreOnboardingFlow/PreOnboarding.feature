@PreOnboarding
Feature: PreOnboarding
	   verify preonboarding screen functionality

 @PreOnboarding1 @C17483
  Scenario: Verifying PreOnboarding Feature 
    Given I am on 'Preonboarding' page
    Then I see following elements on page:
    |Skip button|
    |Next button|
    When I tap on the 'Next button'
    Then I see following elements on page:
    |Skip button|
    |Next button|
    When I tap on the 'Next button'
    When I tap on the 'Next button'
    When I tap on the 'Next button'
    Then I am on 'Login' page
    

