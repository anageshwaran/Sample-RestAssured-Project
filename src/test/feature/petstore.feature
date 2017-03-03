Feature: Update the pet details

  Background: User calls the petstore base url
    Given The petstore url http://petstore.swagger.io/

  Scenario Outline: User calls web service to update a pet details
    Given Add a new pet to the store <requestUrl>
    Then Verify the pet added to the store
    When Update the name of the pet in the store <requestUrl>
    Then Verify the pet name updated successfully

    Examples: 
      | requestUrl |
      | v2/pet    |
