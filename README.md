# Sistema basico de citas medicas

Proyecto academico en Java para mostrar patrones de diseno dentro de un sistema sencillo de atencion medica.

La idea no es tener ejemplos separados por patron, sino un pequeno flujo real:

1. Se agenda una cita medica.
2. La cita cambia de estado durante la atencion.
3. El medico atiende una consulta interna, externa o especialista.
4. Se actualiza la historia clinica.
5. Se genera una receta medica.
6. Se genera un reporte general de la atencion.

## Estructura del proyecto

```text
src/
  Main.java
  modelo/       Datos basicos como Paciente
  citas/        Cita medica y estados de la cita
  consultas/    Flujo de atencion medica
  historias/    Historia clinica y control de versiones
  recetas/      Receta medica reutilizable
  reportes/     Reportes usando Visitor
```

## Patrones usados

### State

Modulo: `citas`

Permite que una cita cambie su comportamiento segun su estado actual. Por ejemplo, una cita programada se puede cancelar, pero una cita finalizada ya no se puede cancelar.

Estados usados:

- Programada
- En espera
- En consulta
- Finalizada
- Cancelada

### Template Method

Modulo: `consultas`

Define el flujo general de una consulta medica en la clase `ConsultaMedica`.

Todas las consultas siguen estos pasos:

1. Registrar llegada del paciente.
2. Iniciar consulta.
3. Evaluar paciente.
4. Actualizar historia clinica.
5. Generar receta.
6. Finalizar consulta.

Las clases `ConsultaInterna`, `ConsultaExterna` y `ConsultaEspecialista` cambian los detalles de evaluacion, diagnostico y receta.

### Memento

Modulo: `historias`

Permite guardar una version de la historia clinica antes de modificarla. Si se comete un error en el diagnostico o tratamiento, se puede restaurar la version anterior.

Clases principales:

- `HistoriaClinica`
- `HistoriaMemento`
- `HistorialCambios`

### Prototype

Modulo: `recetas`

Permite crear recetas nuevas a partir de una receta base. Esto evita escribir desde cero recetas que se repiten en varias consultas.

En este proyecto, `RecetaMedica` tiene el metodo `clonarPara(Paciente paciente)`.

### Visitor

Modulo: `reportes`

Permite generar reportes recorriendo varios elementos del sistema sin modificar sus clases principales.

Elementos visitados:

- Cita medica
- Historia clinica
- Receta medica

## Como ejecutar

Desde la raiz del proyecto:

```bash
javac -d out $(find src -name "*.java")
java -cp out Main
```
