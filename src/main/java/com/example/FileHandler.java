package com.example;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Utility class for handling JSON and CSV file operations.
 */
public class FileHandler {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Reads a JSON file and parses its contents into a List of Maps.
     *
     * @param filePath Path to the JSON file.
     * @return A List of Maps representing the JSON data.
     * @throws IOException If the file is not found or cannot be parsed.
     */
    public static List<Map<String, Object>> readJsonFile(String filePath) throws IOException {
        try {
            return objectMapper.readValue(new File(filePath), new TypeReference<List<Map<String, Object>>>() {});
        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
            throw e; // rethrow for testing purposes
        }
    }

    /**
     * Writes a list of maps into a CSV file.
     *
     * @param data     The data to write (each map is a row, keys are columns).
     * @param filePath Path where the CSV file will be created.
     * @throws IOException If there is an error writing the CSV file.
     */
    public static void writeCsvFile(List<Map<String, Object>> data, String filePath) throws IOException {
        if (data == null || data.isEmpty()) {
            System.err.println("No data to write to CSV.");
            return;
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
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

        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Example main method for isolated testing of JSON reading and CSV writing.
     */
    public static void main(String[] args) {
        try {
            // Read JSON
            List<Map<String, Object>> jsonData = readJsonFile("data.json");
            System.out.println("JSON data read successfully!");

            // Write CSV
            writeCsvFile(jsonData, "output.csv");
            System.out.println("CSV file written successfully!");

        } catch (IOException e) {
            System.err.println("An error occurred during file operations.");
        }
    }
}
