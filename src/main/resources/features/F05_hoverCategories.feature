@smoke
Feature: F05_HoverCategory | users could over categories main menu and select one of submenu successfully
  Scenario: user hover on one of main categories then click on sub category
    Given user hover on one of the main categories
    When user could view sub category if exist
    Then user can select sub category or open main category
