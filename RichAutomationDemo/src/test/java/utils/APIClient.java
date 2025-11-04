package utils;

import io.restassured.response.Response;
import org.h2.util.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class APIClient {
    private static final String authToken = loadToken();

    private static String loadToken() {
        Properties props = new Properties();
        try (InputStream input = APIClient.class.getClassLoader().getResourceAsStream("secrets.properties")) {
            props.load(input);
            return props.getProperty("oauth2.token");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load OAuth2 token", e);
        }
    }

    public static Response getUser(int id) {
        return given()
                .baseUri("https://gorest.co.in/public/v2")
                .auth().oauth2(authToken)
                .when()
                .get("/users/" + id);
    }

    public static Response getUsers() {
        return given()
                .baseUri("https://gorest.co.in/public/v2")
                .auth().oauth2(authToken)
                .when()
                .get("/users/");
    }

    public static Response createUser(JSONObject payload) {
        return given()
                .baseUri("https://gorest.co.in/public/v2")
                .auth().oauth2(authToken)
                .header("Content-Type", "application/json")
                .body(payload.toString())
                .when()
                .post("/users");
    }
}


