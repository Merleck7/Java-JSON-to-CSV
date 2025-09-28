import java.util.List;
import java.util.Map;

/**
 * Utility class to transform JSON data before exporting to CSV.
 * For now, it performs a direct mapping, but it can be extended
 * to apply validations, filters, or formatting rules.
 */
public class DataTransformer {

    /**
     * Transforms raw JSON data into a structure suitable for CSV writing.
     *
     * @param jsonData Input JSON data as List of Maps.
     * @return Transformed data (currently same as input).
     */
    public static List<Map<String, Object>> transform(List<Map<String, Object>> jsonData) {
        // Future transformations (validations, mapping, formatting) can go here
        return jsonData;
    }
}

