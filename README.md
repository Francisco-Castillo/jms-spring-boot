# jms-spring-boot

### Enviar mensaje
```
POST http://localhost:8080/producer/send
```
Json de ejemplo:

```
{
    "id":1,
    "name": "name",
    "type": "type"
}
```
Si el mensaje pudo ser enviado, el servicio responde:

```
{
    "message": "Mensaje enviado exitosamente"
}
```
### Leer mensajes

```
GET http://localhost:8080/consumer
```
Si el mensaje pudo ser procesado correctamente, el servicio responde:

```
{
    "id": 1,
    "name": "name",
    "type": "type"
}
```
