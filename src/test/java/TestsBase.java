import api.API;
import api.models.Config.Config;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public abstract class TestsBase {

    private API api;
    private Config config;
    private boolean webClassTest = false;
    public TestsBase() {
        initConfig();
        prepareSeleniumDriver();
        getProperties();
        generateUsers();
        initAPI();
        downloadResources();
        initMockResources();
    }

    private static String readLineByLineJava8(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    public API getApi() {
        return api;
    }

    public Config getConfig() {
        return config;
    }

    private void generateUsers() {
    }

    private void initMockResources() {
    }

    private void downloadResources() {
    }

    private void initAPI() {
        api = new API(config);
    }

    private void initConfig() {
        Path filePath = Paths.get(System.getProperty("user.dir") + "/src/test/resources/" + System.getenv("config"));
        String c = readLineByLineJava8(filePath.toAbsolutePath().toString());
        config = new Gson().fromJson(new JsonParser().parse(c), Config.class);
    }

    private void getProperties() {
    }

    private void prepareSeleniumDriver() {


    }
}
