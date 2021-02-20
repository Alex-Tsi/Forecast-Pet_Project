# Weather-Pet_Project
## Принцип работы приложения

__На сервер localhost:8080 отправляются следующие запросы:__
- GET /api/weather - получение обработанного JSON нашим сервисом
- GET /api/weather/{id} - получение по ID данные из базы, после через ORM преобразование в объект и возвращение также в формате JSON
- POST /api/weather/ - добавление JSON в запрос, преобразование в объект и через ORM добавление в базу данных. Для этого в запросе в RequestBody не указывать ID в JSON-е
- PUT /api/weather/ - добавление JSON в запрос, преобразование в объект и через ORM изменение в базе данных уже существующий строки. Для этого в запросе в RequestBody
указывать ID в JSON-е
- DELETE /api/weather/{id} - удаление по ключу ID из базы данных
____


Данный сервис связан напрямую с 
Для корректной работы необходимо зарегистрироваться по [ссылке](https://openweathermap.org), получить appid key.

В application.properties проекта необходимо добавить appid key вместо myKeyValue. 

Также необхидмо выбрать город, для этого перейти по [ссылке](https://openweathermap.org/current), спуститься до раздела _'By city ID'_ скачать ZIP файл, 
и выбрать из списка городов нужный ID. Этот city_id необходимо добавить в application.properties проекта вместо cityId.

В application.properties указаны следующие поля
```java
spring.datasource.url=myConnectionToDB
spring.datasource.username=myLogin
spring.datasource.password=myPass
```
Вместо myConnectionToDB - указать url до базы данных.<br>
Вместо username - логин от базы данных.<br>
Вместо mypass - пароль от базы данных.<br>
Создать таблицу соответствующую DataWeather Entity.
