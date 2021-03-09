package step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.time.LocalDateTime;


public class Hooks {


    @Before("@Test")
    /*
     Setup REST-Assured to work with the P&B API using ReqSpecBuilder
     */
    public void setup() {

    }

}
