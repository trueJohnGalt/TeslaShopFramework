Feature: Search

  Scenario Outline: User performs search with valid query via header
    When Guest searches <query> via header
    Then <query> is displayed on search result page
    And each product contains <query> in product name

    Examples:
      | query  |
      | hoodie |

    Scenario Outline: User performs search with invalid query via header
      When Guest searches <query> via header
      Then <query> is displayed on search result page
      And <errorType> search error message is displayed

    Examples:
      | query   | errorType            |
      | invalid | no results found     |
      | ab      | enter more characters|

