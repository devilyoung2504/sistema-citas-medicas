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
    ConsultaMedica.java
    ConsultaInterna.java
    ConsultaExterna.java
    ConsultaEspecialista.java
  historias/
    HistoriaClinica.java
    HistoriaMemento.java
    HistorialCambios.java
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

Se usa en `ConsultaMedica.java`. La clase base `ConsultaMedica` define los pasos generales de una consulta:

1. Registrar paciente.
2. Diagnosticar.
3. Recetar.
4. Finalizar.

`ConsultaInterna`, `ConsultaExterna` y `ConsultaEspecialista` cambian el diagnostico y la receta, pero conservan el mismo flujo.

Funcion en el sistema: evitar repetir el proceso general de atencion medica.

### Memento

Modulo: `historias`

Se usa con `HistoriaClinica`, `HistoriaMemento` y `HistorialCambios`. Permite guardar una version de la historia clinica y restaurarla si se comete un error.

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

## Diagramas UML

Los diagramas UML de clase estan en:

```text
docs/uml.html
```

La pagina incluye diagramas para:

- State
- Template Method
- Memento
- Prototype
- Visitor

Cada diagrama tiene un boton para descargarlo como imagen PNG.

Referencias usadas para el diseno:

- Guia de clase `PatronesComportamiento.pptx.pdf`
- Refactoring Guru: https://refactoring.guru/es/design-patterns

## Justificacion de flechas UML

- **Herencia:** linea continua con triangulo blanco. Se usa en Template Method porque `ConsultaInterna`, `ConsultaExterna` y `ConsultaEspecialista` heredan de `ConsultaMedica`.
- **Asociacion dirigida:** linea continua con flecha. Se usa cuando una clase conoce o usa directamente a otra, por ejemplo `Cita` usa `EstadoCita`, `ConsultaMedica` usa `Cita` e `HistoriaClinica`, y `Receta` queda asociada a `Paciente`.
- **Agregacion:** linea continua con rombo blanco. Se usa en Memento porque `HistorialCambios` guarda varios `HistoriaMemento`, pero no son parte obligatoria permanente de la historia clinica.
- **Asociacion reflexiva:** linea continua que vuelve a la misma clase. Se usa en Prototype porque `Receta` crea una copia de si misma con `clonarPara()`.

## Resultado esperado

El programa muestra en consola:

- Registro del paciente.
- Atencion de la consulta.
- Estado final de la cita.
- Historia clinica.
- Receta medica.
- Restauracion de historia clinica.
- Reporte final.
