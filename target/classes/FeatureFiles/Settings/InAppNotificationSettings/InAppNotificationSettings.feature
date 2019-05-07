@InAppNotificationSettings
Feature: Verifying the Notification Settings page features

  Background: Login to the app and navigate to Account Settings
    Given I am logged in with email: 'ravi+061@tictrac.com' and password: 'lakshmi9298'
    When I enter 'Notifications Settings' page
    Then I am on 'Notifications' page

  @C17165
  Scenario: Notifications Settings screen GUI
    Then I see following labels on page:
      | Related to you                                                                                             |
      | Personal reminders                                                                                         |
      | Notifications to help you stay on track and achieve your health goals                                      |
      | Weekly summary                                                                                             |
      | One email every week with a summary of your progress                                                       |
      | Comments and likes                                                                                         |
      | Notification whenever you get a follow request or when someone comments or likes something you have shared |
      | New user tutorial                                                                                          |
      | A series of emails to help you get the most out of using the app                                           |
      | Tips and updates                                                                                           |
      | Occasional emails with tips, advices, product updates and feature announcements                            |
    And all the notifications flags may be switched
