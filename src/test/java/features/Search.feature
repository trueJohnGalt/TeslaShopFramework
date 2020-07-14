Feature: Search

  Scenario Outline: Guest searches product from header
    When Guest searches <query> from header
    Then <query> is displayed on search result page

    Examples:
    | query  |
    | hoodie |

  Scenario Outline: Guest searches product from header
    When Guest searches <query> from header
    Then each product contains <query> in product name

    Examples:
      | query      |
      | sweatshirt |
