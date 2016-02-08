package xml;

import java.io.IOException;
import java.io.InputStream;

public class ResourcesUtil {
    public InputStream getValidNameOfResource(String fileName) throws IOException {
        return getClass().getClassLoader().getResourceAsStream(fileName);
    }
}
