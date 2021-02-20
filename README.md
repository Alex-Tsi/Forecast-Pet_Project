# Weather-Pet_Project
## Принцип работы приложения

На сервер localhost:8080 отправляются следующие запросы:

GET /api/weather - получение обработанного JSON нашим сервисом

GET /api/weather/{id} - получение по ID данные из базы, после через ORM преобразование в объект и возвращение также в формате JSON

POST /api/weather/ - добавление JSON в запрос, преобразование в объект и через ORM добавление в базу данных. Для этого в запросе в RequestBody не указывать ID в JSON-е

PUT /api/weather/ - добавление JSON в запрос, преобразование в объект и через ORM изменение в базе данных уже существующий строки. Для этого в запросе в RequestBody
указывать ID в JSON-е

DELETE /api/weather/{id} - удаление по ключу ID из базы данных




Данный сервис связан напрямую с https://openweathermap.org
-Для корректной работы необходимо зарегистрироваться по ссылке, получить appid key.

-В application.properties проекта необходимо добавить appid key вместо myKeyValue. 

-Также необхидмо выбрать город, для этого перейти по ссылке https://openweathermap.org/current, спуститься до раздела 'By city ID' скачать ZIP файл, 
и выбрать из списка городов нужный ID. Этот city_id необходимо добавить в application.properties проекта вместо cityId.

-В application.properties указаны следующие поля
spring.datasource.url=myConnectionToDB
spring.datasource.username=myLogin
spring.datasource.password=myPass
Вместо myConnectionToDB - указать url до базы данных. 
Вместо username - логин от базы данных
Вместо mypass - пароль от базы данных.

-Создать таблицу соответствующую DataWeather Entity.
