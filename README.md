#  Act1. Introducción a Spring Boot - Configuración y Primeros Controladores

## Información del Estudiante
* **Nombre:** Canseco Reyes Juan Carlos
* **Repositorio:** `CRJCact1_t4`
* **Servidor VPS IP:** `74.208.173.233`
* **Puerto Asignado:** `8081`

---

## Descripción del Proyecto
Este proyecto consiste en el desarrollo de una API REST básica construida con **Java** y **Spring Boot**, que expone endpoints para consultar información de identificación del servidor, estado del servicio con hora del sistema y datos del perfil del estudiante. La aplicación fue empaquetada como ejecutable `.jar` y desplegada en un servidor virtual privado (VPS) Linux ejecutándose en segundo plano mediante `nohup`.

---

## 🌐 Endpoints Desarrollados

| Método | Ruta Endpoint | Descripción | Controlador |
| :--- | :--- | :--- | :--- |
| `GET` | `/general/identificacion` | Devuelve la firma del alumno y la lista de rutas disponibles. | `GeneralController` |
| `GET` | `/general/status` | Devuelve el estatus del servicio y la hora actual formateada. | `GeneralController` |
| `GET` | `/estudiante/materias` | Devuelve la información personal simulada y lista de materias. | `EstudianteController` |

---

## 📋 Estructura de Respuestas (JSON)

### 1. GET `/general/identificacion`
```json
{
  "id": "Instancia perteneciente a Canseco Reyes Juan Carlos",
  "endpoint1": "/general/identificacion",
  "endpoint2": "/general/status",
  "endpoint3": "/estudiante/materias"
}
```

### 2. GET `/general/status`
```json
{
  "estado": "Servicio activo",
  "codigo": 200,
  "horaActual": "18:25:00 - 07/11/2026"

}
```

### 3. GET `/estudiante/materias`
```json
{
  "nombre": "Canseco Reyes Juan Carlos",
  "matricula": "12345678",
  "materiasEnCurso": [
    "Programacion Web",
    "Software para Toma de Decisiones",
    "Conmuntacion y Enrutamiento de Redes de Computadoras",
    "Taller de Investigacion I",
    "Sistemas Programables",
    "Lenguajes y Automatas II"
  ]
}
```
que no se copie al otro
