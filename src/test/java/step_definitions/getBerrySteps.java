package step_definitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import java.util.List;
import static io.restassured.RestAssured.given;

public class getBerrySteps {

    ValidatableResponse res;

    @Given("^we have called the Pokemon API$")
    public void weHaveCalledThePokemonAPI() {

        res = given()
                .spec(Hooks.reqspec)
                .when()
                .get("5")
                .then();


    }

    @Then("^I get a response (\\d+)$")
    public void iGetAResponse(int statusCode) {
        Assert.assertEquals(res.extract().statusCode(),statusCode,"Status Code as Expected - ");
    }

    @Given("^we have called the Pokemon API for berryNumber \"([^\"]*)\"$")
    public void weHaveCalledThePokemonAPIForBerryNumber(String berryNumber) {
        res = given()
                .spec(Hooks.reqspec)
                .when()
                .get(berryNumber)
                .then();
    }

    @Then("^response should have \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void responseShouldHaveAnd(String id, String name, int size)  {
        if (res.extract().statusCode() != 200) {
            Assert.assertTrue(true); // Pass the step for non existing berries
        }
        else {
            Assert.assertEquals(id,res.extract().jsonPath().getString("id"),"Berry Id is as expected");
            Assert.assertEquals(size,res.extract().jsonPath().getInt("size"),"Size as expected");
            Assert.assertEquals(name,res.extract().jsonPath().getString("item.name"),"Berry name as expected");
        }
    }

    @Given("^we have called the Pokemon Berry API to validate the JSON Schema$")
    public void weHaveCalledThePokemonBerryAPIToValidateTheJSONSchema() {

         res =    given()
                     .spec(Hooks.reqspec)
                     .when()
                     .get()
                     .then();

    }

    @Then("^I should be able to validate schema on all berries$")
    public void iShouldBeAbleToValidateSchemaOnAllBerries() {


        List<String> berry = res.extract().jsonPath().getList("results.url");
        System.out.println("Verify the API call & Response schema for "+berry.size()+" berries");

        for (String url : berry){
            System.out.println(url);
            given()
                    .get(url)
                    .then()
                    .assertThat()
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("berrySchema.json"))
                    .statusCode(HttpStatus.SC_OK).log().ifError();
        }
    }


}
