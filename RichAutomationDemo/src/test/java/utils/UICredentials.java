package utils;

public class UICredentials {
    private static final String SECRETS_FILE = "secrets.properties";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";

    private static String username;
    private static String password;
    private static boolean loaded = false;

    private static synchronized void loadCredentials() {
        if (loaded) return;

        SecretsLoader loader = new SecretsLoader(SECRETS_FILE);
        username = loader.get(USERNAME_KEY);
        password = loader.get(PASSWORD_KEY);
        loaded = true;
    }

    public static String getUsername() {
        loadCredentials();
        return username;
    }

    public static String getPassword() {
        loadCredentials();
        return password;
    }
}