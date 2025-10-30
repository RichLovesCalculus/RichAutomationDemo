package utils;

import java.util.HashMap;

public class PayloadFactory {

    public static HashMap<String, Object> createUserPayload() {
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("name", "Sofia Falcone");
        payload.put("gender", "male");
        payload.put("email", "CleanCodeSofia@gmail.com");
        payload.put("status", "active");
        return payload;
    }

    public static HashMap<String, Object> updateField(String key, Object value) {
        HashMap<String, Object> payload = new HashMap<>();
        payload.put(key, value);
        return payload;
    }
}
