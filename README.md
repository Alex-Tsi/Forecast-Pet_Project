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


Данный сервис связан напрямую с https://openweathermap.org/
1. Для корректной работы необходимо зарегистрироваться по [ссылке](https://openweathermap.org), получить appid key.

2. Также необхидмо выбрать город, для этого [скачать](http://bulk.openweathermap.org/sample/) список городов, представленных в формате **JSON** и своими **ID**, которые будут находиться в архиве.

3. В application.properties указаны следующие поля
```java
spring.datasource.url=myConnectionToDB
spring.datasource.username=myLogin
spring.datasource.password=myPass
api.weather.appid=myKeyValue
api.weather.city.id=cityId
```
__Заменить:__<br>
>myConnectionToDB - указать url БД;<br>
>username - логин от БД;<br>
>mypass - пароль от БД;<br>
>myKeyValue - appid key (личный ключ при регистрации);<br>
>cityId - получить из списка городов;<br>

4. Создать таблицу соответствующую DataWeather Entity.
