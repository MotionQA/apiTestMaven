import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class SmokeApiTests {
    private static final String BASE_URL = "http://localhost:8080";

    @Test
    public void createUserTest(){
        String bodyJson;
        bodyJson = """
                {
                "id": 0,
                "username": "string",
                "firstName": "string",
                "lastName": "string",
                "email": "string",
                "password": "string",
                "phone": "string",
                "userStatus": 0,
                }""";

        ValidatableResponse response = given()
                .header( "accept", "application/json")
                .header( "Content-Type" ,"application/json")
                .body(bodyJson)
                .when().post(BASE_URL )
                .then();
        response.statusCode(200);
        response.extract().response().prettyPrint();
    }
}



