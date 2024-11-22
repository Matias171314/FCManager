# FCManager

**FCManager** es un sistema de gestión para equipos de fútbol. Permite registrar y gestionar jugadores, personal, partidos, estadísticas, finanzas y más, todo en un entorno offline con la opción de agregar soporte para bases de datos en el futuro.

Este proyecto tiene como objetivo facilitar a los administrativos de clubes deportivos el seguimiento y administración de las actividades y datos relacionados con el equipo.

---

## Características

- **Gestión de Jugadores**: Registrar información personal, contractuales y estadísticas de rendimiento.
- **Gestión de Personal**: Registrar entrenadores, médicos, y otros roles del club, con datos contractuales.
- **Gestión de Partidos**: Registrar los resultados de los partidos jugados, estadísticas de goles, asistencias, etc.
- **Calendario**: Organizar las actividades del club, como entrenamientos y partidos.
- **Gestión Financiera**: Llevar el control de los ingresos y egresos del club.

---

## Requisitos

Para ejecutar este proyecto, necesitarás:

- Java 11 o superior.
- NetBeans o cualquier IDE compatible con Java.
- Base de datos (si decides implementar SQL en el futuro).

---

## Instalación

1. **Clonar el repositorio:**
  ```bash
  git clone https://github.com/tu-usuario/FCManager.git
  ```

2. **Abrir el proyecto en NetBeans:**
  - Abre NetBeans y selecciona "Abrir Proyecto".
  - Navega hasta la carpeta donde clonaste el repositorio y selecciona el archivo del proyecto.

3. **Ejecutar el proyecto:**
  - Dentro de NetBeans, selecciona "Ejecutar Proyecto" para iniciar el sistema.

---

## Uso

### Registrar Jugador:
- Ingrese los datos personales como nombre, apellido, fecha de nacimiento, nacionalidad y posición.
- Registre las estadísticas del jugador, como goles, asistencias, etc.

### Registrar Personal:
- Ingrese el nombre, apellido, rol y datos contractuales del personal del club.

### Ver Informe del Equipo:
- Obtén un informe detallado de los jugadores y el personal del club.

### Gestión de Partidos:
- Registra los resultados de los partidos, incluyendo goles, tarjetas y más.

---

## Estructura del Proyecto

- **model/**: Contiene las clases principales del proyecto, como Player, Staff, Team, etc.
- **service/**: Clases para manejar la lógica del negocio y las operaciones.
- **database/**: Configuración y manejo de la base de datos (por si decides integrarlo más adelante).
- **ui/**: Interfaz de usuario (gráfica o de consola, dependiendo de lo que elijas).

---

## Contribuir

Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama para tu nueva característica (`git checkout -b feature/nueva-caracteristica`).
3. Realiza los cambios necesarios y haz commit (`git commit -am 'Añadir nueva característica'`).
4. Haz push a tu rama (`git push origin feature/nueva-caracteristica`).
5. Abre un pull request para que revisemos los cambios.

---

## Licencia

Este proyecto está licenciado bajo la Licencia MIT.