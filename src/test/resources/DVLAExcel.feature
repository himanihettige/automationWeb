Feature:
  @DVLAExcel
  Scenario: Read data from Excel file Dvla
    When I click start now Button
    Then I should see url "https://www.vehicleenquiry.service.gov.uk/"
    Given I enter register number of the vehicle from reading excel file "DVLAExcel.xlsx"
    When I click continue button
    Then I should see url "https://vehicleenquiry.service.gov.uk/ConfirmVehicle"
    And I should reading excel file Reg no as "BC04 RWZ"
   And I should reading excel file Reg no as "FORD"
   # And I should reading excel file Reg no as " SILVER"
    And I click No, search again check button
    When I click continue
    Then I should see url "https://vehicleenquiry.service.gov.uk/ViewVehicle"
    Given I enter register number of the vehicle from reading excel file "DVLAExcel.xlsx"