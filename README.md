# JSON to CSV Converter (Java + Maven)

This project is a **Java desktop utility** that reads a file in **JSON** format and converts it into a **CSV** file using libraries like **Jackson** and **OpenCSV**.  

---

## 🚀 Features
- Read a JSON file and parse its content into a list of objects (`List<Map<String,Object>>`).
- Transform JSON data into a tabular structure suitable for CSV.
- Write the data into a CSV file with automatically generated headers.
- Parameter configuration:
  - Input file name.
  - Output file name.
  - CSV delimiter.
- Error handling for:
  - Missing files.
  - Invalid JSON format.
  - Empty data.

---

## 📂 Project Structure
```
json-csv/
 ├─ src/
 │   ├─ main/
 │   │   ├─ java/
 │   │   │   ├─ Main.java              # Orchestrates the program
 │   │   │   ├─ JsonReader.java        # Handles JSON file reading
 │   │   │   ├─ CsvWriter.java         # Handles CSV file writing
 │   │   │   └─ DataTransformer.java   # Data transformation logic
 │   │   └─ resources/
 │   │       └─ data.json              # Example input file
 │   └─ test/                          # (Optional) Unit tests
 ├─ output.csv                         # Generated CSV file
 └─ pom.xml                            # Maven configuration
```

---

## ⚙️ Requirements
- **Java 17** or higher.  
- **Maven 3.6+** installed and available in the system `PATH`.  

---

## 📦 Dependencies
Declared in `pom.xml`:
- [Jackson Databind](https://github.com/FasterXML/jackson) → for JSON parsing.  
- [OpenCSV](http://opencsv.sourceforge.net/) → for CSV generation.  

---

## ▶️ How to Run
1. Clone or download the project.  
2. Compile the project with Maven:
   ```bash
   mvn clean install
   ```
3. Run the program (default JSON input: `src/main/resources/data.json`):
   ```bash
   mvn exec:java -Dexec.mainClass=Main
   ```
4. The program will:
   - Read `data.json`.  
   - Generate `output.csv` in the project root.  

---

## 📖 Example

### Input (`data.json`)
```json
[
  {"id": 1, "name": "Alice", "email": "alice@example.com"},
  {"id": 2, "name": "Bob", "email": "bob@example.com"}
]
```

### Output (`output.csv`)
```csv
id,name,email
1,Alice,alice@example.com
2,Bob,bob@example.com
```

---

## 🧩 Transformation Algorithm
1. Read the JSON file.  
2. Map objects into `List<Map<String,Object>>`.  
3. Extract column headers from the first object’s keys.  
4. Convert values to strings and build CSV rows.  
5. Write CSV file with the selected delimiter.  

---

## ✨ Notes
- Default file paths are configured in `Main.java`, but you can change them or pass parameters.  
- If `data.json` is missing or invalid, the program will print an error message.  
- If no data is found, no CSV will be generated.  

---
