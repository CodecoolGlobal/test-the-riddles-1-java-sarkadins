Feature: Delete quiz feature

  Scenario Outline: Delete a previously created quiz
    Given I am logged in as quiz master and i create a new quiz with "<quizTitle>" "<questionTitle>" "<answer1>" "<answer2>"
    When I try to delete it
    Then I should see an empty quiz page "<message>"

    Examples:
      | quizTitle | questionTitle | answer1  | answer2   | message           |
      | testQuiz  | testQuestion  | firstAns | secondAns | No quizzes found. |
