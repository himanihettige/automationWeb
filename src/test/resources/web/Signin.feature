@reg
Feature:Signin

 #+ve
  @smoke
  Scenario Outline: sign in with vaild details 2
    When I click Sign in Link on Home Page
    Then I should see url "http://automationpractice.com/index.php?controller=authentication&back=my-account"
    Given I enter valid Email as "<email>"
    When I click Create an account Button
    Then I should see account creation url as "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation"
    Given I enter Title as "<Title>"
    And I enter First Name as "<firstName>"
    And I enter Last Name as "<lastName>"
    And I enter password as "<password>"
    And I enter DOB day as "<day>"
    And I enter DOB month as "<month>"
    And I enter DOB year as "<year>"
    And I click sign up for newsletter
    And I click I receive special offers from our partners
    And I enter Company as "<company>"
    And I enter address as "<address1>"
    And I enter adresss line Two as "<address2>"
    And I enter city as "<city>"
    And I selected State as "<state>"
    And I enter Zip/Postal code as "<zipcode>"
    And I selected Country as "<country>"
    And I enter Additional information as "<AddInfo>"
    And I enter Home phone as "<homePhone>"
    And I enter Mobile phone as "<mobilePhone>"
    And I enter Assign an address alias for future reference "<myAddress>"
    When I click Register Button
    Then I should see my account page as "http://automationpractice.com/index.php?controller=my-account"


    Examples:
      | email                  | Title | firstName | lastName | password | day | month     | year | company       | address1 | address2        | city          | state      | zipcode | country       | AddInfo                 | homePhone   | mobilePhone | myAddress         |
      | worktrance@outlook.com | Mr    | Mac       | David    | Mac1234  | 20  | January   | 1985 | Austin Fraser | 6        | Deer Rock Hill  | Los Angeles   | Califonia  | 90001   | United States | This is a test AddInfo1 | 01341134546 | 0749988776  | 6,DeerRock        |
      | worktrance@outlook.com | Mrs   | Henna     | Hught    | Henna23  | 15  | July      | 1987 | JDA Software  | 54       | Rectory Close   | Trenton       | New Jersey | 08604   | United States | This is a test AddInfo2 | 163877788   | 0783243253  | 54,Rectory close  |
      | worktrance@outlook.com | Mr    | chalie    | Maxi     | Maxi1234 | 5   | September | 1990 | Abans Ltd     | 7        | Wellington Road | New York City | New York   | 10009   | United States | This is a test AddInfo3 | 646 7657050 | 0749988777  | 7,Wellington Road |

#-ve
  Scenario Outline: sign in with invaild details
    When I click Sign in Link on Home Page
    Then I should see url "http://automationpractice.com/index.php?controller=authentication&back=my-account"
    Given I enter invalid Email as "<email>"
    When I click Create an account Button
    Then I should see error message as "Invalid email address."

    Examples:
      | email         |
      | test.com      |
      |               |
      | 123££55%%@com |
      | @hotmail.com  |

#-ve
  Scenario Outline: Sign in with existing email address
    When I click Sign in Link on Home Page
    Then I should see url "http://automationpractice.com/index.php?controller=authentication&back=my-account"
    Given I enter Existing Email as "<email>"
    When I click Create an account Button
    Then I should see error message as "An account using this email address has already been registered. Please enter a valid password or request a new one."

    Examples:
      | email          |
      | abc@yahoo.com  |
      | test@gmail.com |

#-ve
  Scenario Outline: sign in with invaild details 2
    When I click Sign in Link on Home Page
    Then I should see url "http://automationpractice.com/index.php?controller=authentication&back=my-account"
    Given I enter valid Email as "<email>"
    When I click Create an account Button
    Then I should see account creation url as "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation"
    Given I enter Title as "<Title>"
    And I enter First Name as "<firstName>"
    And I enter Last Name as "<lastName>"
    And I enter password as "<password>"
    And I enter DOB day as "<day>"
    And I enter DOB month as "<month>"
    And I enter DOB year as "<year>"
    And I click sign up for newsletter
    And I click I receive special offers from our partners
    And I enter Company as "<company>"
    And I enter address as "<address1>"
    And I enter adresss line Two as "<address2>"
    And I enter city as "<city>"
    And I selected State as "<state>"
    And I enter Zip/Postal code as "<zipcode>"
    And I selected Country as "<country>"
    And I enter Additional information as "<AddInfo>"
    And I enter Home phone as "<homePhone>"
    And I enter Mobile phone as "<mobilePhone>"
    And I enter Assign an address alias for future reference "<myAddress>"
    When I click Register Button
    Then I should see signin page first error message as "<message1>"
    And I should see signin page Second error message as "<message2>"


    Examples:
      | email                  | Title | firstName  | lastName    | password | day | month     | year | company       | address1 | address2        | city          | state      | zipcode | country       | AddInfo                 | homePhone   | mobilePhone | myAddress         | message1         | message2                                                                         |
      | worktrance@outlook.com | Mr    | Mac£@@£$£@ | David       | Mac1234  | 20  | January   | 1985 | Austin Fraser | 6        | Deer Rock Hill  | Los Angeles   | Califonia  | 90001   | United States | This is a test AddInfo1 | 01341134546 | 0749988776  | 6,DeerRock        | There is 1 error | firstname is invalid.                                                            |
      | worktrance@outlook.com | Mr    |            | David       | Mac1234  | 20  | January   | 1985 | Austin Fraser | 6        | Deer Rock Hill  | Los Angeles   | Califonia  | 90001   | United States | This is a test AddInfo1 | 01341134546 | 0749988776  | 6,DeerRock        | There is 1 error | firstname is required.                                                           |
      | worktrance@outlook.com | Mrs   | Henna      | Hught£@%£%£ | Henna23  | 15  | July      | 1987 | JDA Software  | 54       | Rectory Close   | Trenton       | New Jersey | 08604   | United States | This is a test AddInfo2 | 163877788   | 0783243253  | 54,Rectory close  | There is 1 error | lastname is invalid.                                                             |
      | worktrance@outlook.com | Mr    | chalie     |             | Maxi1234 | 5   | September | 1990 | Abans Ltd     | 7        | Wellington Road | New York City | New York   | 10009   | United States | This is a test AddInfo3 | 646 7657050 | 0749988777  | 7,Wellington Road | There is 1 error | lastname is required.                                                            |
      | worktrance@outlook.com | Mrs   | Henna      | Hught       | He23     | 15  | July      | 1987 | JDA Software  | 54       | Rectory Close   | Trenton       | New Jersey | 08604   | United States | This is a test AddInfo2 | 163877788   | 0783243253  | 54,Rectory close  | There is 1 error | passwd is invalid.                                                               |
      | worktrance@outlook.com | Mrs   | Henna      | Hught       | He2312   |     | July      | 1987 | JDA Software  | 54       | Rectory Close   | Trenton       | New Jersey | 08604   | United States | This is a test AddInfo2 | 163877788   | 0783243253  | 54,Rectory close  | There is 1 error | Invalid date of birth                                                            |
      | worktrance@outlook.com | Mrs   | Henna      | Hught       | He2312   | 15  |           | 1987 | JDA Software  | 54       | Rectory Close   | Trenton       | New Jersey | 08604   | United States | This is a test AddInfo2 | 163877788   | 0783243253  | 54,Rectory close  | There is 1 error | Invalid date of birth                                                            |
      | worktrance@outlook.com | Mrs   | Henna      | Hught       | He2312   | 15  | July      |      | JDA Software  | 54       | Rectory Close   | Trenton       | New Jersey | 08604   | United States | This is a test AddInfo2 | 163877788   | 0783243253  | 54,Rectory close  | There is 1 error | Invalid date of birth                                                            |
      | worktrance@outlook.com | Mrs   | Henna      | Hught       |          | 15  | July      | 1987 | JDA Software  | 54       | Rectory Close   | Trenton       | New Jersey | 08604   | United States | This is a test AddInfo2 | 163877788   | 0783243253  | 54,Rectory close  | There is 1 error | passwd is required.                                                              |
      | worktrance@outlook.com | Mr    | chalie     | Maxi        | Maxi1234 | 5   | September | 1990 | Abans Ltd     |          | Wellington Road | New York City | New York   | 10009   | United States | This is a test AddInfo3 | 646 7657050 | 0749988777  | 7,Wellington Road | There is 1 error | address1 is required.                                                            |
      | worktrance@outlook.com | Mr    | Mac        | David       | Mac1234  | 20  | January   | 1985 | Austin Fraser | 6        | Deer Rock Hill  |               | Califonia  | 90001   | United States | This is a test AddInfo1 | 01341134546 | 0749988776  | 6,DeerRock        | There is 1 error | city is required.                                                                |
      | worktrance@outlook.com | Mrs   | Henna      | Hught       | Henna23  | 15  | July      | 1987 | JDA Software  | 54       | Rectory Close   | Trenton       |            | 08604   | United States | This is a test AddInfo2 | 163877788   | 0783243253  | 54,Rectory close  | There is 1 error | This country requires you to choose a State.                                     |
      | worktrance@outlook.com | Mr    | chalie     | Maxi        | Maxi1234 | 5   | September | 1990 | Abans Ltd     | 7        | Wellington Road | New York City | New York   |         | United States | This is a test AddInfo3 | 646 7657050 | 0749988777  | 7,Wellington Road | There is 1 error | The Zip/Postal code you've entered is invalid. It must follow this format: 00000 |
      | worktrance@outlook.com | Mrs   | Henna      | Hught       | Henna23  | 15  | July      | 1987 | JDA Software  | 54       | Rectory Close   | Trenton       | New Jersey | 08604   | United States | This is a test AddInfo2 | 163877788   |             | 54,Rectory close  | There is 1 error | mobilephone is required.                                                         |
      | worktrance@outlook.com | Mr    | chalie     | Maxi        | Maxi1234 | 5   | September | 1990 | Abans Ltd     | 7        | Wellington Road | New York City | New York   | 10009   | United States | This is a test AddInfo3 | 646 7657050 | 0749988777  |                   | There is 1 error | alias is required.                                                               |

    #-ve
  Scenario Outline: check sign in with required fields
    When I click Sign in Link on Home Page
    Then I should see url "http://automationpractice.com/index.php?controller=authentication&back=my-account"
    Given I enter valid Email as "<email>"
    When I click Create an account Button
    Then I should see account creation url as "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation"
    Given I enter Title as "<Title>"
    And I enter First Name as "<firstName>"
    And I enter Last Name as "<lastName>"
    And I enter password as "<password>"
    And I enter DOB day as "<day>"
    And I enter DOB month as "<month>"
    And I enter DOB year as "<year>"
    And I click sign up for newsletter
    And I click I receive special offers from our partners
    And I enter Company as "<company>"
    And I enter address as "<address1>"
    And I enter adresss line Two as "<address2>"
    And I enter city as "<city>"
    And I selected State as "<state>"
    And I enter Zip/Postal code as "<zipcode>"
    And I selected Country as "<country>"
    And I enter Additional information as "<AddInfo>"
    And I enter Home phone as "<homePhone>"
    And I enter Mobile phone as "<mobilePhone>"
    And I enter Assign an address alias for future reference "<myAddress>"
    When I click Register Button
    Then I should see signin page first error message as "<message1>"
    And I should see signin page Sec error message as "<message2>"
    And I should see signin page Third error message as "<message3>"
    And I should see signin page fourth error message as "<message4>"
    And I should see signin page fifth error message as "<message5>"
    And I should see signin page sixth error message as "<message6>"
    And I should see signin page Seventh error message as "<message7>"
    And I should see signin page Eighth error message as "<message8>"
    And I should see signin page nighth error message as "<message9>"

    Examples:
      | email                  | Title | firstName | lastName | password | day | month     | year | company        | address1 | address2        | city          | state     | zipcode | country       | AddInfo                 | homePhone   | mobilePhone | myAddress         | message1           | message2               | message3              | message4            | message5              | message6          | message7                                     | message8                                                                         | message9           |
      | worktrance@outlook.com | Mr    |           |          |          | 20  | January   | 1985 | Austin Fraser  |          | Deer Rock Hill  |               |           |         | United States | This is a test AddInfo1 | 01341134546 | 0749988777  |                   | There are 8 errors | firstname is required. | lastname is required. | passwd is required. | address1 is required. | city is required. | This country requires you to choose a State. | The Zip/Postal code you've entered is invalid. It must follow this format: 00000 | alias is required. |
      | worktrance@outlook.com | Mrs   |           | Kathy    | kathy12  | 25  | March     | 1989 | Austin Fraser1 |          | Deer Rock Hill  | Los Angeles   | Califonia |         | United States | This is a test AddInfo1 | 01341134546 | 0749988777  |                   | There are 4 errors | firstname is required. |                       |                     | address1 is required. |                   |                                              | The Zip/Postal code you've entered is invalid. It must follow this format: 00000 | alias is required. |
      | worktrance@outlook.com | Mrs   | Nayana    |          | Nay123   | 5   | September | 1990 | Abans Ltd      | 7        | Wellington Road |               | New York  | 10009   | United States | This is a test AddInfo1 | 01341134546 | 0749988777  | 7,Wellington Road | There are 2 errors |                        | lastname is required. |                     |                       | city is required. |                                              |                                                                                  |                    |
      | worktrance@outlook.com | Mr    |           |          | nik123%  | 28  | January   | 1985 | Austin Ltd     |          | Deer Rock Hill  | New York City |           | 10009   | United States | This is a test AddInfo1 | 01341134546 | 0749988777  |                   | There are 5 errors | firstname is required. | lastname is required. |                     | address1 is required. |                   | This country requires you to choose a State. |                                                                                  | alias is required. |
      | worktrance@outlook.com | Mr    | Abc       | Yan      |          | 30  | August    | 1983 | Fraser Ltd     | 56       | Deer Rock Hill  |               |           |         | United States | This is a test AddInfo1 | 01341134546 | 0749988777  |                   | There are 5 errors |                        |                       | passwd is required. |                       | city is required. | This country requires you to choose a State. | The Zip/Postal code you've entered is invalid. It must follow this format: 00000 | alias is required. |
