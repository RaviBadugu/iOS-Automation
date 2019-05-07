@HelpAndSupport
Feature: Verifying the Help and Support page features
  
  Background:
  Given I am logged in with email: 'aruna.kumari+30@tictrac.com' and password: 'password30'
  When I enter 'Help' page
  Then I am on 'Help' page

  @HelpAndSupport1 @C17281
  Scenario: Help page GUI
    Then I see following elements on page:
    |Send feedback button|
    |FAQs button|
    |Terms of Use and Privacy Policy button|
    
  @HelpAndSupport2 @C17709
  Scenario: Send feedback GUI
  	When I tap on the 'Send feedback button'
  	Then I am on 'Send feedback' page
    
  @HelpAndSupport3 @C17283
	  Scenario: FAQs GUI
	  When I tap on the 'FAQs button'
	  Then I am on 'FAQ' page
	  And I see following labels on page:
	  |FAQ|
	  |Personal Details|
	  |Timeline|
	  
  @HelpAndSupport4 @C17284
	  Scenario: Terms & Conditions page GUI
	  When I tap on the 'Terms of Use and Privacy Policy button'
	  Then I am on 'Terms of Use and Privacy Policy' page
	  And I see following labels on page:
	  |Terms and Conditions|
	  |Privacy Policy|
	  |Cookie Policy|
