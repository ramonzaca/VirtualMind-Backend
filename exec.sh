#!/bin/bash

echo "[1]. Ejecución del script de dase de datos"
echo
python databaseScript.py
echo "[2]. Creación del paquete jar"
echo
mvn clean install 
echo "[3]. Ejecución del jar"
echo
java -jar target/backend-0.0.1-SNAPSHOT.jar