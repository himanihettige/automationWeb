@regression1
Feature:contactUsDT
#  Scenario Outline:
#    When I click contact us Link on Home Page
#    Then I should see below details:
#      | SubjectHeading   | EmailAddress   | OrderRef   | Message   |
#      | <SubjectHeading> | <EmailAddress> | <OrderRef> | <Message> |
#    Given I choose a File
#    When I click Send Button
#    Then I should see url "http://automationpractice.com/index.php?controller=contact"
#    Then I should see message "Your message has been successfully sent to our team."
#    Examples:
#      | SubjectHeading   | EmailAddress           | OrderRef | Message                                |
#      | Customer Service | worktrance@outlook.com | 12345    | Customer Inquiry for Order Ref.12345   |
#      | Webmaster        | worktrance@outlook.com | 12345    | Customer Inquiry for Order Ref.12345   |
#      | Customer Service | worktrance@outlook.com |          | Customer Inquiry for Order Ref.PC6345  |
#      | Customer Service | worktrance@outlook.com | S%£&123  | Customer Inquiry for Order Ref.S%£&123 |
#

  Scenario Outline:
    When I click contact us Link on Home Page
    Then I should see below details:
      | SubjectHeading   | EmailAddress   | OrderRef   | Message   |
      | <SubjectHeading> | <EmailAddress> | <OrderRef> | <Message> |

    Given I choose a File
    When I click Send Button
    Then I should see errormessage as "<Err_msg>"
#      | There is 1 error Invalid email address.                          |
#      | There is 1 error Invalid email address.                          |
#      | There is 1 error Please select a subject from the list provided. |
#      | There is 1 error The message cannot be blank.                    |

    Examples:
      | SubjectHeading   | EmailAddress           | OrderRef | Message                              | Err_msg                                                          |
      | Customer Service | test.com               | 12345    | Customer Inquiry for Order Ref.12345 | There is 1 error Invalid email address.                          |
      | Customer Service |                        | 12346    | Customer Inquiry for Order Ref.12346 | There is 1 error Invalid email address.                          |
      | -- Choose --     | worktrance@outlook.com | 12347    | Customer Inquiry for Order Ref.12347 | There is 1 error Please select a subject from the list provided. |
      | Customer Service | worktrance@outlook.com | 12348    |                                      | There is 1 error The message cannot be blank.                    |


