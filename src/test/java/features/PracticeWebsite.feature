Feature: Complete the Tasks of practice automation page

  @dockRun
  Scenario: To perform the tasks in section one

    Given User is landed in Automation practice web application
    When User selects "Radio3" radio button
    And User searches country with first three char of "India" and selects county from suggestion
    And User selects "option2" in dropdown example
    And User clicks "Option3" in checkbox example
    Then User verifies all the selected details in screen

  Scenario: To perform the tasks in section two

    Given User is landed in Automation practice web application
    When User clicks "OpenWindow" button and switch to new window

