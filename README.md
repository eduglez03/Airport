# Proyecto Sistema de Gestión de Pasajeros y Vuelos
* Autor: Eduardo González Gutiérrez - alu0101461588
* Asignatura: Laboratorio y Desarrollo de Herramientas
* Grado en Ingeniería Informática, Universidad de La Laguna

## Descripción del Proyecto
Este proyecto implementa un sistema de gestión de pasajeros y vuelos en Java, diseñado para modelar las operaciones básicas de una aerolínea, como la asignación de pasajeros a vuelos, la verificación de capacidad, y el manejo de excepciones en casos de errores.

El desarrollo forma parte de la asignatura Laboratorio y Desarrollo de Herramientas, aplicando herramientas de análisis, documentación y control de dependencias como Maven, JUnit, y SonarCloud, para garantizar la calidad, testeo y documentación del código.
Por otra parte, se hace uso de este proyecto para llevar a cabo sobre él labores de integración continua mediante el uso de la herramienta de CI Jenkins

## Características

* Gestión de Pasajeros:
  * Validación de datos (código de país, identificador, etc.).
  * Asociación y cambio de vuelos para cada pasajero.

* Gestión de Vuelos:
  * Validación del formato del número de vuelo.
  * Gestión de capacidad y lista de pasajeros.

* Manejo de Errores:
  * Excepciones para datos inválidos y operaciones no permitidas (como exceder capacidad).

* Cobertura de Tests:
  * Tests unitarios exhaustivos para garantizar el correcto funcionamiento del sistema.

## Requisitos
* Java: Versión 11 o superior.
* Maven: Para la gestión de dependencias y compilación.
* JUnit 5: Para la ejecución de tests.
* SonarCloud: Para el análisis de la calidad y cobertura del código.

## Enlace a SonarCloud

[![Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=eduglez03%3AAirport)](https://sonarcloud.io/summary/new_code?id=eduglez03%3AAirport)
