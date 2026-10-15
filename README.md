# Benchmark de Rendimiento: Spring Boot + Caché

Proyecto desarrollado para la asignatura **Diseño y Arquitectura de Software**.

## Descripción
Aplicación que mide la diferencia de rendimiento al consultar **50,000 registros** de una base de datos en memoria (H2) en comparación con el uso de caché en memoria de Spring Boot (`@Cacheable`).

## Resultados Obtenidos
* **Sin Caché (Base de Datos directa):** ~360 ms
* **Con Caché (Memoria RAM / Spring Cache):** ~1 ms

## Solución de CORS
En el entorno de desarrollo se utilizó la anotación `@CrossOrigin(origins = "*")` en el controlador REST para permitir que el frontend consuma los endpoints sin bloqueo de políticas del navegador de mismo origen (*Same-Origin Policy*).

## Cómo ejecutar el proyecto
1. Clonar el repositorio.
2. Abrir en IntelliJ IDEA / VS Code.
3. Ejecutar la clase `DemoApplication.java`.
4. Ingresar desde el navegador a `http://localhost:8080/`.