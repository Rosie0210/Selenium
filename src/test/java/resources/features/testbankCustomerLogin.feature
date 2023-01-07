Feature: Customer Login

  Scenario: Login with valid data( Login successfully)
    Given user is on customer login page
    And verify login page
    When user click on Customer Login button
    When user select on your name
    And user click on login button
    Then message will be display

  Scenario Outline: Customer deposit successfully with valid data
    Given  Login successfully
    When   click on 'Deposit' button
    And    input amount as "<amount>"
    Then   click on 'Deposit' button to deposit
    Then   the <message> will be display
    Examples:
      | amount | message              |
      | 100    | Deposit successfully |


  Scenario Outline: Customer deposit unsuccessfully with invalid data
    Given  Login successfully
    When click on 'Deposit' button
    And input amount as "<amount>"
    Then click on 'Deposit' button to deposit
    Then the <message> will be display
    Examples:
      | amount   | message                                                |
      | -100     | OK (Invalid data[-100], Amount must be greater than 0) |
      | 0        | Ok (Invalid data[0], Amount must be greater than 0)    |
      | mot tram | Ok (Invalid data[mot tran], Amount must be number)     |
      | @#$!     | Ok (Invalid data[@#$!], Amount must be number)         |
      |          | Ok (Invalid data[Blank], Enter your amount)            |


#  Scenario: Customer made deposit with invalid data
#    Given Login successfully
#    When click on 'Deposit' button
#    Then click on 'Deposit' button to deposit
#    Then message will be display

  Scenario: Verify that Customer can successfully operate on Transaction
    Given  Login successfully
    When click on 'Transaction' button
    Then click on 'Reset' button
    When click on 'Back' button
    Then message will be display

  Scenario: User can withdraw successfully
    Given  Login successfully
    When click on 'Withdraw' button
    And enter the amount you want to withdraw
    Then click on 'Withdraw' button to submit
    Then message will be display


  Scenario Outline: User cannot withdraw successfully with invalid data
    Given  Login successfully
    When click on 'Withdraw' button
    Then enter amount as "<amount>"
    Then click on 'Withdraw' button to submit
    Then the <message> will be display
    Examples:
      | amount   | message                                                           |
      |          | OK (Amount = blank, Enter your amount   )                         |
      | 0        | OK (Amount = 0, Amount must be greater than 0  )                  |
      | -1       | OK (Amount = 0, Amount must be greater than 0     )               |
      | 99000000 | OK (Amount = 99000000, Amount must be less than or equal balance) |
      | nam tram | OK (Amount = nam tram, Amount must be number        )             |

  Scenario: User can logout successfully
    Given  Login successfully
    When click on 'Logout' button
    Then message will be display