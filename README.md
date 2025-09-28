# JSON to CSV Converter (Java + Maven)

Este proyecto es una utilidad en **Java** que permite leer un archivo en formato **JSON** y exportarlo a un archivo **CSV** utilizando **Jackson** y **OpenCSV**.  

---

## 🚀 Funcionalidades
- Leer un archivo JSON y parsearlo en una lista de objetos (`List<Map<String,Object>>`).
- Manejo de errores comunes:
  - Archivo inexistente.
  - Problemas de formato en el JSON.
- Escribir los datos en un archivo CSV con encabezados automáticos.
- Exportar el CSV con el mismo esquema de columnas que el JSON.
- Permitir configuración de parámetros como nombre de archivo y delimitador desde argumentos de línea de comandos.

---

## 📂 Estructura del proyecto
```
json-csv/
 ├─ src/
 │   └─ main/
 │       └─ java/
 │           ├─ Main.java
 │           ├─ JsonReader.java
 │           ├─ CsvWriter.java
 │           └─ DataTransformer.java
 │
 │   └─ resources/
 │       └─ data.json       # archivo JSON de ejemplo
 │
 ├─ .gitignore              # ignora /target y archivos generados
 ├─ pom.xml                 # configuración de Maven
 ├─ README.md               # documentación del proyecto
 └─ output.csv              # generado al ejecutar el programa
```

---

## ⚙️ Requisitos
- **Java 17** o superior.
- **Maven 3.6+** instalado y configurado en el `PATH`.

---

## 📦 Dependencias
Incluidas en `pom.xml`:
- [Jackson Databind](https://github.com/FasterXML/jackson) → para manejar JSON.
- [OpenCSV](http://opencsv.sourceforge.net/) → para generar archivos CSV.

---

## ▶️ Ejecución
1. Clonar o descargar el proyecto.  
2. Compilar el proyecto con Maven:
   ```bash
   mvn clean install
   ```
3. Ejecutar el programa:
   ```bash
   mvn exec:java
   ```
   Por defecto:
   - Lee el archivo `data.json`.
   - Genera un archivo `output.csv` en la raíz del proyecto.
4. También puedes pasar parámetros:
   ```bash
   mvn exec:java -Dexec.args="data.json salida.csv ;"
   ```
   - `data.json` → archivo de entrada.  
   - `salida.csv` → archivo de salida.  
   - `;` → delimitador de columnas (ejemplo: `,` o `;`).

---

## 📖 Ejemplo

### `data.json`
```json
[
  {"id": 1, "name": "Luis", "email": "luis@example.com"},
  {"id": 2, "name": "Ana", "email": "ana@example.com"}
]
```

### `output.csv`
```csv
id,name,email
1,Luis,luis@example.com
2,Ana,ana@example.com
```

---

## 🔄 Algoritmo de Transformación
1. Leer JSON desde archivo o recursos.  
2. Mapear los datos a una lista de `Map<String,Object>`.  
3. Aplicar transformaciones (por ahora directo, pero se pueden agregar validaciones).  
4. Escribir CSV con encabezados automáticos y el delimitador elegido.  

---

## ✅ Checklist de verificación
- [x] Lectura de JSON desde archivo o `resources/`.
- [x] Manejo de errores (archivo no encontrado, JSON inválido, datos vacíos).  
- [x] Escritura correcta de CSV con encabezados.  
- [x] Parámetros configurables desde línea de comandos.  
- [x] Código modular (Main, JsonReader, CsvWriter, DataTransformer).  
- [x] Documentación con JavaDoc y README actualizado.  

---

## ✨ Notas
- Puedes cambiar el delimitador con argumentos (`;`, `,`, `|`, etc.).  
- Si `data.json` no existe o está vacío, el programa mostrará un mensaje de error.  
