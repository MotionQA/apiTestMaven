import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class SmokeApiTests {
    private static final String BASE_URL = "https://fakerestapi.azurewebsites.net/api/v1/";

    @Test
    public void createUserTest(){
        String bodyJson;
        bodyJson = """
                {
                  "id": 0,
                  "userName": "string",
                  "password": "string"
                }
               
                """;

        ValidatableResponse response = given()
                .header( "accept", " */*")
                .header( "Content-Type" ,"application/json")
                .body(bodyJson)
                .when().post(BASE_URL + "Users" )
                .then();
        response.statusCode(200
        );
        response.extract().response().prettyPrint();
    }
}



