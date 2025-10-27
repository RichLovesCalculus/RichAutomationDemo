package utils;

import java.util.HashMap;

public class PayloadFactory {

    //Need to figure out how to extract payloads from excel. Might not need this class.
    public static HashMap<String, Object> createUserPayload() {
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("name", "Updated Da shoowop wit PUT");
        payload.put("gender", "female");
        payload.put("email", "CleanCode1738@gmail.com");
        payload.put("status", "active");
        return payload;
    }

    public static HashMap<String, Object> updateField(String key, Object value) {
        HashMap<String, Object> payload = new HashMap<>();
        payload.put(key, value);
        return payload;
    }
}
