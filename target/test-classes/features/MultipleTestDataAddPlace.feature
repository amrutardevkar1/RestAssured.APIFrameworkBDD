Feature: Multiple TestData AddPlace APi Test
  
  Scenario Outline: Validate user is able to addPlace with multiple testdata
    Given User creates request wity baseUri and attach payload with "<name>", "<address>", "<language>"
    When User hits addPlce resource with PUT http request
    Then User gets response status code as 200
    And User gets "status" in response body equals to "OK"
    And Verify place created with "<name>"
    
    Examples: 
      | name  | address                  | language  |
      | Amu   | 101, MG Street,Pune      | English   |
      | Gau   | 102, Ring Street, Mumbai | Marathi   |
