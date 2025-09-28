import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Main class to execute the JSON to CSV conversion.
 * Supports command-line arguments for configuration.
 *
 * Usage example:
 *   mvn exec:java -Dexec.mainClass="Main" -Dexec.args="data.json output.csv ;"
 */
public class Main {

    public static void main(String[] args) {
        String inputFile = "data.json";   // Default JSON file
        String outputFile = "output.csv"; // Default CSV file
        char delimiter = ',';             // Default delimiter

        // Read parameters from command line
        if (args.length >= 1) inputFile = args[0];
        if (args.length >= 2) outputFile = args[1];
        if (args.length >= 3) delimiter = args[2].charAt(0);

        try {
            // Step 1: Read JSON
            List<Map<String, Object>> jsonData = JsonReader.readJsonFile(inputFile);

            // Step 2: Transform data (in this case direct mapping)
            List<Map<String, Object>> transformedData = DataTransformer.transform(jsonData);

            // Step 3: Write CSV
            CsvWriter.writeCsvFile(transformedData, outputFile, delimiter);

            System.out.println("✅ Conversion completed! File generated: " + outputFile);

        } catch (IOException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
}
