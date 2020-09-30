Feature: Product details page

  Scenario: User adds product to cart without selected size
    Given Guest opens 2 product from Best Sellers Carousel
    When Guest adds product to cart
    Then size not selected error is displayed

  Scenario: User adds product to cart with selected size
    Given Guest opens 3 product from Best Sellers Carousel
    And Guest selects S size of product
    When Guest adds product to cart
    Then cart is opened
