package utils;

import io.restassured.response.Response;
import org.h2.util.json.JSONObject;

import static io.restassured.RestAssured.given;

public class APIClient {
    public static Response getUser(int id) {
        return given()
                .baseUri("https://gorest.co.in/public/v2")
                .auth().oauth2("your_token")
                .when()
                .get("/users/" + id);
    }

    public static Response createUser(JSONObject payload) {
        return given()
                .baseUri("https://gorest.co.in/public/v2")
                .auth().oauth2("your_token")
                .header("Content-Type", "application/json")
                .body(payload.toString())
                .when()
                .post("/users");
    }
}


