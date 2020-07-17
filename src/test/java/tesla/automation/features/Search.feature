Feature: Search

  Scenario Outline: Search query is displayed at the top of page
    When Guest searches <query> from header
    Then <query> is displayed on search result page

    Examples:
    | query  |
    | hoodie |

  Scenario Outline: Each search result contains query in name
    When Guest searches <query> from header
    Then each product contains <query> in product name

    Examples:
      | query      |
      | sweatshirt |
