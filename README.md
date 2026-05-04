# Sistema basico de citas medicas

Proyecto academico en Java para practicar patrones de diseno en un sistema sencillo de atencion de citas medicas.

La idea del proyecto es mostrar los patrones dentro de un flujo basico, no como ejemplos separados. El sistema crea una cita, atiende una consulta, actualiza la historia clinica, genera una receta y muestra un reporte final.

## Estructura

```text
src/
  Main.java
  modelo/
    Paciente.java
  citas/
    Cita.java
    EstadoCita.java
  consultas/
    Consultas.java
  historias/
    HistoriaClinica.java
  recetas/
    Receta.java
  reportes/
    ReporteVisitor.java
```

## Flujo del programa

1. Se crea un paciente.
2. Se crea una cita medica.
3. Se atiende una consulta de especialista.
4. Se actualiza la historia clinica.
5. Se genera una receta medica.
6. Se corrige un error restaurando la historia anterior.
7. Se imprime un reporte final.

## Patrones usados

### State

Modulo: `citas`

Se usa en la clase `Cita` junto con `EstadoCita`. Permite cambiar el estado de la cita de forma sencilla.

Estados usados:

- Programada
- Finalizada
- Cancelada

Funcion en el sistema: controlar si una cita esta pendiente, terminada o cancelada.

### Template Method

Modulo: `consultas`

Se usa en `Consultas.java`. La clase base `ConsultaMedica` define los pasos generales de una consulta:

1. Registrar paciente.
2. Diagnosticar.
3. Recetar.
4. Finalizar.

Las consultas interna, externa y especialista cambian el diagnostico y la receta, pero conservan el mismo flujo.

Funcion en el sistema: evitar repetir el proceso general de atencion medica.

### Memento

Modulo: `historias`

Se usa en `HistoriaClinica`. Permite guardar una version de la historia clinica y restaurarla si se comete un error.

Funcion en el sistema: recuperar un diagnostico o tratamiento anterior.

### Prototype

Modulo: `recetas`

Se usa en `Receta`. Permite clonar una receta base para asignarla a un paciente.

Funcion en el sistema: reutilizar recetas comunes sin crearlas desde cero.

### Visitor

Modulo: `reportes`

Se usa en `ReporteVisitor`. Permite generar un reporte usando informacion de la cita, la historia clinica y la receta.

Funcion en el sistema: agregar una forma de reporte sin modificar mucho las clases principales.

## Como ejecutar

Desde la raiz del proyecto:

```bash
javac -d out $(find src -name "*.java")
java -cp out Main
```

## Resultado esperado

El programa muestra en consola:

- Registro del paciente.
- Atencion de la consulta.
- Estado final de la cita.
- Historia clinica.
- Receta medica.
- Restauracion de historia clinica.
- Reporte final.
