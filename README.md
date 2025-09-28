# JSON to CSV Converter (Java + Maven)

Este repositorio contiene un programa de escritorio en **Java** que convierte archivos **JSON** a **CSV** utilizando **Jackson** y **OpenCSV**.  
Es útil para procesar datos en JSON y exportarlos a CSV de manera rápida, configurable y validada.

---

## 🚀 Funcionalidades
- **Lectura de JSON**: Lee un archivo JSON y lo mapea en una lista de objetos (`List<Map<String,Object>>`).
- **Transformación de datos**: Mapea los datos de JSON en una estructura tabular adecuada para CSV.
- **Escritura en CSV**: Exporta los datos a un archivo CSV con encabezados automáticos.
- **Parámetros configurables**:
  - Nombre de archivo de entrada (JSON).
  - Nombre de archivo de salida (CSV).
  - Delimitador configurable (`,`, `;`, `\t`, etc.).
- **Manejo de errores**: Archivos inexistentes, JSON mal formado o listas vacías.

---

## 📂 Estructura del proyecto
```
json-csv/
 ├─ src/main/java/com/example/FileHandler.java
 ├─ data.json         # Archivo JSON de ejemplo
 ├─ pom.xml           # Configuración de Maven
 └─ README.md
```

> ⚠️ La carpeta `target/` generada por Maven no debe subirse al repositorio.  
Agrega un `.gitignore` con `/target/` para ignorarla.

---

## ⚙️ Requisitos
- **Java 17** o superior.
- **Maven 3.6+** instalado y configurado en el `PATH`.

---

## 📦 Dependencias
Incluidas en `pom.xml`:
- [Jackson Databind](https://github.com/FasterXML/jackson) → Manejo de JSON.
- [OpenCSV](http://opencsv.sourceforge.net/) → Generación de CSV.

---

## ▶️ Ejecución

1. Clonar o descargar el repositorio:
   ```bash
   git clone https://github.com/TU_USUARIO/json-csv.git
   cd json-csv
   ```

2. Compilar el proyecto:
   ```bash
   mvn clean package
   ```

3. Ejecutar el programa:
   ```bash
   java -cp target/json-csv-1.0-SNAPSHOT.jar com.example.FileHandler <input.json> <output.csv> [delimiter]
   ```

   Ejemplo con delimitador `;`:
   ```bash
   java -cp target/json-csv-1.0-SNAPSHOT.jar com.example.FileHandler data.json output.csv ";"
   ```

---

## 📖 Ejemplo de uso

### `data.json`
```json
[
  {"id": 1, "name": "Alice", "email": "alice@example.com"},
  {"id": 2, "name": "Bob", "email": "bob@example.com"}
]
```

### Ejecución
```bash
java -cp target/json-csv-1.0-SNAPSHOT.jar com.example.FileHandler data.json output.csv ","
```

### `output.csv`
```csv
id,name,email
1,Alice,alice@example.com
2,Bob,bob@example.com
```

---

## 🔄 Algoritmo de transformación
1. El JSON se parsea como `List<Map<String,Object>>`.  
2. Se extraen las **keys** del primer objeto como encabezados del CSV.  
3. Cada objeto se convierte en una fila (`String[]`) con valores.  
4. Los valores nulos se reemplazan por `""` (vacío).  
5. El delimitador se configura mediante argumentos (`","`, `";"`, `"\t"`, etc.).  

---

## 📝 JavaDoc
El código incluye **JavaDoc** en:
- La clase principal `FileHandler`.
- Cada método (`readJsonFile`, `writeCsvFile`, `main`).  
Los comentarios explican:
- Propósito del método.
- Parámetros y valores de retorno.
- Ejemplos de uso.

---

## ✅ Checklist de verificación
- [x] Lectura de JSON desde archivo externo.  
- [x] Manejo de errores (archivo inexistente / JSON inválido).  
- [x] Conversión a estructura tabular con encabezados.  
- [x] Escritura en CSV configurable (ruta + delimitador).  
- [x] Documentación con JavaDoc.  
- [x] Instrucciones claras en README.md.  

---

## ✨ Notas
- Puedes modificar las rutas de entrada/salida o el delimitador en la ejecución.  
- El repositorio está listo para revisión por el **Digital NAO team**.  
