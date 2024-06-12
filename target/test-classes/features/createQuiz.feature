Feature: Create quiz feature

  Scenario Outline: Create Quiz with first answer is correct
    Given I am logged in as quiz master
    When I create a quiz with "<quizTitle>" "<questionTitle>" "<answer1>" "<answer2>"
    Then I see the "<quizTitle>"

    Examples:
      | quizTitle | questionTitle | answer1  | answer2   |
      | testQuiz  | testQuestion  | firstAns | secondAns |
