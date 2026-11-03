# Task Manager Spring Boot

A simple and lightweight REST API for managing tasks, built with Java, Spring Boot, and Spring Data JPA. Developed for learning and practicing backend development fundamentals.

## 🛠 Tech Stack
* **Java 17 / 21**
* **Spring Boot 3.2.5** (Web, Data JPA)
* **H2 Database** (in-memory database for local development)
* **Maven** (dependency management & build tool)

## 🚀 API Endpoints

Base URL: `/api/tasks`

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/api/tasks` | Get a list of all tasks |
| **POST** | `/api/tasks` | Create a new task |
| **DELETE** | `/api/tasks/{id}` | Delete a task by ID |

### Example Request Body (JSON) for `POST`:
```json
{
    "title": "Learn Spring Data JPA",
    "description": "Connect the database and test persistence",
    "completed": false
}
