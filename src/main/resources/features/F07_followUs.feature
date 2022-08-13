@smoke
  Feature: F07_followUs Feature | user could subscribe social media
    Scenario: user opens facebook link
      Given user can opens "facebook" link
      When user can see new tab
      And user can switch between two tabs
      Then "https://www.facebook.com/nopCommerce" is opened in new tab

      Scenario: user opens twitter link
        Given user can opens "twitter" link
        When user can see new tab
        And user can switch between two tabs
        Then "https://twitter.com/nopCommerce" is opened in new tab


      Scenario: user opens rss link
        Given user can opens "rss" link
        When user can see new tab
        And user can switch between two tabs
        Then "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab

      Scenario: user opens youtube link
        Given user can opens "youtube" link
        When user can see new tab
        And user can switch between two tabs
        Then "https://www.youtube.com/user/nopCommerce" is opened in new tab


