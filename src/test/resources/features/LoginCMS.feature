Feature: Login CMS


  Background:
    Given I login in CMS
    And I open Create User Page

   Scenario Outline: Verify Create User Validation
    When I fill in Username field with "<username>" value
     And I click Save
    Then Validation message "<validation message>" appears

Examples:
   |username|validation message|
   |        |Username is required.|
   |clerk1  |The User Name you have entered already exists!|




