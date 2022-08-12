@smoke
Feature: F04_Search | users could use search functionality for product successfully

  Scenario Outline: user could search using product name
    Given user enter search "<ProName>" and get search result
    When user get search result on valid page
    Then each result contains the search word"<ProName>"
    Examples:
      | ProName |
      | book    |
      | laptop  |
      | nike    |

  Scenario Outline: user could search using product name using sku
    Given user enter search "<sku>" and get search result
    When user click on the product in search result
    Then each result contains the search word"<sku>"
    Examples:
      | sku      |
      | SCI_FAITH|
      | APPLE_CAM|
      | SF_PRO_11|