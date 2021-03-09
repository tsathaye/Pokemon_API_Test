package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;

public class getBerrySteps {

    ValidatableResponse res;

    @Given("^we have called the Pokemon API$")
    public void weHaveCalledThePokemonAPI() {

        res = given()
                .when()
                .get("https://pokeapi.co/api/v2/berry/5")
                .then();
    }

    @Then("^I should get a response (\\d+)$")
    public void iShouldGetAResponse(int statusCode) {

        Assert.assertEquals(res.extract().statusCode(),statusCode,"Status Code as Expected - "+res.extract().statusCode());
    }
}
