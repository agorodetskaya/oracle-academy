import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourcesUtil {
    public InputStream getInputStreamOfResource(String fileName) throws IOException {
        return getClass().getClassLoader().getResourceAsStream(fileName);
    }

    public Properties loadPropertiesFromResources(Properties properties, String fileName) {
        try (InputStream inputStream = getInputStreamOfResource(fileName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
