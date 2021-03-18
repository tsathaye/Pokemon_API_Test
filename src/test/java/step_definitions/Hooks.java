package step_definitions;

import cucumber.api.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class Hooks {

    public static RequestSpecBuilder builder;
    public static RequestSpecification reqspec;


    @Before("@Test")

    public RequestSpecification setup() {
        enableLoggingOfRequestAndResponseIfValidationFails();
        builder = new RequestSpecBuilder();
        builder.setBaseUri ("https://pokeapi.co/api/v2/berry/");
        reqspec =  builder.build();
        return reqspec;
    }

}
