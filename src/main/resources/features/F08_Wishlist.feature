@smoke
  Feature: F08_wishlist | user can add product to his list
    Scenario: user add product on wishlist
      Given user click on the wishlist icon
      Then user can get successfully message


      Scenario: user open  wishlist
        Given user click on the wishlist icon
        When  success message disappear go to wishlist
        Then  get Qty value more than 0




