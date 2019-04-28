@regression
Feature:contactus
 #+ve
  @smoke
  Scenario: contact us with vaild details 1
    When I click contact us Link on Home Page
    Given I selected Subject Heading as "Customer Service"
    Given I enter valid Email address as "worktrance@outlook.com"
    Given I enter valid Order Reference as "12345"
    Given I choose a File
    Given I entered message as "Customer Inquiry for Order Ref.12345"
    When I click Send Button
    Then I should see url "http://automationpractice.com/index.php?controller=contact"
    Then I should see message "Your message has been successfully sent to our team."
#+ve
  Scenario: contact us with vaild details 2
    When I click contact us Link on Home Page
    Given I selected Subject Heading as "Webmaster"
    Given I enter valid Email address as "worktrance@outlook.com"
    Given I enter valid Order Reference as "12345"
    Given I choose a File
    Given I entered message as "Customer Inquiry for Order Ref.12345"
    When I click Send Button
    Then I should see url "http://automationpractice.com/index.php?controller=contact"
    Then I should see message "Your message has been successfully sent to our team."

 #+ve
  Scenario: contact us with vaild details 3
    When I click contact us Link on Home Page
    Given I selected Subject Heading as "Customer Service"
    Given I enter valid Email address as "worktrance@outlook.com"
    Given I enter valid Order Reference as ""
    Given I choose a File
    Given I entered message as "Customer Inquiry for Order Ref.PC6345"
    When I click Send Button
    Then I should see url "http://automationpractice.com/index.php?controller=contact"
    Then I should see message "Your message has been successfully sent to our team."

 #+ve
  Scenario: contact us with vaild details 4
    When I click contact us Link on Home Page
    Given I selected Subject Heading as "Customer Service"
    Given I enter valid Email address as "worktrance@outlook.com"
    Given I enter valid Order Reference as "S%£&123"
    Given I choose a File
    Given I entered message as "Customer Inquiry for Order Ref.S%£&123"
    When I click Send Button
    Then I should see url "http://automationpractice.com/index.php?controller=contact"
    Then I should see message "Your message has been successfully sent to our team."

#+ve
  Scenario: contact us with vaild details with empty order reference and file
    When I click contact us Link on Home Page
    Given I selected Subject Heading as "Customer Service"
    Given I enter valid Email address as "worktrance@outlook.com"
    Given I enter valid Order Reference as ""
    Given I keep choose a File without file
    Given I entered message as "Customer Inquiry for Order Ref.S%£&123"
    When I click Send Button
    Then I should see url "http://automationpractice.com/index.php?controller=contact"
    Then I should see message "Your message has been successfully sent to our team."

#-ve
  @smoke
  Scenario: contact us with invaild email details
    When I click contact us Link on Home Page
    Given I selected Subject Heading as "Customer Service"
    Given I enter valid Email address as "test.com"
    Given I enter valid Order Reference as "12345"
    Given I choose a File
    Given I entered message as "Customer Inquiry for Order Ref.12345"
    When I click Send Button
    Then I should see err_message "There is 1 error"
    Then I should see err_msg "Invalid email address."
#-ve
  @smoke
  Scenario: contact us with empty email
    When I click contact us Link on Home Page
    Given I selected Subject Heading as "Customer Service"
    Given I enter valid Email address as ""
    Given I enter valid Order Reference as "12345"
    Given I choose a File
    Given I entered message as "Customer Inquiry for Order Ref.12345"
    When I click Send Button
    Then I should see err_message "There is 1 error"
    Then I should see err_msg "Invalid email address."

 #-ve
  Scenario: contact us with Subject Heading with Choose
    When I click contact us Link on Home Page
    Given I selected Subject Heading as "-- Choose --"
    Given I enter valid Email address as "worktrance@outlook.com"
    Given I enter valid Order Reference as "1234"
    Given I choose a File
    Given I entered message as "Customer Inquiry for Order Ref.12345"
    When I click Send Button
    Then I should see err_message "There is 1 error"
    Then I should see err_msg "Please select a subject from the list provided."

#-ve
  @smoke
  Scenario: contact us with blank message
    When I click contact us Link on Home Page
    Given I selected Subject Heading as "Customer Service"
    Given I enter valid Email address as "worktrance@outlook.com"
    Given I enter valid Order Reference as "1234"
    Given I choose a File
    Given I entered message as ""
    When I click Send Button
    Then I should see err_message "There is 1 error"
    Then I should see err_msg "The message cannot be blank."
