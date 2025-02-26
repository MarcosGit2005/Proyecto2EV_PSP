# Configurar un Servicio en Linux para el proyecto

Esta es una guia para hacer un servicio en Linux con systemd generando un archivo JAR ejecutable del proyecto usando IntelliJ IDEA.

## Creación del Archivo JAR con IntelliJ

1. **Abrir la carpeta del proyecto**: Inicia la aplicación y abre el proyecto.

2. **Cambiar la versión del JDK**:
   - Navegue al menú `File -> Project Structure` y seleccione la versión de SDK `Java 17`.
3. **Ejecutar el proyecto**
4. **Generar el archivo .jar**:

   -En la pestaña de la derecha de `Gradle` abrimos Tasks seguido de build y seleccionamos `bootJar`

   -Con esto el jar ejecutable se genera en `builds/libs`
   
Pasos para ejecutar el jar como un servicio:

1. **Mover el Archivo JAR al servidor**: Copiar el archivo a una carpeta del servidor como: `/opt/spring-app/spring-app.jar`.

2. **Generar el archivo del servicio con comandos**:
   - En una terminal:
     ```bash
     sudo nano /etc/systemd/system/spring-app.service
     ```
   - En el editor, agregue el siguiente contenido:
     ```ini
     [Unit]
     Description=Spring Boot Application
     After=network.target

     [Service]
     User=springuser
     ExecStart=/usr/bin/java /opt/spring-app/spring-app.jar --spring.config.location=/usr/bin/application.properties
     SuccessExitStatus=143
     Restart=on-failure
     RestartSec=10

     [Install]
     WantedBy=multi-user.target
     ```
   - Reemplace `/usr/bin/java` por la ruta a su ejecutable de JAVA y `/opt/spring-app/spring-app.jar` siendo la ruta del archivo JAR además de  `/usr/bin/application.properties` para las propiedades del programa.

3. **Habilitar el Servicio**:
   - En una terminal:
     ```bash
     sudo systemctl daemon-reload
     ```
   - Habilitar el servicio para iniciarlo automáticamente:
     ```bash
     sudo systemctl enable spring-app
     ```

4. **Iniciar el Servicio**:
   - Iniciar el servicio de manera manual:
     ```bash
     sudo systemctl start spring-app
     ```

5. **Verificar el correcto funcionamiento del servicio**:
   - En una terminal:
     ```bash
     sudo systemctl status spring-app
     ```
   - Si todo va bien el estado debería ser (running).

Si has seguido estos pasos has podido crear un servicio en Linux que lanza un archico ejecutable JAR del proyecto.
