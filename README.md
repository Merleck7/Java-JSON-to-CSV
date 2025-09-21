# JSON to CSV Converter (Java + Maven)

Este proyecto es una utilidad en **Java** que permite leer un archivo en formato **JSON** y exportarlo a un archivo **CSV** utilizando librerías populares como **Jackson** y **OpenCSV**.  

---

## 🚀 Funcionalidades
- Leer un archivo JSON y parsearlo en una lista de objetos (`List<Map<String,Object>>`).
- Manejo de errores comunes:
  - Archivo inexistente.
  - Problemas de formato en el JSON.
- Escribir los datos en un archivo CSV con encabezados automáticos.
- Exportar el CSV con el mismo esquema de columnas que el JSON.

---

## 📂 Estructura del proyecto
```
json-csv/
 ├─ src/
 │   └─ main/
 │       └─ java/
 │           └─ com/example/
 │               └─ FileHandler.java
 ├─ data.json         # Archivo JSON de entrada
 ├─ output.csv        # Archivo CSV de salida (generado)
 └─ pom.xml           # Configuración de Maven
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
   mvn exec:java -Dexec.mainClass="com.example.FileHandler"
   ```
4. El programa:
   - Lee el archivo `data.json`.
   - Crea un archivo `output.csv` en la raíz del proyecto.  

---

## 📖 Ejemplo

### `data.json`
```json
[
  {"id": 1, "name": "Luis", "age": 22},
  {"id": 2, "name": "Ana", "age": 25}
]
```

### `output.csv`
```csv
id,name,age
1,Luis,22
2,Ana,25
```

---

## ✨ Notas
- Puedes modificar la ruta de entrada/salida en el código (`main` de `FileHandler`).
- Si `data.json` no existe o está vacío, el programa mostrará un mensaje de error.

---
