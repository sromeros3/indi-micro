# Instruciones de uso

API REST que acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
Devuelve como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.

Integra base de datos H2 con la tabla del enunciado

La API REST tiene una única ruta GET /inditex/precio
Estos parámetros se deben pasar por URL en formato URLEncoded.

Para utilizar el proyecto, primero debes descargar el repositorio de GitHub y verificar que tienes la última versión de Maven instalada y Java en tu sistema. 

Luego, ejecuta los siguientes comandos en la línea de comandos en la carpeta raíz del proyecto:

- mvn validate
- mvn verify
- mvn clean install

Esto instalará las dependencias locales y compilará el proyecto, generando un archivo JAR final llamado calculadora-spring-boot.jar en la carpeta target.

Para ejecutar el proyecto, simplemente usa el comando:

java -jar target/"nombre-jar".jar
Esto iniciará la API REST en http://localhost:8080/inditex/precio.

Para probar la API, puedes enviar una solicitud GET a la ruta http://localhost:8080/inditex/precio con los parámetros requeridos. 

Por ejemplo:

GET http://localhost:8080/inditex/precio?fecha=2020-06-14T15:00:00.000Z&productoId=35455&cadenaId=1

Esto devuelve una respuesta con el resultado de la operación solicitada

## Tests
Para ejecutar los [tests](src/test/java) debes ejecutar el comando `mvn clean test`.
