Feature: Header

  Scenario: User clicks on Tesla logo in header
    When Guest clicks on Tesla logo in header
    Then url contains www.tesla.com

  Scenario: User clicks on Shop logo in header
    When Guest clicks on Shop logo in header
    Then url contains shop.tesla.com

  Scenario: User clicks on category in header
    When Guest clicks on charging category in header
    Then title on category page is charging

  Scenario: User clicks on subcategory in header
    When Guest opens Model X subcategory of Vehicle Accessories category in header
    Then title on category page is Model X

  Scenario: User clicks on sign in button in header
    When Guest clicks on Sign In button in header
    Then url contains /login

  Scenario: User clicks Search Loop in header
    When Guest clicks on Search Loop in header
    Then search input field is visible

  Scenario: User opens empty cart
    When Guest opens cart from header
    Then cart is empty