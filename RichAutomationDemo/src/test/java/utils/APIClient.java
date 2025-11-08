package utils;

import io.restassured.response.Response;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APIClient {
    private static final String SECRETS_FILE = "secrets.properties";
    private static final String OAUTH2_TOKEN_KEY = "oauth2.token";
    private static String authToken;
    private static boolean loaded = false;

    private static synchronized String getAuthToken() {
        if (!loaded) {
            SecretsLoader loader = new SecretsLoader(SECRETS_FILE);
            authToken = loader.get(OAUTH2_TOKEN_KEY);
            if (authToken == null || authToken.isEmpty()) {
                throw new IllegalStateException("OAuth2 token not found in secrets file");
            }
            loaded = true;
        }
        return authToken;
    }

    public static Response getUser(int id) {
        return given()
                .baseUri("https://gorest.co.in/public/v2")
                .auth().oauth2(getAuthToken())
                .when()
                .get("/users/" + id);
    }

    public static Response getUsers() {
        return given()
                .baseUri("https://gorest.co.in/public/v2")
                .auth().oauth2(getAuthToken())
                .when()
                .get("/users/");
    }

    public static Response createUser(Map<String, String> payload) {
        return given()
                .baseUri("https://gorest.co.in/public/v2")
                .auth().oauth2(getAuthToken())
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/users");
    }
}


