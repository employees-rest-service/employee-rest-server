# __EmployeeRestService__
## __Описание__
### Серверная часть приложения.

### __Функционал__
- Добавление сотрудника в БД;
- Удаление сотрудника из БД;
- Изменение данных существующего сотрудника;
- Просмотр всех сотрудников;
- Поиск сотрудника по его id;
<br>

## __Языки и инструменты__

[![IntelliJ IDEA](icons/intellij-idea-48.png)](https://www.jetbrains.com/idea/)
[![Java](icons/java-coffee-cup-48.png)](https://www.java.com/ru/)
[![Spring](icons/spring-48.png)](https://spring.io/)
[![Hibenate](icons/hibernate-1.png)](https://hibernate.org/)
[![XML](icons/xml-48.png)](https://www.xml.com/)
[![HTML](icons/html-48.png)](https://html.com/)
[![PostgreSQL](icons/pgSQL.png)](https://www.postgresql.org/)
[![Hibenate Validator](icons/hibernate-validator.png)](https://hibernate.org/validator/)
[![Apache Tomcat](icons/apache-tomcat-48.png)](https://tomcat.apache.org/)
[![Visual studio code](icons/visual-studio-code-2019-48.png)](https://code.visualstudio.com/)
<br>
<br>

## __Установка и настойка__
### Для запуска даного проекта нужно: 
1. Скачать [apache-tomcat](https://tomcat.apache.org/download-80.cgi).
2. Отредактировать конфигурацию указав путь к apache-tomcat.
3. Создать базу данных.
4. В [application.properties](https://github.com/Alexey7721/employee-rest-service/blob/master/src/main/resources/application.properties) заполнить данные БД(url, username, password):

```
database.url=URL
database.username=USERNAME
database.password=PASSWORD
```
5. Добавить таблицу в БД:
```
create table employees
(
    id           serial primary key,
    name         varchar(45),
    surname      varchar(45),
    email        varchar(45),
    salary       integer,
    department   varchar(45)
);
```




