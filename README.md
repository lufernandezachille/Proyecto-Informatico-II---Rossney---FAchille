# Proyecto-Informatico-II---Rossney---FAchille
> Desarrollado por *Lu y Juli*.

## Descripción
MOK es una aplicación web que permite a los usuarios crear y visualizar outfits a partir de prendas cargadas en el sistema. Utiliza una arquitectura de tres capas: frontend en HTML/CSS/JS, backend en Spring Boot (Java) y base de datos MySQL.

## Requisitos previos
Para ejecutar el proyecto, asegurarse de tener instalado:
- [Java JDK 21](https://www.oracle.com/java/technologies/downloads/) o superior
- [MySQL Server](https://dev.mysql.com/downloads/)
- [Git](https://git-scm.com/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) (recomendado para el backend)
- [Visual Studio Code](https://code.visualstudio.com/) (recomendado para el frontend)
- Extensión **Live Server** en VS Code (opcional pero recomendado)

## Pasos para ejecutar el proyecto
> 1. **Clonar el repositorio**

Abrir una terminal y ejecutar los siguientes comandos:
 
```bash
git clone https://github.com/tuusuario/mok.git
cd Proyecto-Informatico-II---Rossney---FAchille
```
 
---
 
> 2. **Configurar la base de datos (MySQL)**
 
**2.1** Abrir MySQL desde cualquiera de estas opciones:
- MySQL Workbench
- XAMPP (panel de control)
- Terminal / consola
  
**2.2** Crear la base de datos ejecutando:
 
```sql
CREATE DATABASE mok;
```
 
**2.3** Configurar las credenciales en el backend.  
Abrir el archivo:
 
```
mok-backend/src/main/resources/application.properties
```
 
Y reemplazar `TU_USUARIO` y `TU_PASSWORD` con los datos de tu instalación de MySQL:
 
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mok
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
 
---
 
> 3. **Ejecutar el backend (Spring Boot)**
 
**3.1** Abrir la carpeta `mok-backend` con IntelliJ IDEA.
 
**3.2** Ejecutar el servidor desde la terminal:
 
- En **Mac / Linux**:
```bash
./gradlew bootRun
```
 
- En **Windows**:
```bash
gradlew bootRun
```
 
**3.3** Verificar que el backend esté corriendo abriendo en el navegador:
 
```
http://localhost:8080
```
 
Si carga sin errores, el servidor está funcionando correctamente.
 
---
 
> 4. **Ejecutar el frontend**
 
**4.1** Abrir la carpeta `mok-frontend` con Visual Studio Code.
 
**4.2** Dos opciones para visualizarlo:
 
**Opción A — Simple (sin extensión):**  
Hacer doble click en el archivo `index.html`. Se abrirá en tu navegador por defecto.
 
**Opción B — Recomendada (con Live Server):**
1. Instalar la extensión **Live Server** desde el marketplace de VS Code.
2. Click derecho sobre `index.html`.
3. Seleccionar **"Open with Live Server"**.
El frontend estará disponible en:
 
```
http://127.0.0.1:5500
```
 
---
 
> 5. **Verificar la conexión frontend ↔ backend**
 
El frontend se comunica con el backend mediante peticiones HTTP. Por ejemplo:
 
```javascript
fetch("http://localhost:8080/api/outfits")
  .then(res => res.json())
  .then(data => console.log(data));
```
 
Asegurarse de que el backend esté corriendo **antes** de usar la app desde el navegador.
 

 

