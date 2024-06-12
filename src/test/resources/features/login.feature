Feature: Login feature

  Scenario Outline: Login with correct input scenario
    Given I am a registered user
    When I try to login with "<username>" "<password>"
    Then I see the logout "<buttonText>"

    Examples:
      | username     | password | buttonText |
      | automation11 | 1234     | Logout     |
      | automation12 | 1234     | Logout     |
      | automation13 | 1234     | Logout     |