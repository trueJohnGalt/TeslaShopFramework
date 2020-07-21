Feature: Best Sellers Carousel

  Scenario: User clicks on arrow in Best Sellers Carousel
    Given Best Sellers Carousel is displayed on Home Page
    When Guest clicks on next arrow in Best Sellers Carousel
    Then new products are displayed in Best Sellers Carousel
    When Guest clicks on previous arrow in Best Sellers Carousel
    Then initial products are displayed in Best Sellers Carousel