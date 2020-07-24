Feature: Basket

  Scenario: User opens empty cart
    When Guest opens cart from header
    Then cart is empty