import app.App;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new App().initApp();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
