import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Utility class for writing data into a CSV file.
 */
public class CsvWriter {

    /**
     * Writes a list of maps into a CSV file.
     *
     * @param data     The data to write (each map is a row, keys are columns).
     * @param filePath Path where the CSV file will be created.
     * @param delimiter The delimiter character (e.g., ',' or ';').
     * @throws IOException If there is an error writing the CSV file.
     */
    public static void writeCsvFile(List<Map<String, Object>> data, String filePath, char delimiter) throws IOException {
        if (data == null || data.isEmpty()) {
            System.err.println("⚠️ No data to write to CSV.");
            return;
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath), delimiter,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END)) {

            // Extract header from the first map
            String[] header = data.get(0).keySet().toArray(new String[0]);
            writer.writeNext(header);

            // Write rows
            for (Map<String, Object> row : data) {
                String[] line = row.values().stream()
                        .map(value -> value != null ? value.toString() : "")
                        .toArray(String[]::new);
                writer.writeNext(line);
            }
        }
    }
}
