package e2e;




import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import static e2e.CoreTest.*;
import static org.hamcrest.Matchers.*;

public class SmokeTest {


    @BeforeAll
    public void setGlobalVar(){
        urlBase += "http://localhost:8080/";
        token += "";
    }

    @Test
    public void testGet(){
        given().when().get(urlBase)
                .then().statusCode(200).body(is("Welcome to EducAPI! | VERSION: v1.0.4"));
    }

}
