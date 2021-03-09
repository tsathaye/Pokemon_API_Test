Feature: Get Berry : Verify that you can access the Pokeman Berry API

  @Test
  Scenario: Check that Pokemon berry API is available
    Given we have called the Pokemon API
    Then I should get a response 200