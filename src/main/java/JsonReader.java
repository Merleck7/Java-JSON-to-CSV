import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Utility class for reading JSON files.
 */
public class JsonReader {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Reads a JSON file from resources or file system and parses its contents into a List of Maps.
     *
     * @param filePath Path to the JSON file.
     * @return A List of Maps representing the JSON data.
     * @throws IOException If the file is not found or cannot be parsed.
     */
    public static List<Map<String, Object>> readJsonFile(String filePath) throws IOException {
        // First try to load from resources
        InputStream inputStream = JsonReader.class.getClassLoader().getResourceAsStream(filePath);
        if (inputStream != null) {
            return objectMapper.readValue(inputStream, new TypeReference<>() {});
        }

        // If not found in resources, try as file system path
        return objectMapper.readValue(new java.io.File(filePath), new TypeReference<>() {});
    }
}
