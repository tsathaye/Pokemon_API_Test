Feature: Get Berry : Verify that you can access the Pokemon Berry API

  @Test
  Scenario: Check that Pokemon berry API returns 200 Ok Response
    Given we have called the Pokemon API
    Then I get a response 200

  @Test
  Scenario: Check that Pokemon berry API returns 404 Not found Response for unavailable berry
    Given we have called the Pokemon API for berryNumber "999"
    Then I get a response 404

  @Test
  Scenario Outline: Check that Pokemon berry API returns response with data associated to berry
    Given we have called the Pokemon API for berryNumber "<berry>"
    When I get a response <statusCode>
    Then response should have "<berry>", "<name>" and "<size>"
    Examples:
      | berry | statusCode| name           | size |
      | 5     | 200       | aspear-berry   | 50   |
      | 11    | 200       | figy-berry     | 100  |
      | 16    | 200       | razz-berry     | 120  |
      | aa    | 404       | non            | 0    |
      | 9999  | 404       | non            | 0    |

  #This is an exhaustive Automated Test
  @Test
  Scenario: Check the JSON Schema Validation of  Pokemon berry API response
    Given we have called the Pokemon Berry API to validate the JSON Schema
    Then I should be able to validate schema on all berries