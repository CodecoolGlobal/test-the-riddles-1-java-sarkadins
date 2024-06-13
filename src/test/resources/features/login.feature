Feature: Login feature

  Scenario Outline: Login with correct input scenario
    Given I am a registered user
    And I am on the login page
    When I try to login with "<username>" "<password>"
    Then I see the logout button

    Examples:
      | username     | password | 
      | automation11 | 1234     | 
      | automation12 | 1234     | 
      | automation13 | 1234     | 

  Scenario Outline: Unsuccessful login
    Given I am on the login page
    When I try to login with "<username>" "<password>"
    Then I see an error message about the unsuccessful login
  
  Examples:
      | username     | password | 
      |              |          | 
      | nonexistent  | 1234     | 
      | test         |          |
