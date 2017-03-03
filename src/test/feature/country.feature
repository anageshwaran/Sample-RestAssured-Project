Feature: Search for the country and verify the details of the country

  Background: User calls the country base url
    Given The country base url http://restcountries.eu/

  Scenario Outline: User calls web service to get a country details
    Given Search for the country <requestUrl>
    Then Verify the capital of the country

    Examples: 
      | requestUrl |
      | rest/v1   |
