# jms-spring-boot

Ejemplo de envio y recepción de mensajes mediante ActiveMQ.

## Requisitos :clipboard:

Es necesario contar con el siguiente software instalado en la pc.
 * [Apache ActiveMQ](https://activemq.apache.org/components/classic/download/)

### Ejecutar Apache ActiveMQ

Una vez finalizada la descarga, se debe descomprimir el archivo. Nos ubicamos en el directorio /bin y ejecutamos el siguiente comando (en linux):

```
sudo sh activemq start
```
Accedemos al panel de administración introduciendo en la barra de direcciones ```http://localhost:8161/```. Nos solicitara las credenciales (usuario: admin y password: admin)

### Clonar, compilar y ejecutar proyecto :wrench:

Para clonar:

```git clone https://github.com/Francisco-Castillo/jms-spring-boot.git```

Para compilar:

```mvn clean install```

Para ejecutar:

``` 
java -jar /ubicacion/proyecto/target/jms-spring-boot.jar
```

## Pruebas desde Postman :rocket:

### Enviar mensaje
```
POST http://localhost:8080/producer/send
```
Json de ejemplo:

```json
{
    "id":1,
    "name": "name",
    "type": "type"
}
```
Si el mensaje pudo ser enviado, el servicio responde:

```json
{
    "message": "Mensaje enviado exitosamente"
}
```
### Leer mensajes

```
GET http://localhost:8080/consumer
```
Si el mensaje pudo ser procesado correctamente, el servicio responde:

```json
{
    "id": 1,
    "name": "name",
    "type": "type"
}
```
