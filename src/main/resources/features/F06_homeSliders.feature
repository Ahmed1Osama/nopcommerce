@smoke
Feature: F06_Home Slider | users could slide between two slider (Nokia1020 and Iphone) successfully
  Scenario: first slider is Nokia1020 on home page
    Given first slider is clickable on home page
    Then user should navigate to clickable URL "Nokia1020"

  Scenario: second slider is Iphone on home page
    Given  second slider is clickable on home page
    Then   user should navigate to clickable URL "Iphone"

