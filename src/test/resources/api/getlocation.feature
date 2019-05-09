Feature:

  @getapitesting
  Scenario:
    When I trigger Get Request with "empty" headers city "Bracknell"
    Then I should see Response code as 200
    Then i should see Response code as "OK"
    Then I should see Response body as "$.suggestions[0].name" is "Bracknell"
    Then I should get Response body as "$.suggestions[0].location.latitude" is "51.41558"


  @postapitesting
  Scenario:
    When I trigger post request with "testJSON.json" as postbody
    Then I should see Response code as 201
    Then i should see Response code as "Created"
   #Then I should see Response body like "$.id" is "683"







































