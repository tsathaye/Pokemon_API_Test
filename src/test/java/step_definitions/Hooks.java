package step_definitions;

import cucumber.api.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Hooks {

    public static RequestSpecBuilder builder;
    public static RequestSpecification reqspec;


    @Before("@Test")
    /*
     Setup REST-Assured to work with the P&B API using ReqSpecBuilder
     */
    public RequestSpecification setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        builder = new RequestSpecBuilder();
        builder.setBaseUri ("https://pokeapi.co/api/v2/berrvy/");
        reqspec =  builder.build();
        return reqspec;
    }

}
